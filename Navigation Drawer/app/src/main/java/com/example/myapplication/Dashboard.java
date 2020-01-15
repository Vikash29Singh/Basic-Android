package com.example.myapplication;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.Calendar;

public class Dashboard extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView tv,tv1,textView1,textView2, textView3, textView4,textView5,textView6, picker_date,picker_time, v_no;
    Button buy,place_order;
    String name;
    AlertDialog.Builder builder;
    CardView bat,ball,pad,gloves,helmet,stump;
    ImageButton buttonleft , buttonright;
    private ImageSwitcher imageSwitcher;
    int imageno[] = {R.drawable.gully_bat,R.drawable.gully_bat2 , R.drawable.deuce_bat , R.drawable.deuce_bat2 , R.drawable.redtennis_bat};
    //counting Image

    int count = imageno.length;
    int currentImage = -1;
    String time,date;

    /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    View headerView = navigationView.getHeaderView(0);
    TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername);
navUsername.setText("Your Text Here");*/

    private TextSwitcher textSwitcher1,textSwitcher2,textSwitcher3,textSwitcher4,textSwitcher5,textSwitcher6;
   // private int stringindex = 0;
    private String[] batName= {"ELEVAR","ICON","MRF","SUPER SERIES","NEW BALANCE"};
    private String[] price = {"Rs. 472","Rs. 546","Rs. 1461","Rs. 648","Rs. 1053"};//736,987,
    private String[] strikePrice = {"Rs. 736","Rs. 650","Rs. 1948","Rs. 1245","Rs. 1645"};//736,987,
    private String[] disc = {"36% off","16% off","25% off","48% off","36% off"};//736,987,
    private String[] review = {"365","115","96","783","238"};//736,987,
    private String[] ratting = {"4.2","3.4","4.7","3.8","4.5"};//736,987,

    int counttext = batName.length;
    int counttext1 = price.length;
    int counttext2 = strikePrice.length;
    int counttext3 = disc.length;
    int counttext4 = review.length;
    int counttext5 = ratting.length;

    int currentText = -1;

    Button btn_date,btn_time;

    Dialog myDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //Image button and image switcher ID


        myDialog = new Dialog(this);
        bat = findViewById(R.id.bat);
        ball = findViewById(R.id.ball);
        gloves = findViewById(R.id.gloves);
        stump = findViewById(R.id.stump);
        helmet = findViewById(R.id.helmet);
        pad = findViewById(R.id.pad);
        buy = findViewById(R.id.buy);



        registerForContextMenu(bat);
        /*registerForContextMenu(ball);
        registerForContextMenu(gloves);
        registerForContextMenu(stump);
        registerForContextMenu(helmet);
        registerForContextMenu(pad);*/


       /* tv=(TextView)findViewById(R.id.tv);
        tv1=(TextView)findViewById(R.id.tv1);
        name = getIntent().getExtras().getString("Name");
       //tv.setTextSize(35);
        tv1.setText(name);*/
        //tv1=(TextView)findViewById(R.id.tv1);
        name = getIntent().getExtras().getString("Name");
        //tv1.setText(name);
        Toast toast= Toast.makeText(getApplicationContext(),  name,Toast.LENGTH_SHORT);
        toast.show();

      /*  Toast toast= (Toast) Toast.makeText(getApplicationContext(),  name,Toast.LENGTH_SHORT);
        toast.show();
        tv.setText(name);*/
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
                String[] s={"cricket.gear@gmail.com"}; //put gmail to send message
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
        View headerView = navigationView.getHeaderView(0);
        tv1=headerView.findViewById(R.id.tv1);
        tv1.setText(name);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        //Image switcher code

        /*NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.navUsername);
        navUsername.setText("Your Text Here");*/


        //on card view click
        //Bat cardview
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),BatCategory.class));
            }
        });
    }

   /* public void scheduleOrder(View v)
    {
        TextView txtclose;
        myDialog.setContentView(R.layout.schedulepopup);
        txtclose = myDialog.findViewById(R.id.txtclose);


        txtclose.setText("X");
        txtclose.setTextColor(Color.BLACK);


        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.setCancelable(false);
        myDialog.show();
    }*/
public void Scheduleorder()
{
    TextView txtclose;
    myDialog.setContentView(R.layout.schedule_popup);
    btn_time = myDialog.findViewById(R.id.btn_time);
    btn_date = myDialog.findViewById(R.id.btn_date);
     picker_date = myDialog.findViewById(R.id.picker_date);
     picker_time = myDialog.findViewById(R.id.picker_time);
    place_order= myDialog.findViewById(R.id.place_order);
    v_no =myDialog.findViewById(R.id.v_no);

    txtclose = myDialog.findViewById(R.id.txtclose);

    txtclose.setText("X");
    txtclose.setTextColor(Color.BLACK);

    txtclose.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            myDialog.dismiss();
        }
    });

    btn_date.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDay = c.get(Calendar.DAY_OF_MONTH);


            final DatePickerDialog datePickerDialog = new DatePickerDialog(Dashboard.this, R.style.AppTheme_Dark_Dialog,
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {


                           picker_date.setText( dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                           date= picker_date.getText().toString();

                        }

                    }, mYear, mMonth, mDay);
            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

            datePickerDialog.show();
        }
    });

    btn_time.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            final Calendar c = Calendar.getInstance();
            int mHour = c.get(Calendar.HOUR_OF_DAY);
            int mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(Dashboard.this, R.style.AppTheme_Dark_Dialog,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            picker_time.setText(hourOfDay + ":" + minute);
                            time= picker_time.getText().toString();
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();

        }
    });


    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    myDialog.setCancelable(false);
    myDialog.show();

    place_order.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String text=v_no.getText().toString().trim();
            date=picker_date.getText().toString().trim();
            time=picker_time.getText().toString().trim();

            if (TextUtils.isEmpty(text)){
                v_no.setError("Please Enter a username!");


            }

            if (TextUtils.isEmpty(date)){
                v_no.setError("Please Enter date!");
            }


            if (TextUtils.isEmpty(time)){
                v_no.setError("Please Enter time!");
            }

            else {
                builder = new AlertDialog.Builder(Dashboard.this);
                builder.setTitle("Alert")
                        .setMessage("Order will be Delivered by :" + date + "\nAt or after :" + time)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final Intent intent = new Intent(getApplicationContext(), Dashboard.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton(null, null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }


            /*Toast.makeText(Dashboard.this, "Order will be Delivered to you by :"+date + "\n" + "At or after :"+time, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Dashboard.class));
        */}
    });




}
    public void ShowPopup() {
        TextView txtclose;

        /*btn_date= myDialog.findViewById(R.id.btn_date);
        btn_time= myDialog.findViewById(R.id.btn_time);*/


        myDialog.setContentView(R.layout.custompopup);

        buttonright = myDialog.findViewById(R.id.buttonright);
        buttonleft = myDialog.findViewById(R.id.buttonleft);
        imageSwitcher = myDialog.findViewById(R.id.changeimage);
        textSwitcher1 = myDialog.findViewById(R.id.textSwitcher1);
        textSwitcher2 = myDialog.findViewById(R.id.textSwitcher2);
        textSwitcher3 = myDialog.findViewById(R.id.textSwitcher3);
        textSwitcher4 = myDialog.findViewById(R.id.textSwitcher4);
        textSwitcher5 = myDialog.findViewById(R.id.textSwitcher5);
        textSwitcher6 = myDialog.findViewById(R.id.textSwitcher6);

        txtclose = myDialog.findViewById(R.id.txtclose);

        buy = myDialog.findViewById(R.id.buy);

        /*TextView strikeText= myDialog.findViewById(R.id.strikeText);
        strikeText.setTextColor(Color.GRAY);
        strikeText.setPaintFlags(strikeText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);*/
        txtclose.setText("X");
        txtclose.setTextColor(Color.BLACK);


        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                imageView.setImageResource(R.drawable.deuce_bat3);
                return imageView;
            }
        });

        //imageSwitcher.setImageResource(imageno[currentImage]);
        textSwitcher1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView1 = new TextView(getApplicationContext());
                textView1.setTextColor(Color.WHITE);
                //textView1.setGravity(Gravity.CENTER_HORIZONTAL);
                //textView1.setTextSize(10);
                textView1.setText("New Arrival");
                return textView1;
            }
        });

        textSwitcher2.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView2 = new TextView(getApplicationContext());
                textView2.setTextColor(Color.WHITE);
                //textView1.setGravity(Gravity.CENTER_HORIZONTAL);
                //textView1.setTextSize(10);
                textView2.setText("");
                return textView2;
            }
        });

        textSwitcher3.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView3 = new TextView(getApplicationContext());

                textView3.setTextColor(Color.GRAY);
                textView3.setPaintFlags(textView3.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                textView3.setText("");
                return textView3;
            }
        });

        textSwitcher4.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView4 = new TextView(getApplicationContext());
                textView4.setTextColor(Color.GREEN);
/*
                textView4.setTextColor(Color.GRAY);
                textView4.setPaintFlags(textView4.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);*/
                textView4.setText("Comming Soon");
                return textView4;
            }
        });

        textSwitcher5.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView5 = new TextView(getApplicationContext());
                textView5.setTextColor(Color.WHITE);
                textView5.setText("-");
                return textView5;
            }
        });

        textSwitcher6.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                textView6 = new TextView(getApplicationContext());
                textView6.setTextColor(Color.WHITE);
                Drawable img = getResources().getDrawable(R.drawable.ic_star_black_24dp);
                textView6.setCompoundDrawablesWithIntrinsicBounds( null, null, img, null);
                textView6.setText("-");
                return textView6;
            }
        });



        //textSwitcher1.setText(batName[stringindex]);

        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        textSwitcher1.setAnimation(in);
        textSwitcher1.setAnimation(out);
        textSwitcher2.setAnimation(in);
        textSwitcher2.setAnimation(out);
        textSwitcher3.setAnimation(in);
        textSwitcher3.setAnimation(out);
        textSwitcher4.setAnimation(in);
        textSwitcher4.setAnimation(out);
        textSwitcher5.setAnimation(in);
        textSwitcher5.setAnimation(out);
        textSwitcher6.setAnimation(in);
        textSwitcher6.setAnimation(out);


        buttonright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentImage++;
                currentText++;
                imageSwitcher.setImageResource(imageno[currentImage]);
                textSwitcher1.setText(batName[currentText]);
                textSwitcher2.setText(price[currentText]);
                textSwitcher3.setText(strikePrice[currentText]);
                textSwitcher4.setText(disc[currentText]);
                textSwitcher5.setText(review[currentText]);
                textSwitcher6.setText(ratting[currentText]);

                if(((currentImage + 1) >= count) && ((currentText +1) >= counttext) && ((currentText +1) >= counttext1) && ((currentText +1) >= counttext2) && ((currentText +1) >= counttext3) && ((currentText +1) >= counttext4) && ((currentText +1) >= counttext5))
                {
                    buttonright.setEnabled(false);
                    Toast.makeText(Dashboard.this, "Comming Soon", Toast.LENGTH_SHORT).show();
                    buttonright.setVisibility(View.GONE);
                    /*stringindex = 0;
                    textSwitcher1.setText(batName[stringindex]);*/

                }

               /* if(currentText == counttext)
                {
                    currentText = 0;
                    textSwitcher1.setText(batName[currentText]);
                }*/

                if (((currentImage - 1) >= 0  ) && ((currentText - 1) >= 0) )
                {
                    buttonleft.setEnabled(true);
                    buttonright.setVisibility(View.VISIBLE);
                }

                   // count=1;
                    //show Image


            }

        });

        buttonleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                currentImage -= 1;
                currentText -= 1;
                imageSwitcher.setImageResource(imageno[currentImage]);
                textSwitcher1.setText(batName[currentText]);
                textSwitcher2.setText(price[currentText]);
                textSwitcher3.setText(strikePrice[currentText]);
                textSwitcher4.setText(disc[currentText]);
                textSwitcher5.setText(review[currentText]);
                textSwitcher6.setText(ratting[currentText]);

                if(((currentImage - 1) < 0) && ((currentText - 1) < 0))
                {

                    buttonleft.setEnabled(false);
                    Toast.makeText(Dashboard.this, "Comming Soon", Toast.LENGTH_SHORT).show();
                    buttonleft.setVisibility(View.GONE);
                }

                if (((currentImage + 1) < count) && ((currentText + 1) < counttext) && ((currentText + 1) < counttext1)  && ((currentText + 1) < counttext2) && ((currentText + 1) < counttext3) && ((currentText + 1) < counttext4) && ((currentText + 1) < counttext5))
                {
                    buttonright.setEnabled(true);
                    buttonleft.setVisibility(View.VISIBLE);
                }
            }
        });

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Dashboard.this, "Added in cart", Toast.LENGTH_SHORT).show();
            }
        });
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.setCancelable(false);
        myDialog.show();
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

            builder = new AlertDialog.Builder(this);
            builder.setTitle("Alert")
                    .setMessage("Are you sure you want to logout ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            final Intent intent = new Intent(getApplicationContext(),Login.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.bat_menu, menu);
        //getMenuInflater().inflate(R.menu.ball_menu, menu);

    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.bat_plastic:
                Toast.makeText(this, "Plastic Bat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.bat_tennis_red:
                Toast.makeText(this, "Red Tennis Bat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.bat_tennis_green:
                Toast.makeText(this, "Green Tennis Bat", Toast.LENGTH_SHORT).show();
                return true;

           /* case R.id.bat_deuce:
                Toast.makeText(this, "Deuce Bat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ball_tennis_red:
                Toast.makeText(this, "Red Tennis Ball", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ball_tennis_green:
                Toast.makeText(this, "Green Tennis Ball", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.ball_deuce:
                Toast.makeText(this, "Deuce Ball", Toast.LENGTH_SHORT).show();
                return true;*/

            default:

                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId())
        {
            case R.id.action_schedule:
                Scheduleorder();

                return true;
            case R.id.action_arrival:
                ShowPopup();
                return  true;
            case R.id.action_call:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:8876041514")); // Enter number you want to call

                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(this,"Please grant the permission to call",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }
                else {
                    startActivity(intent);
                }
                return true;

            case  R.id.action_logout:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Alert")
                        .setMessage("Are you sure you want to logout ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                final Intent intent = new Intent(getApplicationContext(),Login.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


                return true;

            /*case R.id.bat_tennis:
                Toast.makeText(this, "Tennis Bat", Toast.LENGTH_SHORT).show();
                return true;*/

          /*  case R.id.bat_tennis_red:
                Toast.makeText(this, "Red Tennis Bat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.bat_tennis_green:
                Toast.makeText(this, "Green Tennis Bat", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.bat_deuce:
                Toast.makeText(this, "Deuce Bat", Toast.LENGTH_SHORT).show();
                return true;*/


            default:

                return super.onOptionsItemSelected(item);


        }
      /*  int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_call) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:7737112219")); // Enter number you want to call

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
            {

                Toast.makeText(this,"Please grant the permission to call",Toast.LENGTH_SHORT).show();
                requestPermission();
            }
            else {
                startActivity(intent);
            }
            return true;
        }

        if (id == R.id.action_logout) {

            builder = new AlertDialog.Builder(this);
            builder.setName("Alert")
                    .setMessage("Are you sure you want to logout ?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            final Intent intent = new Intent(getApplicationContext(),Login.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();


            return true;
        }*/

    }




    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        }
        else if (id == R.id.action_schedule)
        {
            Scheduleorder();

        }
        else if (id == R.id.nav_map) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("geo: 12.972442, 77.580643"));
            Intent chooser = Intent.createChooser(i, "Launch Maps");
            startActivity(chooser); // select the app in your phone to open the location ex: google map, uber, ola ….etc

        } else if (id == R.id.nav_call) {

            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:8876041514")); // Enter number you want to call

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
            String[] s={"cricket.gear@gmail.com"};
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
