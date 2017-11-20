package com.example.ssa3410.cafe;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/**
 * Created by ssa3410 on 11/20/2017.
 */

public class Step2 extends AppCompatActivity{
    private Button btn_verifyOTP;
    private TextView step2_otp;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_2);
        step2_otp = (TextView) findViewById(R.id.step2_otp);
        btn_verifyOTP = (Button) findViewById(R.id.btn_verifyOTP);
        btn_verifyOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step2_otp.getText().toString().trim().equals(""))
                    step2_otp.setError("OTP is required");
                else if (step2_otp.getText().toString().trim().length() < 6)
                    step2_otp.setError("Invalid OTP");
                else {
                    Intent step2 = new Intent(Step2.this, MainActivity.class);
                    startActivity(step2);
                }
            }
        });

        final TextView timer = (TextView) findViewById(R.id.timer);
        CountDownTimer Count = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                String text = String.format(Locale.getDefault(), "Time Remaining %02d min: %02d sec",
                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60,
                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60);
                timer.setText(text);
            }

            public void onFinish() {
                //  textic.setText("Finished");
            }
        };
        Count.start();
    }

}

