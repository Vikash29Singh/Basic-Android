package com.example.lab12_1847253;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Car_book extends Fragment {

    TextView d_date, r_date,depart_time,origin,destination;
    DatePickerDialog picker;
    View view;
    String format;
    ImageView swap;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.car_book, container, false);

        d_date = (TextView) view.findViewById(R.id.depart_date);

        r_date = (TextView) view.findViewById(R.id.return_date);

        depart_time = (TextView) view.findViewById(R.id.depart_time);
        swap= view.findViewById(R.id.swap);
        origin= view.findViewById(R.id.origin);
        destination= view.findViewById(R.id.destination);


        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp = origin.getText().toString();
                origin.setText(destination.getText().toString());
                destination.setText(temp);
            }
        });

        d_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth) +"/"+String.valueOf(monthOfYear+1)
                                +"/"+String.valueOf(year);
                        //tfDescription.setText(date);
                        d_date.setText(date);
                    }
                }, yy, mm, dd);

                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-1000);

                datePicker.show();

            }
        });

        r_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Calendar calendar = Calendar.getInstance();
                int yy = calendar.get(Calendar.YEAR);
                int mm = calendar.get(Calendar.MONTH);
                int dd = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth) +"/"+String.valueOf(monthOfYear+1)
                                +"/"+String.valueOf(year);
                        //tfDescription.setText(date);
                        r_date.setText(date);
                    }
                }, yy, mm, dd);

                datePicker.getDatePicker().setMinDate(System.currentTimeMillis()-1000);

                datePicker.show();

            }
        });

        depart_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int CalendarHour = calendar.get(Calendar.HOUR_OF_DAY);
                int CalendarMinute = calendar.get(Calendar.MINUTE);


                TimePickerDialog timepickerdialog = new TimePickerDialog(getActivity(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                if (hourOfDay == 0) {

                                    hourOfDay += 12;

                                    format = "AM";
                                } else if (hourOfDay == 12) {

                                    format = "PM";

                                } else if (hourOfDay > 12) {

                                    hourOfDay -= 12;

                                    format = "PM";

                                } else {

                                    format = "AM";
                                }


                                depart_time.setText(hourOfDay + ":" + minute + format);
                            }
                        }, CalendarHour, CalendarMinute, false);
                timepickerdialog.show();

            }
        });



        return view;

    }



}
