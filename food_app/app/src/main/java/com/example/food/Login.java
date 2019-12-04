package com.example.food;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
TextView food_item,disc_amt,total_amt;
String food,disc,total;
EditText name,phone_no;
Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        food_item=findViewById(R.id.food_item);
        disc_amt=findViewById(R.id.disc_amt);
        total_amt=findViewById(R.id.total_amt);
        name=findViewById(R.id.name);
        phone_no=findViewById(R.id.phone_no);
        submit=findViewById(R.id.submit);



        food=getIntent().getExtras().getString("Food");
        food_item.setText(food);

        disc=getIntent().getExtras().getString("Amt");
        disc_amt.setText(disc);

        total=getIntent().getExtras().getString("Amt_disc");
        total_amt.setText(total);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().isEmpty() && phone_no.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Enter name and phone number", Toast.LENGTH_LONG).show();
                }else {
                    if (phone_no.length() != 10) {
                        Toast.makeText(getApplicationContext(), "Enter valid Number", Toast.LENGTH_LONG).show();
                    } else {
                        Intent intent = new Intent(getApplicationContext(), Completed_page.class);
                        intent.putExtra("name", name.getText().toString());
                        // intent.putExtra("phone_no",phone_no.getText().toString());
                        intent.putExtra("Amt", String.valueOf(total));

                        startActivity(intent);
                    }
                }

            }
        });

    }
}
