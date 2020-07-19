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
import com.elevenx.ams_mobile.Login.RegisterUser.Register_User;
import com.elevenx.ams_mobile.Login.RegisterUser.Verify_OTP;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MP_ForgotPassword extends AppCompatActivity implements CallBack_Get {

    EditText et_mobile_no;
    Button btn_submit;
    private static String TAG = "MP_ForgotPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mp_forgot_password);

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
                onClick_Submit(et_mobile_no.getText().toString().trim());
            }
        });
    }

    private void onClick_Submit(String Phone_Number)
    {
        Log.d(TAG, "onClick_Submit: Phone Number : "+Phone_Number);
        HIT_API api = new HIT_API();
        api.GET_REQUEST_JSONOBJECT(this, API_Store.GET_DETAILS_FROM_MOBILE+Phone_Number,this,3, Request.Method.GET);
    }

    @Override
    public void response_object(JSONObject obj, int UniqueId) {
        if(UniqueId==3)
        {
            try {
                JSONArray data = obj.getJSONArray("data");
                if(data.length() > 0)
                {
                    startActivity(Utils.Intent(MP_ForgotPassword.this, FP_Verify_OTP.class).putExtra("mobile_number",et_mobile_no.getText().toString().trim()).putExtra("country_code","91"));

                }
                else
                {
                    Toast.makeText(this, "No User Exists..", Toast.LENGTH_SHORT).show();
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