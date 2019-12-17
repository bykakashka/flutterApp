package by.byka.flutter_app;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.net.HttpURLConnection;
import java.net.URL;

import androidx.annotation.NonNull;

public class MessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage message) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://172.20.5.48:8080/test/message").openConnection();
            connection.connect();
        } catch (Exception e) {

        }
    }

    @Override
    public void onNewToken(@NonNull String s) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL("http://172.20.5.48:8080/test/token/" + s).openConnection();
            connection.connect();
        } catch (Exception e) {

        }
    }
}
