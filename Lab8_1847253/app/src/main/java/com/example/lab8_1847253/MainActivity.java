package com.example.lab8_1847253;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ClickAdapterListener{

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private ArrayList<Model> dataModel;
    private RecyclerViewAdapter mAdapter;
    private ActionModeCallback actionModeCallback;
    private ActionMode actionMode;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Button popup_menu, submit1;
    private Dialog myDialog;
    private TextView txtclose, title, genre, year, rating, title1, genre1, year1, rating1;
    private Button btnDatePicker, btnTimePicker;
    private int mYear, mMonth, mDay, mHour, mMinute;
    private TextView _ride_date,_ride_time;
    private String title2, year2, genre2, rating2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            myDialog = new Dialog(this);

            popup_menu = (Button) findViewById(R.id.popup_menu);

            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("RestrictedApi")
                @Override
                public void onClick(View v) {
                    fab.setVisibility(View.GONE);
                    populateDataAndSetAdapter();

                }
            });

            layoutManager = new LinearLayoutManager(this);

            recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setScrollBarSize(0);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.addItemDecoration(new DividerItemDecoration(this, 0));
            actionModeCallback = new ActionModeCallback();

            populateDataAndSetAdapter();

            popup_menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myDialog.setContentView(R.layout.schedule_popup);
                    submit1 = myDialog.findViewById(R.id.submit1);
                    txtclose = myDialog.findViewById(R.id.popup_close);
                    btnDatePicker = myDialog.findViewById(R.id.btn_date);
                    btnTimePicker = myDialog.findViewById(R.id.btn_time);
                    _ride_date = myDialog.findViewById(R.id.ride_date);
                    _ride_time = myDialog.findViewById(R.id.ride_time);

                    txtclose.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            myDialog.dismiss();
                        }
                    });

                    submit1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Toast.makeText(MainActivity.this, "Order Placed", Toast.LENGTH_SHORT).show();

                        }
                    });

                    btnDatePicker.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final Calendar c = Calendar.getInstance();
                            mYear = c.get(Calendar.YEAR);
                            mMonth = c.get(Calendar.MONTH);
                            mDay = c.get(Calendar.DAY_OF_MONTH);


                            DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, R.style.DialogTheme,
                                    new DatePickerDialog.OnDateSetListener() {

                                        @Override
                                        public void onDateSet(DatePicker view, int year,
                                                              int monthOfYear, int dayOfMonth) {

                                            _ride_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                                        }
                                    }, mYear, mMonth, mDay);

                            datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);

                            datePickerDialog.show();
                        }

                    });

                    btnTimePicker.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            final Calendar c = Calendar.getInstance();
                            mHour = c.get(Calendar.HOUR_OF_DAY);
                            mMinute = c.get(Calendar.MINUTE);

                            // Launch Time Picker Dialog
                            TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, R.style.DialogTheme,
                                    new TimePickerDialog.OnTimeSetListener() {

                                        @Override
                                        public void onTimeSet(TimePicker view, int hourOfDay,
                                                              int minute) {

                                            _ride_time.setText(hourOfDay + ":" + minute);
                                        }
                                    }, mHour, mMinute, false);

                            timePickerDialog.show();

                        }
                    });

                    myDialog.setCancelable(false);
                    myDialog.show();

                }
            });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.logout:

                onClickShowAlert();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    public void onRowClicked(int position, View view) {



        send_data(view);

        myDialog.setContentView(R.layout.movie_popup);

        title1 = myDialog.findViewById(R.id.title);
        genre1 = myDialog.findViewById(R.id.genre);
        year1 = myDialog.findViewById(R.id.year);
        rating1 = myDialog.findViewById(R.id.rating);

        title1.setText(title2);
        genre1.setText(genre2);
        year1.setText(year2);
        rating1.setText(rating2+"/10");

        myDialog.setCancelable(true);
        myDialog.show();

    }

    @Override
    public void onRowLongClicked(int position, View view) {
        enableActionMode(position);
    }

    private void enableActionMode(int position) {
        if (actionMode == null) {
            actionMode = startSupportActionMode(actionModeCallback);
        }
        toggleSelection(position);
    }

    private void toggleSelection(int position) {
        mAdapter.toggleSelection(position);
        int count = mAdapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
            actionMode = null;
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }
    }

    private void selectAll() {
        mAdapter.selectAll();
        int count = mAdapter.getSelectedItemCount();

        if (count == 0) {
            actionMode.finish();
        } else {
            actionMode.setTitle(String.valueOf(count));
            actionMode.invalidate();
        }

        actionMode = null;
    }

    private class ActionModeCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.menu_action_mode, menu);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Log.d("API123", "here");
            switch (item.getItemId()) {


                case R.id.action_delete:
                    // delete all the selected rows
                    deleteRows();
                    mode.finish();
                    return true;

                case R.id.action_color:
                    updateColoredRows();
                    mode.finish();
                    return true;

                case R.id.action_select_all:
                    selectAll();
                    return true;

                case R.id.action_refresh:
                    populateDataAndSetAdapter();
                    mode.finish();
                    return true;

                default:
                    return false;
            }
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mAdapter.clearSelections();
            actionMode = null;
        }
    }

    @SuppressLint("RestrictedApi")
    private void deleteRows() {
        List selectedItemPositions =
                mAdapter.getSelectedItems();
        for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
            mAdapter.removeData((Integer) selectedItemPositions.get(i));
        }
        mAdapter.notifyDataSetChanged();

        if (mAdapter.getItemCount() == 0)
            fab.setVisibility(View.VISIBLE);

        actionMode = null;
    }

    private void updateColoredRows() {
        List selectedItemPositions =
                mAdapter.getSelectedItems();
        for (int i = selectedItemPositions.size() - 1; i >= 0; i--) {
            mAdapter.updateData((Integer) selectedItemPositions.get(i));
        }
        mAdapter.notifyDataSetChanged();
        actionMode = null;
    }

    private void populateDataAndSetAdapter() {

        dataModel = new ArrayList<>();
        Model model = new Model("Mad Max: Fury Road", "Action & Adventure", "2015","8.1",R.drawable.mad_max, false);
        dataModel.add(model);

        model = new Model("Inside Out", "Animation, Kids & Family", "2015","8.2",R.drawable.inside, false);
        dataModel.add(model);

        model = new Model("Star Wars: Episode VII - The Force Awakens", "Action", "2015","7.9",R.drawable.starwar, false);
        dataModel.add(model);

        model = new Model("Shaun the Sheep", "Animation", "2015","7.3",R.drawable.sheep, false);
        dataModel.add(model);

        model = new Model("The Martian", "Science Fiction & Fantasy", "2015","8.0",R.drawable.martian, false);
        dataModel.add(model);

        model = new Model("Mission: Impossible Rogue Nation", "Action", "2015","7.4",R.drawable.rogue, false);
        dataModel.add(model);

        model = new Model("Up", "Animation", "2009","8.2",R.drawable.up, false);
        dataModel.add(model);

        model = new Model("Star Trek", "Science Fiction", "2009","7.9",R.drawable.star1, false);
        dataModel.add(model);

        model = new Model("The LEGO Movie", "Animation", "2014","7.8",R.drawable.lego, false);
        dataModel.add(model);

        model = new Model("Iron Man", "Action & Adventure", "2008","7.9",R.drawable.iron, false);
        dataModel.add(model);

        model = new Model("Aliens", "Science Fiction", "1986","8.4",R.drawable.aliens, false);
        dataModel.add(model);

        model = new Model("Chicken Run", "Animation", "2000","7.0",R.drawable.chicken, false);
        dataModel.add(model);

        model = new Model("Back to the Future", "Science Fiction", "1985","8.5",R.drawable.back, false);
        dataModel.add(model);

        model = new Model("Raiders of the Lost Ark", "Action & Adventure", "1981","8.4",R.drawable.raiders, false);
        dataModel.add(model);

        model = new Model("Goldfinger", "Action & Adventure", "1965","7.7",R.drawable.goldfinger, false);
        dataModel.add(model);

        model = new Model("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014","8.0",R.drawable.gurdians, false);
        dataModel.add(model);

        mAdapter = new RecyclerViewAdapter(this, dataModel, this);
        recyclerView.setAdapter(mAdapter);

    }

    public void onClickShowAlert() {
        AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle("Alert");
        myAlertBuilder.setMessage("Click OK to continue or CANCEL to stop");

        myAlertBuilder.setPositiveButton("OK", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User clicked OK button.
                        Toast.makeText(getApplicationContext(), "Logged out",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        myAlertBuilder.setNegativeButton("CANCEL", new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // User cancelled the dialog.
                        Toast.makeText(getApplicationContext(), "Cancelled",
                        Toast.LENGTH_SHORT).show();
                    }
                });

        myAlertBuilder.show();

    }

    private void send_data(View v) {
        int selectedItemPosition = recyclerView.getChildAdapterPosition(v);
        RecyclerView.ViewHolder viewHolder = recyclerView.findViewHolderForAdapterPosition(selectedItemPosition);

        LinearLayout linearLayoutParent = (LinearLayout) v;

        CardView cardView = (CardView) linearLayoutParent.getChildAt(0);

        LinearLayout linearLayout = (LinearLayout) cardView.getChildAt(0);

        LinearLayout linearLayout1 = (LinearLayout) linearLayout.getChildAt(1);

        LinearLayout linearLayout2 = (LinearLayout) linearLayout1.getChildAt(2);


        title = (TextView) linearLayout1.getChildAt(0);
        genre = (TextView) linearLayout1.getChildAt(1);
        year = (TextView) linearLayout2.getChildAt(0);
        rating = (TextView) linearLayout2.getChildAt(1);

        title2 = title.getText().toString();
        genre2 = genre.getText().toString();
        year2 = year.getText().toString();
        rating2 = rating.getText().toString();

    }

}