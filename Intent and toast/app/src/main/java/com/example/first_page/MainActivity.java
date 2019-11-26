package com.example.first_page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=(Button)findViewById(R.id.button1);
    }

    public void next_page(View view) {
        Intent intent=new Intent(getApplicationContext(),Second_page.class);
        name=(EditText)findViewById(R.id.name);
        intent.putExtra("Name",name.getText().toString());
        startActivity(intent);


    }
}
