// Credit: Prabeesh RK
// https://www.youtube.com/watch?v=DJjPPdyOxPY
// Author: Tiam Abderezai
// https://github.com/Tiam-Abderezai?tab=repositories

package com.example.sharedpreferencesexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreference mPref;
    private EditText mET_Username;
    private EditText mET_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPref = new SharedPreference(getApplicationContext());

        mET_Username = findViewById(R.id.username);
        mET_Password = findViewById(R.id.password);

        // Checks whether user already logged in or not
        // If returns true, means user already logged in
        if (mPref.readLoginStatus()) {
            startActivity(new Intent(this, SuccessActivity.class));
            finish();
        }

    }

    public void login(View view) {

        String username = mET_Username.getText().toString();
        String password = mET_Password.getText().toString();

        // If login is successful:
        if (username.equals(getResources().getString(R.string.username)) && password.equals(getResources().getString(R.string.password))) {
            // 1) start SuccessActivity
            startActivity(new Intent(this, SuccessActivity.class));
            // 2) save login_status in SharedPreference
            mPref.writeLoginStatus(true);
            finish();
        } else
            // Otherwise, tell user login failed and try again
            {
            Toast.makeText(this, "Login Failed... Try again...", Toast.LENGTH_SHORT).show();
            // and reset username and password
            mET_Username.setText("");
            mET_Password.setText("");
        }
    }
}