package com.elevenx.ams_mobile.Login.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.elevenx.ams_mobile.AfterLogin.MP_After_Login;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class Login extends AppCompatActivity {

    EditText et_pwd;
    Button btn_login;
    String MOBILE_NUMBER="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        onCreateThings();
        clickListner();

    }

    private  void initViews()
    {
        et_pwd=findViewById(R.id.et_pwd);

        btn_login=findViewById(R.id.btn_login);
    }

    private void clickListner()
    {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_Login(MOBILE_NUMBER,et_pwd.getText().toString().trim());
            }
        });
    }

    private void onClick_Login(String mobile_number, String pwd) {

    startActivity(Utils.Intent(Login.this, MP_After_Login.class));
    }

    private void onCreateThings()
    {
        MOBILE_NUMBER = getIntent().getStringExtra("mobile");
    }

    private void saveDataToLocal(int ID, String MOBILE,String USER_ID,String USERNAME, String UNIQUE_ID,String PASSWORD)
    {
        SharedPreferences sp = getSharedPreferences("PROFILE",MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putInt("id",ID);
        e.putString("mobile",MOBILE);
        e.putString("user_id",USER_ID);
        e.putString("username",USERNAME);
        e.putString("unique_id",UNIQUE_ID);
        e.putString("pwd",PASSWORD);
        e.putBoolean("isLoggedIn",true);

        e.apply();


    }
}