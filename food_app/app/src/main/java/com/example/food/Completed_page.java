package com.example.food;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Completed_page extends AppCompatActivity {
    Button call_vallet;
    TextView name,amount;
    String user_name,user_amt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_page);
        call_vallet=findViewById(R.id.call_vallet);
        name=findViewById(R.id.name);
        amount=findViewById(R.id.amount);

        user_name=getIntent().getExtras().getString("name");
        name.setText(user_name);
        user_amt=getIntent().getExtras().getString("Amt");
        amount.setText(user_amt);



        call_vallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:8794561230")); // Enter number you want to call

                if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {

                    Toast.makeText(getApplicationContext(),"Please grant the permission to call",Toast.LENGTH_SHORT).show();
                    requestPermission();
                }
                else {
                    startActivity(intent);
                }
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},1);
    }
}
