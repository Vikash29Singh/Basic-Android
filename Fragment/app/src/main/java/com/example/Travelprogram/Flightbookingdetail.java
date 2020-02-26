package com.example.Travelprogram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Flightbookingdetail extends AppCompatActivity {
TextView tv1,tv2,tv3,tv4,tv5;
    TextInputEditText passengername,passengercontact , passengeremail;
    MaterialButton booktkt;
    String passname,passcontact,passemail;

    private final String CHANNEL_ID ="Personal Notification";
    private final int NOTIFICATION_ID =001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightbookingdetail);

        getSupportActionBar().setTitle("Flight Booking");
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#2c3e50"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tv1 = findViewById(R.id.tv1 );
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);

        passengername = findViewById(R.id.passengername );
        passengercontact = findViewById(R.id.passengercontact );
        passengeremail = findViewById(R.id.passengeremail );

        booktkt = findViewById(R.id.booktkt);

        String origin = getIntent().getStringExtra("origin");
        String destination = getIntent().getStringExtra("destination");
        String depart_time = getIntent().getStringExtra("depart_time");
        String arrival_time = getIntent().getStringExtra("arrival_time");
        String price = getIntent().getStringExtra("price");
        tv1.setText(origin);
        tv3.setText(destination);
        tv2.setText(depart_time);
        tv4.setText(arrival_time);
        tv5.setText(price);

        passengername = findViewById(R.id.passengername);
        passengeremail = findViewById(R.id.passengeremail);
        passengercontact = findViewById(R.id.passengercontact);



        /*passengername.setText(passname);
        passengercontact.setText(passcontact);
        passengeremail.setText(passemail);*/



        booktkt.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {

                passname = passengername.getText().toString();
                passcontact=passengercontact.getText().toString();
                passemail = passengeremail.getText().toString();

                Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                        R.drawable.flightbooked);

                createnotificationchannel(); //Create method if android version is 8 or above

                Toast.makeText(Flightbookingdetail.this, "Passenger -"+passname+"\n"+"Contact -"+passcontact+"\n"+"Email -"+passemail, Toast.LENGTH_SHORT).show();
                //this method if android version is below 8
                String message = "This is a new message";
                String bigtextpassenger = "Passenger -"+passname+"\n"+"Contact -"+passcontact+"\n"+"Email -"+passemail;

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
                builder.setSmallIcon(R.drawable.flightbooked)
                        .setContentTitle("Booking Done")
                        .setContentText(bigtextpassenger)
                       /* .setLargeIcon(R.drawable.flightbooked)*/
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

                        .setAutoCancel(true);

                /*Intent notificationIntent = new Intent(getApplicationContext(), Flightbookingdetail.class);
                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                notificationIntent.putExtra("message",message);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);*/



                NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
                bigText.bigText(bigtextpassenger);
                bigText.setBigContentTitle("Booking Done");
                bigText.setSummaryText("Passenger -"+passname);
                builder.setStyle(bigText);
                builder.setPriority(NotificationCompat.PRIORITY_MAX);

                // Creates an explicit intent for an Activity in your app
                Intent resultIntent = new Intent(getApplicationContext(),
                        MainActivity.class);

                // The stack builder object will contain an artificial back
                // stack for
                // the
                // started Activity.
                // getApplicationContext() ensures that navigating backward from
                // the Activity leads out of
                // your application to the Home screen.
                TaskStackBuilder stackBuilder = TaskStackBuilder
                        .create(getApplicationContext());

                // Adds the back stack for the Intent (but not the Intent
                // itself)
                stackBuilder.addParentStack(MainActivity.class);

                // Adds the Intent that starts the Activity to the top of the
                // stack
                stackBuilder.addNextIntent(resultIntent);
                PendingIntent resultPendingIntent = stackBuilder
                        .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(resultPendingIntent);

                /*NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                // mId allows you to update the notification later on.
                mNotificationManager.notify(100, mBuilder.build());


*/



                NotificationManagerCompat manager = NotificationManagerCompat.from(getApplicationContext());
                manager.notify(NOTIFICATION_ID, builder.build());


            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createnotificationchannel()
    {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O);
        {
            CharSequence name = "Personal Notification";
            String description = "Include all the personal Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,name,importance);
            notificationChannel.setDescription(description);
            NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            manager.createNotificationChannel(notificationChannel);
        }


    }
}
