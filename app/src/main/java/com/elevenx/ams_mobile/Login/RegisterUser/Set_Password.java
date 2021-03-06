package com.elevenx.ams_mobile.Login.RegisterUser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.elevenx.ams_mobile.API_STORE.API_Store;
import com.elevenx.ams_mobile.API_STORE.CallBack_Get;
import com.elevenx.ams_mobile.API_STORE.HIT_API;
import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Set_Password extends AppCompatActivity implements CallBack_Get {

    EditText et_pwd,et_confirm_pwd,et_username;
    Button btn_save_pwd;

    String TAG = "Set_Password";
    HIT_API api;
    String COUNTRY_CODE = "91";
    String MOBILE= "8800159126";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_password);

        initviews();
        clickListner();
        onCreateThings();

    }
    private void initviews()
    {
        et_pwd = findViewById(R.id.et_pwd);
        et_confirm_pwd = findViewById(R.id.et_confirm_pwd);
        btn_save_pwd = findViewById(R.id.btn_save_pwd);
        et_username = findViewById(R.id.et_username);
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
        api = new HIT_API();
        COUNTRY_CODE = getIntent().getStringExtra("country_code");
        MOBILE = getIntent().getStringExtra("mobile_number");
        Log.d(TAG, "onCreateThings: Mobile "+MOBILE);
    }

    private void onClick_save_pwd()
    {
        if(et_pwd.getText().toString().trim().equals(et_confirm_pwd.getText().toString().trim()))
        {
            Toast.makeText(this, "Password Saved", Toast.LENGTH_SHORT).show();
            postLoginDataToServer(MOBILE,et_pwd.getText().toString().trim(),et_username.getText().toString().trim(),getSerialNumber(),COUNTRY_CODE);

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



    private void postLoginDataToServer(String MOBILE,String PASSWORD,String USERNAME,String UNIQUE_DEVICE_NO,String COUNTRY_CODE)
    {
        api.GET_REQUEST_JSONOBJECT(this, API_Store.POST_LOGIN_DETAILS+MOBILE+"&pwd="+PASSWORD+"&username="+USERNAME+"&build_no="+UNIQUE_DEVICE_NO+"&country_code="+COUNTRY_CODE,this,2, Request.Method.POST);
    }

    @Override
    public void response_object(JSONObject obj, int UniqueId) {


        Log.d(TAG, "response_object: "+obj.toString());
        if(UniqueId == 2)
        {
            Toast.makeText(this, "Data Sex saved...", Toast.LENGTH_SHORT).show();
            startActivity(Utils.Intent(Set_Password.this, Verify_Mobile_no.class));
            finish();
        }

    }

    @Override
    public void error_object(VolleyError error, int UniqueId) {
        Log.d(TAG, "error_object: "+error);

    }
}