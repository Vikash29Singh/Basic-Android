package com.example.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tv;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        tv=(TextView)findViewById(R.id.tv);
        name = getIntent().getExtras().getString("Name");
        tv.setTextSize(35);
        tv.setText(name);
        Toast toast= (Toast) Toast.makeText(getApplicationContext(),  name,Toast.LENGTH_SHORT);
        toast.show();
        tv.setText(name);
        //Navigation Code
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.gmail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("email"));
                String[] s={"abcd@gmail.com"}; //put gmail to send message
                intent.putExtra(Intent.EXTRA_EMAIL,s);
                intent.putExtra(Intent.EXTRA_SUBJECT,"This is a subject");
                intent.putExtra(Intent.EXTRA_TEXT,"Hi! this is the Email body");
                intent.setType("message/rfc822");
                Intent choose= Intent.createChooser(intent,"Launch Email");
                startActivity(choose);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {


//
            Toast toast= (Toast) Toast.makeText(getApplicationContext(),  name,Toast.LENGTH_SHORT);
            toast.show();
            /*tv.setText(name);*/

            drawer.closeDrawer(GravityCompat.START);
        } else {


            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }  else if (id == R.id.nav_map) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo: 12.972442, 77.580643"));
            Intent chooser = Intent.createChooser(i, "Launch Maps");
            startActivity(chooser); // select the app in your phone to open the location ex: google map, uber, ola ….etc

        } else if (id == R.id.nav_call) {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:123456792")); // Enter number you want to call

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {

                Toast.makeText(this,"Please grant the permission to call",Toast.LENGTH_SHORT).show();
                requestPermission();
            }
            else {
                startActivity(intent);
            }




        } else if (id == R.id.nav_about) {
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Vikash29Singh/Basic-Android")); //put url you want to re-direct
            startActivity(i);

        } else if (id == R.id.nav_send) {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("email"));
            String[] s={"abc@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,s);
            intent.putExtra(Intent.EXTRA_SUBJECT,"This is a subject");
            intent.putExtra(Intent.EXTRA_TEXT,"Hi! this is the Email body");
            intent.setType("message/rfc822");
            Intent choose= Intent.createChooser(intent,"Launch Email");
            startActivity(choose);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
