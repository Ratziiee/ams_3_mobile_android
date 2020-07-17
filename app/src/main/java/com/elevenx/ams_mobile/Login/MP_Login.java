package com.elevenx.ams_mobile.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.Login.RegisterUser.Register_User;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class MP_Login extends AppCompatActivity {

    Button btn_register,btn_signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_login);

        initViewss();
        clickListners();
    }

    private void initViewss()
    {
        btn_register = findViewById(R.id.btn_register);
        btn_signIn = findViewById(R.id.btn_signIn);
    }

    private void clickListners()
    {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MP_Login.this, "Register", Toast.LENGTH_SHORT).show();

                startActivity(Utils.Intent(MP_Login.this, Register_User.class));
            }
        });

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MP_Login.this, "Sign IN", Toast.LENGTH_SHORT).show();
                startActivity(Utils.Intent(MP_Login.this, Verify_Mobile_no.class));
            }
        });
    }
}