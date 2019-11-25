package com.example.lab2_201112;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2;
    Button b1,b2,b3,b4,b5;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.numb1);
        e2=(EditText)findViewById(R.id.numb2);
        b1=(Button)findViewById(R.id.add);
        b2=(Button)findViewById(R.id.sub);
        b3=(Button)findViewById(R.id.mul);
        b4=(Button)findViewById(R.id.div);
        b5=(Button)findViewById(R.id.clear);
        tv=(TextView)findViewById(R.id.result);

    }


    public void onAdd(View view) {

        //converting the numbers in textbox to integer and store it in the varibales
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
    //add the two numbers.
        int sum = num1 + num2;
    // display the numbers in the text box
        tv.setText(Integer.toString(sum));
    }

    public void onSub(View view) {
        //converting the numbers in textbox to integer and store it in the varibales
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        //add the two numbers.
        int sub = num1 - num2;
        // display the numbers in the text box
        tv.setText(Integer.toString(sub));
    }

    public void onDiv(View view) {
        //converting the numbers in textbox to integer and store it in the varibales
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        //add the two numbers.
        int div = num1 / num2;
        // display the numbers in the text box
        tv.setText(Integer.toString(div));
    }

    public void onMul(View view) {
        //converting the numbers in textbox to integer and store it in the varibales
        int num1 = Integer.parseInt(e1.getText().toString());
        int num2 = Integer.parseInt(e2.getText().toString());
        //add the two numbers.
        int mul = num1 * num2;
        // display the numbers in the text box
        tv.setText(Integer.toString(mul));
    }

    public void onClear(View view) {
        tv.setText("");
        e1.setText("");
        e2.setText("");
    }
}
