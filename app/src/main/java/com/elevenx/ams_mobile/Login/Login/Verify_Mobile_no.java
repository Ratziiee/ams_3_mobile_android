package com.elevenx.ams_mobile.Login.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class Verify_Mobile_no extends AppCompatActivity {

    EditText et_mobile_no;
    Button btn_verify;

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

        startActivity(Utils.Intent(this,Login.class).putExtra("mobile",Mobile));

    }
}