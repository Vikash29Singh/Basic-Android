package com.example.lab12_1847253;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import java.util.Calendar;

public class Flight_book extends Fragment {

    TextView d_date, r_date,travclass,travellertype,origin,destination;
    DatePickerDialog picker;
    ImageView swap;
    View view;
    MaterialButton search;
    Button cancel,ok;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.flight_book, container, false);


         d_date = (TextView) view.findViewById(R.id.depart_date);
        search=view.findViewById(R.id.popup_menu);
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
                 mydialog.setContentView(R.layout.traveller_class_pop);
                 final RadioButton economy,busi,first,prem;
                 economy=mydialog.findViewById(R.id.economy);
                 busi=mydialog.findViewById(R.id.busi);
                 first=mydialog.findViewById(R.id.first);
                 prem=mydialog.findViewById(R.id.prem);

                 Button cancel = mydialog.findViewById(R.id.cancel);
                 final RadioGroup radioGroup=mydialog.findViewById(R.id.radiogroup);
                 Button ok = mydialog.findViewById(R.id.ok);

/*
radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        RadioButton radioButton=radioGroup.findViewById(i);
    }
});
*/


                 radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                           @Override
                                                           public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                                               if(economy.isChecked()==true){

                                                               }
                                                               else if(busi.isChecked()==true){

                                                               } else if(prem.isChecked()==true){

                                                               }
                                                               else (first.isChecked()==true)
                                                               {

                                                               }

                 }
             });


                         cancel.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 startActivity(new Intent(getActivity(), MainActivity.class));
                             }
                         });
                 ok.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                             startActivity(new Intent(getActivity(),Flight_book.class));

                         }
                         //startActivity(new Intent(getActivity(),MainActivity.class));

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

                Button cancel = mydialog.findViewById(R.id.cancel);
                Button ok = mydialog.findViewById(R.id.ok);



                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(),MainActivity.class));
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(getActivity(),MainActivity.class));
                    }
                });

                mydialog.setCancelable(true);
                mydialog.show();
            }
        });

        return view;

    }


}
