package com.example.ssa3410.cafe;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ssa3410 on 11/19/2017.
 */

public class Step1  extends AppCompatActivity {
private Button btn_confirmation;
private TextView step1_mobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step_1);
        step1_mobile=(TextView) findViewById(R.id.step1_mobile);
        btn_confirmation=(Button) findViewById(R.id.btn_confirmation);
        btn_confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (step1_mobile.getText().toString().trim().equals(""))
                    step1_mobile.setError("Mobile Number is required");
                else if(step1_mobile.getText().toString().trim().length()<10)
                step1_mobile.setError("Invalid Mobile Number");
                else {
                    Intent step1 = new Intent(Step1.this, Step2.class);
                    startActivity(step1);
                }

            }
        });
    }
}