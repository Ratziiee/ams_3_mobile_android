package com.elevenx.ams_mobile.Login.Login;

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
import com.elevenx.ams_mobile.Login.ForgotPassword.FP_Verify_OTP;
import com.elevenx.ams_mobile.Login.ForgotPassword.MP_ForgotPassword;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Verify_Mobile_no extends AppCompatActivity implements CallBack_Get {

    EditText et_mobile_no;
    Button btn_verify;

    String TAG = "Verify_Mobile_no";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_mobile_no);

        initViews();
        clickListner();
    }

    private  void initViews()
    {
        et_mobile_no=findViewById(R.id.et_mobile);

        btn_verify=findViewById(R.id.btn_verify);
    }

    private void clickListner()
    {
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_Login(et_mobile_no.getText().toString().trim());
            }
        });
    }

    private void onClick_Login(String Mobile) {

        HIT_API api = new HIT_API();
        api.GET_REQUEST_JSONOBJECT(this, API_Store.GET_DETAILS_FROM_MOBILE+Mobile,this,5, Request.Method.GET);


    }


    @Override
    public void response_object(JSONObject obj, int UniqueId) {
        if(UniqueId==5)
        {
            try {
                JSONArray data = obj.getJSONArray("data");
                if(data.length() > 0)
                {
                    startActivity(Utils.Intent(this,Login.class).putExtra("mobile",et_mobile_no.getText().toString().trim()));

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