package com.elevenx.ams_mobile.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.elevenx.ams_mobile.AfterLogin.MP_After_Login;
import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.Login.RegisterUser.Register_User;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class View_Profile extends AppCompatActivity {

    TextView tv_name,tv_mobile,tv_userid,tv_unique_id;
    Button btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViewss();
        clickListners();
    }

    private void initViewss()
    {
        tv_name=findViewById(R.id.tv_name);
        tv_mobile=findViewById(R.id.tv_Mobile_no);
        tv_userid = findViewById(R.id.tv_user_id);
        tv_unique_id = findViewById(R.id.tv_Unique_id);
        btn_logout=findViewById(R.id.btn_logout);
    }

    private void clickListners()
    {
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(View_Profile.this, "Logout", Toast.LENGTH_SHORT).show();

                startActivity(Utils.Intent(View_Profile.this, Verify_Mobile_no.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            Intent i =new Intent(getApplicationContext(), Edit_Profile.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}