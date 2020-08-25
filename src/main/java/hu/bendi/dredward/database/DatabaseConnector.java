package hu.bendi.dredward.database;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

public class DatabaseConnector {

    private Firestore firestore;

    public DatabaseConnector() {
        firestore = FirestoreClient.getFirestore();
    }
}
