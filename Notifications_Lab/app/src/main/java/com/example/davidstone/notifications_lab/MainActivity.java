package com.example.davidstone.notifications_lab;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        Intent intent = new Intent(this, SecondActivity.class);
        final PendingIntent pendingIntent = PendingIntent.getActivity(this, 984765, intent, 0);
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);

        notificationBuilder.setSmallIcon(android.R.drawable.ic_dialog_alert);
        notificationBuilder.setContentTitle("Notification Alert!");
        notificationBuilder.setContentText("Account Action Required");

        notificationBuilder.setAutoCancel(true);
        notificationBuilder.setPriority(Notification.PRIORITY_MAX);
        notificationBuilder.setContentIntent(pendingIntent);
        notificationBuilder.addAction(android.R.drawable.btn_plus, "Account Action Required", pendingIntent);

        NotificationCompat.BigPictureStyle pictureStyle = new NotificationCompat.BigPictureStyle();
        pictureStyle.bigPicture(BitmapFactory.decodeResource(getResources(), android.R.drawable.sym_def_app_icon));
        notificationBuilder.setAutoCancel(true);

        notificationBuilder.setStyle(pictureStyle);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            //    public void onClick(View view) {NotificationManagerCompat.from(MainActivity.this.notify();
            public void onClick(View view) {
                NotificationManagerCompat.from(MainActivity.this).notify(5, notificationBuilder.build());
            }
        });
    }



}
