package com.elevenx.ams_mobile.AfterLogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.elevenx.ams_mobile.AfterLogin.CreateOrganization.Create_Organization;
import com.elevenx.ams_mobile.AfterLogin.JoinOrganization.Join_Organization;
import com.elevenx.ams_mobile.Login.Login.Verify_Mobile_no;
import com.elevenx.ams_mobile.Login.RegisterUser.Register_User;
import com.elevenx.ams_mobile.Profile.View_Profile;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class MP_After_Login extends AppCompatActivity {

    Button btn_create_organization, btn_join_organization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after__login);

        initViewss();
        clickListners();
    }

    private void initViewss()
    {
        btn_create_organization = findViewById(R.id.btn_create_organization);
        btn_join_organization = findViewById(R.id.btn_join_organization);
    }

    private void clickListners()
    {
        btn_create_organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MP_After_Login.this, "Register", Toast.LENGTH_SHORT).show();

                startActivity(Utils.Intent(MP_After_Login.this, Create_Organization.class));
            }
        });

        btn_join_organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MP_After_Login.this, "Sign IN", Toast.LENGTH_SHORT).show();
                startActivity(Utils.Intent(MP_After_Login.this, Join_Organization.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.profile, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_profile) {
            Intent i =new Intent(getApplicationContext(), View_Profile.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}