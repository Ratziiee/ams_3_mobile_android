package com.elevenx.ams_mobile.Login.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.elevenx.ams_mobile.API_STORE.API_Store;
import com.elevenx.ams_mobile.API_STORE.CallBack_Get;
import com.elevenx.ams_mobile.API_STORE.HIT_API;
import com.elevenx.ams_mobile.AfterLogin.MP_After_Login;
import com.elevenx.ams_mobile.Login.ForgotPassword.MP_ForgotPassword;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements CallBack_Get {

    EditText et_pwd;
    Button btn_login;
    String MOBILE_NUMBER="";
    TextView tv_forgotPassword;
    String TAG = "Login";

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
        tv_forgotPassword=findViewById(R.id.tv_forgotPassword);
    }

    private void clickListner()
    {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_Login(MOBILE_NUMBER,et_pwd.getText().toString().trim());
            }
        });

        tv_forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(Utils.Intent(Login.this, MP_ForgotPassword.class));
            }
        });
    }

    private void onClick_Login(String mobile_number, String pwd) {

        HIT_API api = new HIT_API();
        api.GET_REQUEST_JSONOBJECT(this, API_Store.GET_LOGIN+mobile_number+"&pwd="+pwd,this,6, Request.Method.GET);

    }

    private void onCreateThings()
    {
        MOBILE_NUMBER = getIntent().getStringExtra("mobile");
    }

    private void saveDataToLocal(int ID, String MOBILE,String USER_ID,String USERNAME, String UNIQUE_ID,String PASSWORD,String COUNTRY_CODE)
    {

        SharedPreferences sp = getSharedPreferences("PROFILE",MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putInt("id",ID);
        e.putString("mobile",MOBILE);
        e.putString("user_id",USER_ID);
        e.putString("username",USERNAME);
        e.putString("unique_id",UNIQUE_ID);
        e.putString("pwd",PASSWORD);
        e.putString("country_code",COUNTRY_CODE);
        e.putBoolean("isLoggedIn",true);

        e.apply();


    }

    @Override
    public void response_object(JSONObject obj, int UniqueId) {
        if(UniqueId==6)
        {
            try {
                JSONArray data = obj.getJSONArray("data");
                if(data.length() > 0)
                {

                    saveDataToLocal(data.getJSONObject(0).getInt("id"),data.getJSONObject(0).getString("mobile"),data.getJSONObject(0).getString("user_id"),data.getJSONObject(0).getString("username"),data.getJSONObject(0).getString("unique_device_id"),data.getJSONObject(0).getString("password"),data.getJSONObject(0).getString("country_code"));
                    startActivity(Utils.Intent(Login.this, MP_After_Login.class));

                }
                else
                {
                    Toast.makeText(this, "Incorrect Password..", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void error_object(VolleyError error, int UniqueId) {

    }
}