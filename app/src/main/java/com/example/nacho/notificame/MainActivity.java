package com.example.nacho.notificame;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private NotificationManager mNotifymanager;
    private static final int NOTIFICATION_ID=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mNotifyButton = (Button) findViewById(R.id.notify);
        mNotifymanager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendNotification();

            }
        });


    }

    public void sendNotification() {
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
            NotificationChannel mChannel = new NotificationChannel( "canalUno","canalUno", NotificationManager.IMPORTANCE_HIGH);
            mNotifymanager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder notifyBuilder =new NotificationCompat.Builder(this,"canalUno")
                .setContentTitle("Estás siendo notificado")
                .setContentText("Esta es su notificación")
                .setSmallIcon(R.drawable.ic_stat_name);

        Notification myNotification= notifyBuilder.build();
        mNotifymanager.notify(NOTIFICATION_ID, myNotification);

    }
}
