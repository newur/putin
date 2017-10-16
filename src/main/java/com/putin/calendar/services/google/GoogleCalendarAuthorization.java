package com.putin.calendar.services.google;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.calendar.CalendarScopes;
import com.putin.user.util.UserSettingsMapper;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleCalendarAuthorization {

	private static final String APPLICATION_NAME = "Putin";
	private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getenv("putin_credentials"));
	private static FileDataStoreFactory DATA_STORE_FACTORY;
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static HttpTransport HTTP_TRANSPORT;
	private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR_READONLY);

	static {
		try {
			HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
			DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
		} catch (Throwable t) {
			t.printStackTrace();
			System.exit(1);
		}
	}

	private static AuthorizationCodeFlow initializeFlow() throws IOException {
		return new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT, JSON_FACTORY,
				"1015847485708-9quajuechksb90314nhm42l392r3dkv1.apps.googleusercontent.com", "oqQfVqdYMewCEeMR7PVMMa3C",
				SCOPES).setDataStoreFactory(
				DATA_STORE_FACTORY).setAccessType("offline").build();
	}

	public static Credential authorize(String code, String redirectUri) throws Exception {
		GoogleAuthorizationCodeInstalledAppExtended aciae = new GoogleAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		Credential credential = aciae.doAuthorize(UserSettingsMapper.getUserSettings().getUsername(), code, redirectUri);
		return credential;
	}

	static com.google.api.services.calendar.Calendar getCalendarService(String user) throws Exception {
		Credential credential = checkAuthorization(user);
		return new com.google.api.services.calendar.Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	public static Credential checkAuthorization(String user){
		GoogleAuthorizationCodeInstalledAppExtended aciae = null;
		try {
			aciae = new GoogleAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aciae.checkAuthorization(user);
	}

	public static String getGoogleLoginUri(String user, String redirectUri){
		GoogleAuthorizationCodeInstalledAppExtended aciae = null;
		try {
			aciae = new GoogleAuthorizationCodeInstalledAppExtended(initializeFlow(), new LocalServerReceiver());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return aciae.getGoogleLoginUri(redirectUri);
	}



}