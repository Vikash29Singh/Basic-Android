package com.example.Travelprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Flightbook extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    ArrayList<Model> dataModel;
    RecyclerViewAdapter mAdapter;
    /*private ActionModeCallback actionModeCallback;
     */private ActionMode actionMode;
    FloatingActionButton fab;
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
        /*actionModeCallback = new ActionModeCallback();
         */
        populateDataAndSetAdapter();


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
        mAdapter = new RecyclerViewAdapter(this, dataModel);
        recyclerView.setAdapter(mAdapter);
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
