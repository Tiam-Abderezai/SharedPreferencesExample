// Credit: Prabeesh RK
// https://www.youtube.com/watch?v=DJjPPdyOxPY
// Author: Tiam Abderezai
// https://github.com/Tiam-Abderezai?tab=repositories

package com.example.sharedpreferencesexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;



public class SuccessActivity extends AppCompatActivity {
    private SharedPreference mPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        mPref = new SharedPreference(getApplicationContext());
    }

    public void logout(View view) {
        mPref.writeLoginStatus(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
