package com.elevenx.ams_mobile.Login.RegisterUser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;
import com.google.firebase.auth.FirebaseAuth;

public class Set_Password extends AppCompatActivity {

    EditText et_pwd,et_confirm_pwd,et_f_name,et_l_name;
    Button btn_save_pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        initviews();
        clickListner();
        onCreateThings();
        Toast.makeText(this, getSerialNumber(), Toast.LENGTH_SHORT).show();
    }
    private void initviews()
    {
        et_pwd = findViewById(R.id.et_pwd);
        et_confirm_pwd = findViewById(R.id.et_confirm_pwd);
        btn_save_pwd = findViewById(R.id.btn_save_pwd);
        et_f_name=findViewById(R.id.et_f_name);
        et_l_name=findViewById(R.id.et_l_name);
    }

    private void clickListner()
    {
        btn_save_pwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_save_pwd();
            }
        });
    }

    private void onCreateThings()
    {

    }

    private void onClick_save_pwd()
    {
        if(et_pwd.getText().toString().trim().equals(et_confirm_pwd.getText().toString().trim()))
        {
            Toast.makeText(this, "Password Saved", Toast.LENGTH_SHORT).show();
            Utils.Intent(Set_Password.this, Verify_Mobile_no.class);
        }
    }

    private String getSerialNumber()
    {


        if (android.os.Build.VERSION.SDK_INT <= 25){

            return android.os.Build.SERIAL;
        } else {

            // Do something for lollipop and above versions
           return android.os.Build.getSerial();
        }

    }
}