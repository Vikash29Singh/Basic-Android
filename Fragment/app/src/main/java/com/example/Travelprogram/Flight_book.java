package com.example.Travelprogram;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static android.content.Context.MODE_PRIVATE;

public class Flight_book extends Fragment {

    TextView d_date, r_date,travclass,travellertype,origin,destination;
    DatePickerDialog picker;
    ImageView swap;
    View view;
    MaterialButton search;
    Button cancel,ok;
    String travel_class,num;
    int count1 = 1,count2,count3;

  /*  SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;*/

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
        search = view.findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*sharedPreferences = getActivity().getSharedPreferences("MySharedPref",
                        MODE_PRIVATE);
                editor= sharedPreferences.edit();
                editor.putString("origin", origin.getText().toString());
                editor.putString("destination", destination.getText().toString());
                editor.commit();*/
                startActivity(new Intent(getActivity(),Flightbook.class));

            }
        });






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
                 final Dialog mydialog = new Dialog(getActivity());
                 mydialog.setContentView(R.layout.traveller_class_pop);
                 final RadioButton economy,busi,first,prem;
                 economy=mydialog.findViewById(R.id.economy);
                 busi=mydialog.findViewById(R.id.busi);
                 first=mydialog.findViewById(R.id.first);
                 prem=mydialog.findViewById(R.id.prem);





                // Button cancel = mydialog.findViewById(R.id.cancel);
                 final RadioGroup radioGroup=mydialog.findViewById(R.id.radiogroup);
               //  Button ok = mydialog.findViewById(R.id.ok);

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
                                                                   travel_class = "Economy";
                                                               }
                                                               else if(busi.isChecked()==true){
                                                                   travel_class = "Business";

                                                               } else if(prem.isChecked()==true){
                                                                   travel_class = "Premium Economy";

                                                               }
                                                               else if(first.isChecked()==true)
                                                               {
                                                                   travel_class = "First Class";
                                                               }
                                                               Toast.makeText(getContext(), "Class selected"+travel_class, Toast.LENGTH_SHORT).show();
                                                               mydialog.dismiss();
                                                               travclass.setText(travel_class);


                 }
             });


                       /*  cancel.setOnClickListener(new View.OnClickListener() {
                             @Override
                             public void onClick(View view) {
                                 startActivity(new Intent(getActivity(), MainActivity.class));
                             }
                         });
                         ok.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View view) {

                         Intent intent = new Intent(getContext(), MainActivity.class);
                         intent.putExtra("trav_class", travel_class);
                     }
                     //startActivity(new Intent(getActivity(),MainActivity.class));

                 });*/
                 mydialog.setCancelable(true);
                 mydialog.show();
             }
         });

        travellertype.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button add1,add2,add3,sub1,sub2,sub3;

                final TextView adult,child,infant,numb1,numb2,numb3;

                final Dialog mydialog = new Dialog(getActivity());
                mydialog.setContentView(R.layout.traveller_pop);

                Button cancel = mydialog.findViewById(R.id.cancel);
                Button ok = mydialog.findViewById(R.id.ok);

                adult= mydialog.findViewById(R.id.adult);
                child= mydialog.findViewById(R.id.child);
                infant= mydialog.findViewById(R.id.infant);

                add1= mydialog.findViewById(R.id.add1);

                add2= mydialog.findViewById(R.id.add2);
                add3= mydialog.findViewById(R.id.add3);

                sub1= mydialog.findViewById(R.id.sub1);
                sub2= mydialog.findViewById(R.id.sub2);
                sub3= mydialog.findViewById(R.id.sub3);

                numb1= mydialog.findViewById(R.id.numb1);
                numb2= mydialog.findViewById(R.id.numb2);
                numb3= mydialog.findViewById(R.id.numb3);

                add1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (count1 < 6) {
                            count1++;
                            adult.setText(String.valueOf(count1));
                            numb1.setText(String.valueOf(count1));
                        }

                                                else {
                            Toast.makeText(getContext(), "Data cannot be more than 6" , Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                add2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (count2 < count1) {
                            count2++;
                            child.setText(String.valueOf(count2));
                            numb2.setText(String.valueOf(count2));
                        }

                                                else {
                            Toast.makeText(getContext(), "Data cannot be more than " +count1, Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                add3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (count3 < count1) {
                            count3++;

                            infant.setText(String.valueOf(count3));
                            numb3.setText(String.valueOf(count3));
                        }
                        else {
                            Toast.makeText(getContext(), "Data cannot be more than " +count1, Toast.LENGTH_SHORT).show();
                        }

                    }
                });


                sub1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (count1 > 1)
                        {
                            count1--;
                            adult.setText(String.valueOf(count1));
                            numb1.setText(String.valueOf(count1));
                        }

                            else
                        {
                            Toast.makeText(getContext(), "Data cannot be less 1", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                sub2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (count2 > 0) {
                            count2--;
                            child.setText(String.valueOf(count2));
                            numb2.setText(String.valueOf(count2));
                        }
                        else {
                            Toast.makeText(getContext(), "Data cannot be less 0", Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                sub3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (count3 > 0)
                        {
                            count3--;
                            infant.setText(String.valueOf(count3));
                            numb3.setText(String.valueOf(count3));
                        }


                          else {
                            Toast.makeText(getContext(), "Data cannot be less 0", Toast.LENGTH_SHORT).show();
                        }


                    }
                });









                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //startActivity(new Intent(getActivity(),MainActivity.class));
                        mydialog.dismiss();
                    }
                });
                ok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //startActivity(new Intent(getActivity(),MainActivity.class));
/*                        numb1.setText(String.valueOf(count1));
                        numb2.setText(String.valueOf(count2));
                        numb3.setText(String.valueOf(count3));*/
                      /* String data1 = count1+" Adult,";
                       String data2 = count2+" Child,";
                        String data3 = count3+" Infant";*/

                        mydialog.dismiss();
                        if (count2 == 0 && count3 == 0) {
                            travellertype.setText(count1+"Adult");
                        }
                        else if(count3 == 0){
                            travellertype.setText(count1+"Adult,"+count2+"Child");

                        }
                        else {
                            travellertype.setText(count1+"Adult,"+count2+"Child,"+count3+"Infant");
                        }


                    }
                });

                mydialog.setCancelable(true);
                mydialog.show();
            }
        });

        return view;

    }


}
