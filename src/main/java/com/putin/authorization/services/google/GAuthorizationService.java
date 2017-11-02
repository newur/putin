package com.putin.authorization.services.google;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.putin.calendar.services.google.GAuthorizationCodeInstalledAppExtended;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GAuthorizationService {

	private final String APPLICATION_NAME = "Putin";
	private final java.io.File DATA_STORE_DIR = new java.io.File(System.getenv("putin_credentials"));
	private FileDataStoreFactory DATA_STORE_FACTORY;
	private JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private HttpTransport HTTP_TRANSPORT;
	private List<String> SCOPES = new ArrayList<>();

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
				"1015847485708-9quajuechksb90314nhm42l392r3dkv1.apps.googleusercontent.com", "oqQfVqdYMewCEeMR7PVMMa3C",
				SCOPES).setDataStoreFactory(
				DATA_STORE_FACTORY).setAccessType("offline").build();
	}

	public Credential authorize(String username, String code, String redirectUri) throws Exception {
		GAuthorizationCodeInstalledAppExtended aciae = new GAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		Credential credential = aciae.doAuthorize(username, code, redirectUri);
		return credential;
	}

	public Credential checkAuthorization(String user){
		GAuthorizationCodeInstalledAppExtended aciae = null;
		try {
			aciae = new GAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aciae.checkAuthorization(user);
	}

	public String getGoogleLoginUri(String redirectUri){
		GAuthorizationCodeInstalledAppExtended aciae = null;
		try {
			aciae = new GAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aciae.getGoogleLoginUri(redirectUri);
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