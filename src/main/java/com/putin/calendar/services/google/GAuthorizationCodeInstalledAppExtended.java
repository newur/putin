package com.putin.calendar.services.google;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.java6.auth.oauth2.VerificationCodeReceiver;
import com.google.api.client.util.Preconditions;

import java.io.IOException;

public class GAuthorizationCodeInstalledAppExtended extends AuthorizationCodeInstalledApp {

    private final AuthorizationCodeFlow flow;
    private final VerificationCodeReceiver receiver;

    public GAuthorizationCodeInstalledAppExtended(
            AuthorizationCodeFlow flow, VerificationCodeReceiver receiver) {
        super(flow,receiver);
        this.flow = Preconditions.checkNotNull(flow);
        this.receiver = Preconditions.checkNotNull(receiver);
    }

    public Credential checkAuthorization(String userId){
        Credential credential = null;
        try {
            credential = flow.loadCredential(userId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (credential != null
                && (credential.getRefreshToken() != null || credential.getExpiresInSeconds() > 60)) {
            return credential;
        }
        return null;
    }

    public String getGoogleLoginUri(String redirectUri){
        AuthorizationCodeRequestUrl authorizationUrl =
                flow.newAuthorizationUrl().setRedirectUri(redirectUri);
        return authorizationUrl.build();
    }

    public Credential doAuthorize(String userId, String code, String redirectUri) throws IOException {
        try {
            TokenResponse response = flow.newTokenRequest(code).setRedirectUri(redirectUri).execute();
            return flow.createAndStoreCredential(response, userId);
        } finally {
            receiver.stop();
        }
    }

}
