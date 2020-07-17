package com.elevenx.ams_mobile.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class Edit_Profile extends AppCompatActivity {

    EditText et_name,et_mobile,et_userid,et_unique_id;
    Button btn_update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        initViewss();
        clickListners();
    }

    private void initViewss()
    {
        et_name=findViewById(R.id.et_name);
        et_mobile=findViewById(R.id.et_Mobile_no);
        et_userid = findViewById(R.id.et_user_id);
        et_unique_id = findViewById(R.id.et_Unique_id);
        btn_update=findViewById(R.id.btn_update);
    }

    private void clickListners()
    {
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Edit_Profile.this, "Update", Toast.LENGTH_SHORT).show();

                startActivity(Utils.Intent(Edit_Profile.this, Verify_Mobile_no.class));
            }
        });

    }
}