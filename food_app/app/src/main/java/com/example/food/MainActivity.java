package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton veg,non_veg;
    Button submit, clear;
    RelativeLayout non_veg_cart,veg_cart;
    int i;
    TextView tv;
    CheckBox checkBox,checkBox2,checkBox3,ncheckBox,ncheckBox2,ncheckBox3;
    EditText coupon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        veg = findViewById(R.id.veg);
        non_veg = findViewById(R.id.non_veg);
        non_veg_cart = findViewById(R.id.non_veg_cart);
        veg_cart = findViewById(R.id.veg_cart);
        clear = findViewById(R.id.clear);
        submit = findViewById(R.id.submit);
        tv=findViewById(R.id.tv);
        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        ncheckBox=findViewById(R.id.ncheckBox);
        ncheckBox2=findViewById(R.id.ncheckBox2);
        ncheckBox3=findViewById(R.id.ncheckBox3);
        coupon=findViewById(R.id.coupon);

        tv.setVisibility(View.GONE);
        coupon.setVisibility(View.GONE);

        radioGroup = findViewById(R.id.groupradio);
        non_veg_cart.setVisibility(View.GONE);
        veg_cart.setVisibility(View.GONE);
        clear.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);


            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (checkBox.isChecked() || checkBox2.isChecked() || checkBox3.isChecked() || ncheckBox.isChecked() || ncheckBox2.isChecked() || ncheckBox3.isChecked()) {
                        String food = "Food Selected";
                        if (coupon.getText().toString().equals("tasty")) {


                            double total;
                            i = 0;

                            if (checkBox.isChecked()) {
                                food += "\nSahi Paneer 120";
                                i = i + 120;
                            }
                            if (checkBox2.isChecked()) {
                                food += "\nDal Tadka 130";
                                i = i + 130;
                            }
                            if (checkBox3.isChecked()) {
                                food += "\nFried Rice 110";
                                i = i + 110;
                            }

                            if (ncheckBox.isChecked()) {
                                food += "\nChilli Paneer 140";
                                i = i + 140;
                            }
                            if (ncheckBox2.isChecked()) {
                                food += "\nMutton Kosha 150";
                                i = i + 150;
                            }
                            if (ncheckBox3.isChecked()) {
                                food += "\nChicken Fried Rice 130";
                                i = i + 130;
                            }
                            int total_no_coupon = i;
                            total = total_no_coupon * 0.25;
                            double disc;
                            disc = i - total;
                            //String amt= String.valueOf(total);


                            Toast.makeText(getApplicationContext(), "Food Seleted" + food + "\nDiscount applied" + String.valueOf(total) + "\nTotal price :" + String.valueOf(disc), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            intent.putExtra("Food", food);
                            intent.putExtra("Amt", String.valueOf(total));
                            intent.putExtra("Amt_disc", String.valueOf(disc));
                            startActivity(intent);

                        } else {
                            //String food = "Food Selected";

                            i = 0;

                            if (checkBox.isChecked()) {
                                food += "\nSahi Paneer 120";
                                i = i + 120;
                            }
                            if (checkBox2.isChecked()) {
                                food += "\nDal Tadka 130";
                                i = i + 130;
                            }
                            if (checkBox3.isChecked()) {
                                food += "\nFried Rice 110";
                                i = i + 110;
                            }

                            if (ncheckBox.isChecked()) {
                                food += "\nChilli Chicken 140";
                                i = i + 140;
                            }
                            if (ncheckBox2.isChecked()) {
                                food += "\nMutton Kosha 150";
                                i = i + 150;
                            }
                            if (ncheckBox3.isChecked()) {
                                food += "\nChicken Fried Rice 130";
                                i = i + 130;
                            }
                            int total_no_coupon = i;
                            int disc = 0;
                            Toast.makeText(getApplicationContext(), food + "\nTotal price :" + String.valueOf(total_no_coupon), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            intent.putExtra("Food", food);
                            intent.putExtra("Amt", String.valueOf(disc));
                            intent.putExtra("Amt_disc", String.valueOf(total_no_coupon));
                            startActivity(intent);
                        }

                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Nothing is selected",Toast.LENGTH_LONG).show();
                    }
                }
            });





        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.clearCheck();
                veg_cart.setVisibility(View.GONE);
                non_veg_cart.setVisibility(View.GONE);
                checkBox.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                ncheckBox.setChecked(false);
                ncheckBox2.setChecked(false);
                ncheckBox3.setChecked(false);
                clear.setVisibility(View.GONE);
                submit.setVisibility(View.GONE);
                coupon.setText("");
                tv.setVisibility(View.GONE);
                coupon.setVisibility(View.GONE);

                i=0;


            }
        });
        // radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                clear.setVisibility(View.VISIBLE);
                submit.setVisibility(View.VISIBLE);

                if(veg.isChecked()==true){
                    veg_cart.setVisibility(View.VISIBLE);
                    non_veg_cart.setVisibility(View.GONE);
                    tv.setVisibility(View.VISIBLE);
                    coupon.setVisibility(View.VISIBLE);
                }else{
                    non_veg_cart.setVisibility(View.VISIBLE);
                    veg_cart.setVisibility(View.GONE);
                    tv.setVisibility(View.VISIBLE);
                    coupon.setVisibility(View.VISIBLE);
                }

            }
        });

    }
/*    private void initControls() {
        checkBox=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkBox3=findViewById(R.id.checkBox3);
        ncheckBox=findViewById(R.id.ncheckBox);
        ncheckBox2=findViewById(R.id.ncheckBox2);
        ncheckBox3=findViewById(R.id.ncheckBox3);

    }*/
   /* public void onCheckboxClicked(View view){

        boolean checked = ((CheckBox) view).isChecked();
        String str="";
        i = 0;

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.checkBox:
                str = checked?"Pizza Selected":"Pizza Deselected";
                i=i+120;
                break;
            case R.id.checkBox2:
                str = checked?"Burger Selected":"Burger Deselected";
                i=i+130;
                break;
            case R.id.checkBox3:
                str = checked?"Wrap Selected":"Wrap Deselected";
                i=i+110;
                break;
            case R.id.ncheckBox:
                str = checked?"Pizza Selected":"Pizza Deselected";
                i=i+140;
                break;
            case R.id.ncheckBox2:
                str = checked?"Burger Selected":"Burger Deselected";
                i=i+150;
                break;
            case R.id.ncheckBox3:
                str = checked?"Wrap Selected":"Wrap Deselected";
                i=i+130;
                break;

        }
        Toast.makeText(getApplicationContext(), str + i, Toast.LENGTH_SHORT).show();
    }
*/
    }



