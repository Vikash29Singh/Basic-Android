package com.example.lab12_1847253;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;

public class Bus_book extends Fragment {

    TextView d_date, r_date,travclass,travellertype,origin,destination;
    ImageView swap;
    DatePickerDialog picker;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bus_book, container, false);

        d_date = (TextView) view.findViewById(R.id.depart_date);

        r_date = (TextView) view.findViewById(R.id.return_date);
        travclass= view.findViewById(R.id.travclass);
        travellertype = view.findViewById(R.id.travellertype);
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

        travclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog mydialog = new Dialog(getActivity());
                mydialog.setContentView(R.layout.traveller_class_pop_bus);
                Button cancel = mydialog.findViewById(R.id.cancel);
                Button ok = mydialog.findViewById(R.id.ok);
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                mydialog.setCancelable(true);
                mydialog.show();
            }
        });

        travellertype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog mydialog = new Dialog(getActivity());
                mydialog.setContentView(R.layout.traveller_pop);
                mydialog.setCancelable(true);
                mydialog.show();
            }
        });

        return view;

    }



}
