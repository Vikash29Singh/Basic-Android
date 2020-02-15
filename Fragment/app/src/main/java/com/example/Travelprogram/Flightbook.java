package com.example.Travelprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Flightbook extends AppCompatActivity implements RecyclerViewAdapter.ClickAdapterListener{

    TextView origin ,destination,depart_time,arrival_time,price;
    String originn ,destinationn,depart_timen,arrival_timen,pricen;


    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<Model> dataModel;
    RecyclerViewAdapter mAdapter;
    /*private ActionModeCallback actionModeCallback;
     private ActionMode actionMode;
    */FloatingActionButton fab;
    private Toolbar toolbar,toolbar1;
    Button popup_menu, submit1;
    Dialog myDialog;
    TextView txtclose;
    Button btnDatePicker, btnTimePicker;
    private int mYear, mMonth, mDay, mHour, mMinute;
    TextView _ride_date,_ride_time;
    ImageView btn_favorites;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightbook);
        getSupportActionBar().setTitle("Flight");
        ColorDrawable colorDrawable
                = new ColorDrawable(Color.parseColor("#2c3e50"));
       getSupportActionBar().setBackgroundDrawable(colorDrawable);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setScrollBarSize(0);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //actionModeCallback = new ActionModeCallback();
        populateDataAndSetAdapter();


    }

    @Override
    public void onRowClicked(int position, View view) {



        send_data(view);
        Intent intent = new Intent(getApplicationContext(),Flightbookingdetail.class);
        intent.putExtra("origin",originn);
        intent.putExtra("destination",destinationn);
        intent.putExtra("arrival_time",arrival_timen);
        intent.putExtra("depart_time",depart_timen);
        intent.putExtra("price",pricen);
        startActivity(intent);



       /* myDialog.setContentView(R.layout.movie_popup);

        title1 = myDialog.findViewById(R.id.title);
        genre1 = myDialog.findViewById(R.id.genre);
        year1 = myDialog.findViewById(R.id.year);
        rating1 = myDialog.findViewById(R.id.rating);*/



        /*title1.setText(title2);
        genre1.setText(genre2);
        year1.setText(year2);
        rating1.setText(rating2+"/10");*/

       /* myDialog.setCancelable(true);
        myDialog.show();*/

    }



        private void populateDataAndSetAdapter() {


        dataModel = new ArrayList<>();
        Model model = new Model("BLR","11:45", "GAU","14:50", "Rs. 4548", R.drawable.indigo);
        dataModel.add(model);

        model = new Model("BLR","12:15", "GAU", "15:20","Rs. 4556", R.drawable.spicejet);
        dataModel.add(model);

        model = new Model("BLR", "5:50","GAU", "9:00","Rs. 4659", R.drawable.airindia);
        dataModel.add(model);

        model = new Model("BLR", "16:30","GAU","20:40", "Rs. 4851", R.drawable.airasia);
        dataModel.add(model);


        model = new Model("BLR","13:15", "GAU","4:15", "Rs. 5498", R.drawable.spicejet);
        dataModel.add(model);

        model = new Model("BLR","7:20", "GAU","10:45", "Rs. 5621", R.drawable.airindia);
        dataModel.add(model);

        model = new Model("BLR","15:00", "GAU","6:00", "Rs. 6789", R.drawable.indigo);
        dataModel.add(model);


        model = new Model("BLR","20:45", "GAU","12:25", "Rs. 8745", R.drawable.airasia);
        dataModel.add(model);

       /* model = new Model("Super Series", "Deuce", "Rs. 653", R.drawable.deuce_bat2);
        dataModel.add(model);
        model = new Model("New Balance", "Deuce", "Rs. 1053", R.drawable.redtennis_bat);
        dataModel.add(model);*/

       /* model = new Model("The Martian", "Science Fiction & Fantasy", "2015", false);
        dataModel.add(model);

        model = new Model("Mission: Impossible Rogue Nation", "Action", "2015", false);
        dataModel.add(model);

        model = new Model("Up", "Animation", "2009", false);
        dataModel.add(model);

        model = new Model("Star Trek", "Science Fiction", "2009", false);
        dataModel.add(model);

        model = new Model("The LEGO Movie", "Animation", "2014", false);
        dataModel.add(model);

        model = new Model("Iron Man", "Action & Adventure", "2008", false);
        dataModel.add(model);

        model = new Model("Aliens", "Science Fiction", "1986", false);
        dataModel.add(model);

        model = new Model("Chicken Run", "Animation", "2000", false);
        dataModel.add(model);

        model = new Model("Back to the Future", "Science Fiction", "1985", false);
        dataModel.add(model);

        model = new Model("Raiders of the Lost Ark", "Action & Adventure", "1981", false);
        dataModel.add(model);

        model = new Model("Goldfinger", "Action & Adventure", "1965", false);
        dataModel.add(model);

        model = new Model("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014", false);
        dataModel.add(model);
*/
        mAdapter = new RecyclerViewAdapter(this, dataModel,this);
        recyclerView.setAdapter(mAdapter);
    }
        private void send_data(View v) {
            int selectedItemPosition = recyclerView.getChildAdapterPosition(v);
            RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(selectedItemPosition);

            LinearLayout linearLayoutParent = (LinearLayout) v;

            CardView cardView = (CardView) linearLayoutParent.getChildAt(0);

            LinearLayout linearLayout = (LinearLayout) cardView.getChildAt(1);

            LinearLayout linearLayout1 = (LinearLayout) linearLayout.getChildAt(0);

            LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(0);
            LinearLayout linearLayout3 = (LinearLayout) linearLayout2.getChildAt(0);

            LinearLayout linearLayout4 = (LinearLayout) linearLayout2.getChildAt(1);
            //LinearLayout linearLayout5 = (LinearLayout) linearLayout.getChildAt(1);



            origin = (TextView) linearLayout3.getChildAt(0);
            destination = (TextView) linearLayout3.getChildAt(1);
            depart_time = (TextView) linearLayout4.getChildAt(0);
            arrival_time = (TextView) linearLayout4.getChildAt(1);
            price = (TextView) linearLayout.getChildAt(1);


            originn = origin.getText().toString();
            destinationn = destination.getText().toString();
            depart_timen = depart_time.getText().toString();
            arrival_timen = arrival_time.getText().toString();
            pricen = price.getText().toString();


        }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
