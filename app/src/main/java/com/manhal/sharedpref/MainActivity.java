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
    boolean isNofityTurnedNn;
    Integer integer1= 1;
    Integer integer2= 2;

    int addTwoNums(Integer i1, Integer i2){
       return i1 + i2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this );

        isNofityTurnedNn = sharedPreferences.getBoolean("Notifications", true);
        setupUI();
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

    void setupUI(){
        switifications = findViewById(R.id.switch1);
        switifications.setChecked(isNofityTurnedNn);
    }

    void logix(){}
}