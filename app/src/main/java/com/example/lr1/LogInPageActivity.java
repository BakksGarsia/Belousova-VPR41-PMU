package com.example.lr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.Menu;

public class LogInPageActivity extends AppCompatActivity {

    // private static final int NOTIFY_ID = 101;
    // private static final int CHANNEL_ID = 101;
    private static final String CHANNEL_NAME = "my channel";
    private static final String CHANNEL_ID = "channel_id";
    private static final int NOTIFY_ID = 111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);


        createNotificationChannel();
        Context context = getApplicationContext();

        Intent notificationIntent = new Intent(context,LogInPageActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Resources res = context.getResources();

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, CHANNEL_ID);
        notifyBuilder.setContentIntent(contentIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setContentTitle("Вам пришло важное сообщение")
                .setContentText("прочтите, вдруг там что-то важное");

        Notification notification = notifyBuilder.build();

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(NOTIFY_ID,notification);



        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Вы уже прочитали важное сообщение?")
                .setCancelable(false)
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(LogInPageActivity.this, "yes button pressed", Toast.LENGTH_SHORT);
                    }
                })
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(LogInPageActivity.this, "no button pressed", Toast.LENGTH_SHORT);
                    }
                });

       /* Toast toast = Toast.makeText(context, "Вам необходимо прочитать сообщение",Toast.LENGTH_LONG);
        toast.show();*/

        AlertDialog dialog = builder.create();
        dialog.setTitle("Question of the day");
        dialog.show();

    }

    private void createNotificationChannel(){
        CharSequence name = CHANNEL_NAME;
        String description = "my channel descriptions";
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,importance);
        channel.setDescription(description);

        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    public void startSearch(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }



}