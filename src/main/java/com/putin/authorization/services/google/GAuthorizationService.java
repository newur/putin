package com.putin.authorization.services.google;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RestController
public class GAuthorizationService {

	private final String APPLICATION_NAME = "Putin";
	private final java.io.File DATA_STORE_DIR = new java.io.File(System.getenv("putin_credentials"));
    private final String REDIRECT_URI = "http://localhost:8080/gAuthorize";
    private FileDataStoreFactory DATA_STORE_FACTORY;
	private JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private HttpTransport HTTP_TRANSPORT;
	private List<String> SCOPES = new ArrayList<>();
	private final VerificationCodeReceiver receiver = new LocalServerReceiver();


	public GAuthorizationService(){
		SCOPES = Arrays.asList("https://picasaweb.google.com/data/","https://www.googleapis.com/auth/calendar");
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	private AuthorizationCodeFlow initializeFlow() throws IOException {
		return new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY,
                "1015847485708-9quajuechksb90314nhm42l392r3dkv1.apps.googleusercontent.com",
                "oqQfVqdYMewCEeMR7PVMMa3C",SCOPES)
                .setDataStoreFactory(DATA_STORE_FACTORY)
                .setAccessType("offline")
                .build();
	}

    public String checkGoogleAuthorization(String user) throws IOException {
	    if(getFreshCredential(user) == null){
            return initializeFlow()
                    .newAuthorizationUrl()
                    .setRedirectUri(REDIRECT_URI)
                    .setState(user)
                    .build();
        }
        else
            return "success";
    }

    @RequestMapping("/gAuthorize")
    public void generateCredentialFromCode(HttpServletResponse response, String code, String state) throws IOException {
        try {
            AuthorizationCodeFlow authorizationCodeFlow = initializeFlow();
            TokenResponse tokenResponse = authorizationCodeFlow.newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute();
            authorizationCodeFlow.createAndStoreCredential(tokenResponse, state);
        } finally {
            receiver.stop();
        }
        response.sendRedirect("http://localhost:8080/index.html");
    }

    public Credential getFreshCredential(String user) {
        Credential credential = null;
        try {
            credential = initializeFlow().loadCredential(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (credential != null){
            if(credential.getExpiresInSeconds() > 60){
                return credential;
            }
            else{
                if(credential.getRefreshToken() != null){
                    try {
                        credential.refreshToken();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return credential;
                }
            }
        }
        return credential;
    }

	public JsonFactory getJSON_FACTORY() {
		return JSON_FACTORY;
	}

	public HttpTransport getHTTP_TRANSPORT() {
		return HTTP_TRANSPORT;
	}

	public String getAPPLICATION_NAME() {
		return APPLICATION_NAME;
	}
}