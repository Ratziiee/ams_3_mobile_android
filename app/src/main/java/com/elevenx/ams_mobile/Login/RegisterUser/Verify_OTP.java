package com.elevenx.ams_mobile.Login.RegisterUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.elevenx.ams_mobile.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Verify_OTP extends AppCompatActivity {
    String Mobile_Number = "";

    EditText et_OTP;
    Button btn_verify,btn_resend;
    TextView tv_countDown;

    private String mVerificationId;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);

        initviews();
        clickListner();
        onCreateThings();


    }

    private void initviews()
    {
        et_OTP = findViewById(R.id.et_OTP);
        btn_verify = findViewById(R.id.btn_verify);
        btn_resend = findViewById(R.id.btn_resend);
        tv_countDown = findViewById(R.id.tv_countDown);
    }

    private void clickListner()
    {
        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClick_Verify();
            }
        });

        btn_resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode(Mobile_Number);
            }
        });
    }

    private void onCreateThings()
    {
        Mobile_Number = getIntent().getStringExtra("mobile_number");
        Toast.makeText(this, Mobile_Number, Toast.LENGTH_SHORT).show();

        mAuth = FirebaseAuth.getInstance();

        sendVerificationCode(Mobile_Number);

        countDown();
    }

    private void sendVerificationCode(String mobile_number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                mobile_number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallbacks);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            //Getting the code sent by SMS
            String code = phoneAuthCredential.getSmsCode();

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {
                et_OTP.setText(code);
                //verifying the code
                verifyVerificationCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Verify_OTP.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            //storing the verification id that is sent to the user
            mVerificationId = s;
        }
    };

    private void verifyVerificationCode(String code) {
        //creating the credential
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

        //signing the user
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(Verify_OTP.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //verification successful we will start the profile activity
                            Intent intent = new Intent(Verify_OTP.this, Set_Password.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            intent.putExtra("mobile_number",Mobile_Number);

                            startActivity(intent);

                        } else {

                            //verification unsuccessful.. display an error message

                            String message = "Somthing is wrong, we will fix it soon...";

                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                message = "Invalid code entered...";
                            }

                            Toast.makeText(Verify_OTP.this, message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void onClick_Verify()
    {
        String code = et_OTP.getText().toString().trim();
        verifyVerificationCode(code);
    }

    private void countDown()
    {
        new CountDownTimer(60000, 1000) {

            public void onTick(long millisUntilFinished) {
                tv_countDown.setText("Resend after " + millisUntilFinished / 1000+" seconds: ");
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                btn_resend.setVisibility(View.VISIBLE);
            }

        }.start();
    }
}