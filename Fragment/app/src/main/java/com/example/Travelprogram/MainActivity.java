package com.example.Travelprogram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.hitomi.cmlibrary.CircleMenu;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
   /* String name[] = {"vikash"};
    CircleMenu circleMenu;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          // circleMenu = findViewById(R.id.circlemenu);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        BottomNavigationView bottomNav1 = findViewById(R.id.bottom_navigation1);
        bottomNav1.setOnNavigationItemSelectedListener(navListener1);

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Flight_book()).commit();
        }
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bottom_navigation, menu);
        return true;
    }
*/
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.flight:
                            selectedFragment = new Flight_book();
                            break;
                        case R.id.train:
                            selectedFragment = new Train_book();
                            break;
                        case R.id.bus:
                            selectedFragment = new Bus_book();
                            break;
                        case R.id.car:
                            selectedFragment = new Car_book();
                            break;

                        case R.id.cam:
                            selectedFragment = new Cam_Pic();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    private BottomNavigationView.OnNavigationItemSelectedListener navListener1 =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {

                        case R.id.home:
                            selectedFragment = new Flight_book();
                            break;

                        case R.id.trip:
                            selectedFragment = new Flight_book();
                            break;

                        case R.id.cash:
                            selectedFragment = new Flight_book();
                            break;
                        case R.id.cam:
                            selectedFragment = new Cam_Pic();
                            break;
                        case R.id.help:
                            selectedFragment = new Flight_book();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}