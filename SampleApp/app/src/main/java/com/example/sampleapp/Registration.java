package com.example.sampleapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.christuniversity.Retrofit.INodeJs;
import com.example.christuniversity.Retrofit.RetrofitClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Registration extends AppCompatActivity {


    EditText _username, _Password;
    Button _btn_login;
    TextView _register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        _fname = (EditText) findViewById(R.id.f_name);
        _mname = (EditText) findViewById(R.id.m_name);
        _lname = (EditText) findViewById(R.id.l_name);
        _email = (EditText) findViewById(R.id.email);
        _mno = (EditText) findViewById(R.id.mno);
        _password = (EditText) findViewById(R.id.password);

        spinner = (Spinner) findViewById(R.id.city);


        spinner1 = (Spinner) findViewById(R.id.college);


        _instbtn = (Button) findViewById(R.id.instbtn);

        _usertype = (Spinner) findViewById(R.id.usertype);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.user, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _usertype.setAdapter(adapter);

        _gender = (Spinner) findViewById(R.id.gender);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.gender, R.layout.spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        _gender.setAdapter(adapter1);


        awesomeValidation.addValidation(this, R.id.f_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.l_name, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.mno, "^[0-9]{3}[0-9]{7}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.password, "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$^+=!*()@%&]).{8,10}$", R.string.passerror);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spin = position;
                spin1 = String.valueOf(spin);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                spin_1 = position;
                spin2 = String.valueOf(spin_1);

            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        _instbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (awesomeValidation.validate()) {

                    if (_usertype.getSelectedItem().toString().trim().equals("Select City")) {
                        Toast.makeText(Registration.this, "Please Select a City", Toast.LENGTH_SHORT).show();
                    } else if (_usertype.getSelectedItem().toString().trim().equals("Select College")) {
                        Toast.makeText(Registration.this, "Please Select a College", Toast.LENGTH_SHORT).show();
                    } else if (_usertype.getSelectedItem().toString().trim().equals("User Type")) {
                        Toast.makeText(Registration.this, "Please Select a User Type", Toast.LENGTH_SHORT).show();
                    } else if (_gender.getSelectedItem().toString().trim().equals("Gender Type")) {
                        Toast.makeText(Registration.this, "Please Select a Gender Type", Toast.LENGTH_SHORT).show();
                    } else {
                        registerUser(_fname.getText().toString(),
                                _mname.getText().toString(),
                                _lname.getText().toString(),
                                _email.getText().toString(),
                                _mno.getText().toString(),
                                spin1, spin2,
                                _usertype.getSelectedItem().toString(),
                                _gender.getSelectedItem().toString(),
                                _password.getText().toString());

                    }

                    /*Intent intent = new Intent(getApplicationContext(),OtpActivity.class);
                    intent.putExtra("mobile", _mno.getText().toString());
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);*/

                }

            }
        });


    }
    }

