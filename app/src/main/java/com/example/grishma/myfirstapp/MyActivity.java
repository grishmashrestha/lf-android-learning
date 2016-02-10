package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyActivity extends AppCompatActivity {
    @Bind(R.id.fullName) EditText fullName;
    @Bind(R.id.address) EditText address;
    @Bind(R.id.phoneNumber) EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayActivity.class);

        String fullNameString = fullName.getText().toString();
        String addressString = address.getText().toString();
        String phoneNumberString = phoneNumber.getText().toString();

//        Bundle extras = new Bundle();
//        extras.putString("full_name", fullNameString);
//        extras.putString("address", addressString);
//        extras.putString("phone_number", phoneNumberString);
//        intent.putExtras(extras);

        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("full_name", fullNameString);
        hashMap.put("address", addressString);
        hashMap.put("phone_number", phoneNumberString);

        intent.putExtra("hashMap", hashMap);
        startActivity(intent);
    }
}
