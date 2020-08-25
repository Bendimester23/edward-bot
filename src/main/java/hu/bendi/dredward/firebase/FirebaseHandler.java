package hu.bendi.dredward.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class FirebaseHandler {

    private FirebaseApp firebaseApp;

    public void init() {
        FirebaseOptions options = null;
        try {
            options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(new ByteArrayInputStream(System.getenv("FB_TOKEN").getBytes())))
                    .setDatabaseUrl("https://dredward-bot.firebaseio.com")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }
        firebaseApp = FirebaseApp.initializeApp(options);
    }
}
