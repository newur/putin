package com.putin.photos.services.google;

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
import com.google.gdata.client.photos.PicasawebService;
import com.google.gdata.data.MediaContent;
import com.google.gdata.data.photos.*;
import com.google.gdata.util.ServiceException;
import com.putin.calendar.services.google.GoogleAuthorizationCodeInstalledAppExtended;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class GooglePhotoService {

    private static final String APPLICATION_NAME = "Putin";
    private static final java.io.File DATA_STORE_DIR = new java.io.File(System.getenv("putin_credentials"));
    private static FileDataStoreFactory DATA_STORE_FACTORY;
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static HttpTransport HTTP_TRANSPORT;
    private static final List<String> SCOPES = Arrays.asList(
            "https://picasaweb.google.com/data/",
            CalendarScopes.CALENDAR_READONLY);
    static {
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            DATA_STORE_FACTORY = new FileDataStoreFactory(DATA_STORE_DIR);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }

    public void getPhotos() throws IOException, ServiceException {
        PicasawebService picasawebService = new PicasawebService("Putin");
        Credential credential = checkAuthorization("Vladi");
        picasawebService.setOAuth2Credentials(credential);

        URL feedUrl = new URL("https://picasaweb.google.com/data/feed/api/user/lapotschka.putin@gmail.com/albumid/6481690100628020145");
        AlbumFeed feed = picasawebService.getFeed(feedUrl, AlbumFeed.class);

        for (GphotoEntry gPhotoEntry : feed.getEntries()) {
            //get photo url
        }
    }

    public void getAlbums() throws IOException, ServiceException {
        PicasawebService picasawebService = new PicasawebService("Putin");
        Credential credential = checkAuthorization("Vladi");
        picasawebService.setOAuth2Credentials(credential);

        URL feedUrl = new URL("https://picasaweb.google.com/data/feed/api/user/lapotschka.putin@gmail.com?kind=album");
        UserFeed myUserFeed = picasawebService.getFeed(feedUrl, UserFeed.class);

        for (GphotoEntry gPhotoEntry : myUserFeed.getEntries()) {
            System.out.println(gPhotoEntry.getTitle().getPlainText());
            System.out.println(gPhotoEntry.getGphotoId());
        }
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

    private static AuthorizationCodeFlow initializeFlow() throws IOException {
        return new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY,
                "1015847485708-9quajuechksb90314nhm42l392r3dkv1.apps.googleusercontent.com", "oqQfVqdYMewCEeMR7PVMMa3C",
                SCOPES).setDataStoreFactory(
                DATA_STORE_FACTORY).setAccessType("offline").build();
    }


}
