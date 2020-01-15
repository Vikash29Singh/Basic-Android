package com.example.myapplication;

/*
https://github.com/piruin/quickaction
https://github.com/lorensiuswlt/NewQuickAction
*/

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashIndex extends AppCompatActivity {

    private TextView tv;
    private ImageView iv,iv1;
    Animation ud, du;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_index);


        iv = findViewById(R.id.iv);
        //iv1 = findViewById(R.id.iv1);
        /*ud = AnimationUtils.loadAnimation(this, R.anim.ud);
        du = AnimationUtils.loadAnimation(this, R.anim.du);
        */
        Animation myanimleft = AnimationUtils.loadAnimation(this,R.anim.rotate);
        //Animation myanimright = AnimationUtils.loadAnimation(this,R.anim.rotate1);
              /* tv.startAnimation(myanim);
        tv.startAnimation(ud);*/
        iv.startAnimation(myanimleft);
       // iv1.startAnimation(myanimright);




        isInternetOn();
    }

    public final boolean isInternetOn() {

        // get Connectivity Manager object to check connection
        ConnectivityManager connec =
                (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if ( connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED ) {

            // if connected with internet
            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            final Intent i = new Intent(this, Index.class);
            Thread timer = new Thread() {
                public void run () {
                    try {
                        sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        startActivity(i);
                        finish();
                    }
                }
            };
            timer.start();

            return true;

        } else if (
                connec.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.DISCONNECTED  ) {
            //Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            final Intent i = new Intent(this, Nointernet.class);
            Thread timer = new Thread() {
                public void run () {
                    try {
                        sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        startActivity(i);
                        finish();
                    }
                }
            };
            timer.start();

/*            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Do you want to enable internet ?")
                    .setName("No Internet")
                    .setIcon(R.drawable.alerticon)
                    .setCancelable(false)
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //finish();
                            startActivity(new Intent(getApplicationContext(),Index.class));
                            *//*Toast.makeText(getApplicationContext(),"you choose yes action for alertbox",
                                    Toast.LENGTH_SHORT).show();*//*
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            System.exit(0);
                            //dialog.cancel();
                            *//*Toast.makeText(getApplicationContext(),"you choose no action for alertbox",
                                    Toast.LENGTH_SHORT).show();*//*
                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            //alert.setName("AlertDialogExample");
            alert.show();*/

            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }


}
