package com.elevenx.ams_mobile.Splash;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.elevenx.ams_mobile.Login.MP_Login;
import com.elevenx.ams_mobile.R;
import com.elevenx.ams_mobile.Utils.Utils;

public class Splash extends AppCompatActivity {


    //FIREBASE ID : dorid.elevenx@gmail.com
    // Pwd : enbenb123
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        OnCreateThings();

    }

    private void OnCreateThings()
    {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(Utils.Intent(Splash.this, MP_Login.class));
            }
        }, 3000);



    }
}