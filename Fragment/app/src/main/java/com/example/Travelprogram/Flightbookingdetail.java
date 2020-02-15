package com.example.Travelprogram;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
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

                createnotificationchannel(); //Create method if android version is 8 or above

                Toast.makeText(Flightbookingdetail.this, "Passenger -"+passname+"\n"+"Contact -"+passcontact+"\n"+"Email -"+passemail, Toast.LENGTH_SHORT).show();
                //this method if android version is below 8
                String message = "This is a new message";

                NotificationCompat.Builder builder =
                        new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID);
                builder.setSmallIcon(R.drawable.flightbooked)
                        .setContentTitle("Booking Done")
                        .setContentText("Passenger -"+passname+"\n"+"Contact -"+passcontact+"\n"+"Email -"+passemail)

                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setAutoCancel(true);

                /*Intent notificationIntent = new Intent(getApplicationContext(), Flightbookingdetail.class);
                notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                notificationIntent.putExtra("message",message);
                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notificationIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);*/

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
