package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText password, email;
    Button sign;
    ProgressDialog progressBar;
    int count=0,count1=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email_id);

        sign=(Button)findViewById(R.id.sign);



    sign.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getApplicationContext(), Dashboard.class);


        intent.putExtra("Name", email.getText().toString());
        startActivity(intent);

       /* count=count+1;
        count1=count1-1;*/
       // Toast.makeText(Login.this, email.getText().toString(), Toast.LENGTH_SHORT).show();

       /* if (email.getText().toString().equals("vikashlikes18@gmail.com") &&
                password.getText().toString().equals("1234")) {
            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getApplicationContext(), Dashboard.class);


            intent.putExtra("Name", email.getText().toString());
            startActivity(intent);

            //startActivity(intent);
        }
         else {


            Toast.makeText(Login.this, "Wrong Credentials \n Attempt left : "+count1, Toast.LENGTH_SHORT).show();

            if(count>2) {
                     System.exit(0);
                    finish();
                }
        }*/
    }
});
    }
    public void registration(View view) {
    }
}


