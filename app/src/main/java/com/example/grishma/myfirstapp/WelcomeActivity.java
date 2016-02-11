package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Shows welcome message to user on login
 */

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();

        HashMap<String, String> hashMap = (HashMap<String, String>) intent.getSerializableExtra("hashMap");
        String welcomeMessage = "Hello " + hashMap.get("username") + ". Welcome to our new app!" ;
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(welcomeMessage);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.welcomeContent);
        layout.addView(textView);
    }

}
