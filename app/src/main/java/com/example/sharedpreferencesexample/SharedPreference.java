// Credit: Prabeesh RK
// https://www.youtube.com/watch?v=DJjPPdyOxPY
// Author: Tiam Abderezai
// https://github.com/Tiam-Abderezai?tab=repositories

package com.example.sharedpreferencesexample;

import android.content.Context;
import android.content.SharedPreferences;



// Handles the SharedPreferences' operations
public class SharedPreference {
    private SharedPreferences mPref;
    private Context mContext;

    public SharedPreference(Context context) {
        this.mContext = context;
        // 1st parameter is the file name
        // 2nd parameter allows only the app to read/write the preference
        mPref = context.getSharedPreferences(
                context.getResources().getString(R.string.login_preference),
                Context.MODE_PRIVATE);
    }

    // Save the SharedPreferences status (true/false)
    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = mPref.edit();

        // 1st parameter is the key for the data
        // 2nd parameter is the boolean status
        editor.putBoolean(
                mContext.getResources().getString(R.string.login_status_preference),
                status);
        // Saves the changes
        editor.commit();

    }

    //
    public boolean readLoginStatus() {
        // Default value
        boolean status = false;

        // 1st parameter is the key for the data
        // 2nd parameter is the default value (false)
        status = mPref.getBoolean(mContext.getResources().getString(R.string.login_status_preference), false);
        return status;
    }
}
