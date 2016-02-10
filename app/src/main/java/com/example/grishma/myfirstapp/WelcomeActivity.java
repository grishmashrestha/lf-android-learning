package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

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
