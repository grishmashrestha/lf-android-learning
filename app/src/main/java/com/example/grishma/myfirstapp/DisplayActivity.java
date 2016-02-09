package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.HashMap;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
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

//        Bundle extras = intent.getExtras();
//        String fullName = extras.getString("full_name");
//        String address = extras.getString("address");
//        String phone = extras.getString("phone_number");
//        String displayMessage = "Hello " + fullName + " from " + address + ". Is your number " + phone + "?";

        HashMap<String, String> hashMap = (HashMap<String, String>) intent.getSerializableExtra("hashMap");
        String displayMessage = "Hello " + hashMap.get("full_name") + " from " + hashMap.get("address") + ". Is your number " + hashMap.get("phone_number") + "?";
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(displayMessage);

        RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
        layout.addView(textView);
    }

}
