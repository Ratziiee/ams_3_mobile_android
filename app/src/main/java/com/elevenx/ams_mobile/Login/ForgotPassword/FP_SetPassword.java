package com.elevenx.ams_mobile.Login.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;

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
import com.elevenx.ams_mobile.Login.RegisterUser.Set_Password;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

import org.json.JSONObject;

public class FP_SetPassword extends AppCompatActivity implements CallBack_Get {

    EditText et_pwd,et_confirm_pwd;
    Button btn_save_pwd;

    String TAG = "FP_SetPassword";
    HIT_API api;
    String COUNTRY_CODE = "91";
    String MOBILE= "8800159126";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_p_set_password);

        initviews();
        clickListner();
        onCreateThings();
    }
    private void initviews()
    {
        et_pwd = findViewById(R.id.et_pwd);
        et_confirm_pwd = findViewById(R.id.et_confirm_pwd);
        btn_save_pwd = findViewById(R.id.btn_save_pwd);

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
            updatePassword(MOBILE,et_pwd.getText().toString().trim());

        }
    }

    private void updatePassword(String MOBILE,String PASSWORD)
    {
        api.GET_REQUEST_JSONOBJECT(this, API_Store.POST_UPDATE_PASSWORD+MOBILE+"&pwd="+PASSWORD,this,4, Request.Method.POST);
    }

    @Override
    public void response_object(JSONObject obj, int UniqueId) {
        if(UniqueId == 4)
        {
            Toast.makeText(this, "Data Sex saved...", Toast.LENGTH_SHORT).show();
            startActivity(Utils.Intent(FP_SetPassword.this, Verify_Mobile_no.class));
            finish();
        }
    }

    @Override
    public void error_object(VolleyError error, int UniqueId) {

    }
}