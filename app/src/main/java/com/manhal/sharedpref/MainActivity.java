package com.manhal.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Switch switifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this );

       boolean isNofityTurnedNn = sharedPreferences.getBoolean("Notifications", true);

        switifications = findViewById(R.id.switch1);
        switifications.setChecked(isNofityTurnedNn);

        switifications.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    // if the switch is checked be is checked .... user turned the notifications on
                    sharedPreferences.edit().putBoolean( "Notifications", true).apply();
                } else {
                    // notifications are turned off.
                    sharedPreferences.edit().putBoolean("Notifications", false).apply();

                }
            }
        });
    }
}