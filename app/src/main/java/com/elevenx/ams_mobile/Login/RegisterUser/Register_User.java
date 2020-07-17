package com.elevenx.ams_mobile.Login.RegisterUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Register_User extends AppCompatActivity {

    EditText et_mobile_no;
    Button btn_submit;
    private static String TAG = "Register_User";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register__user);

        initViews();
        clickListner();
    }

    private  void initViews()
    {
        et_mobile_no=findViewById(R.id.et_mobile);
        btn_submit=findViewById(R.id.btn_agree);
    }

    private void clickListner()
    {
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_Submit(et_mobile_no.getText().toString());
            }
        });
    }

    private void onClick_Submit(String Phone_Number)
    {
        Log.d(TAG, "onClick_Submit: Phone Number : "+Phone_Number);

        startActivity(Utils.Intent(Register_User.this,Verify_OTP.class).putExtra("mobile_number",Phone_Number));

    }
}