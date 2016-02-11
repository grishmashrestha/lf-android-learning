package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyActivity extends AppCompatActivity {
    @Bind(R.id.txtUsername) EditText username;
    @Bind(R.id.txtPassword) EditText password;

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

    public void loginProcess(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);

        String usernameString = username.getText().toString();
        String passwordString = password.getText().toString();
        boolean isBothValid;

        if (!validateUsername(usernameString)) {
            isBothValid = false;
            username.setError("invalid username");
        } else if (!validatePassword(passwordString)) {
            isBothValid = false;
            password.setError("invalid password");
        } else {
            isBothValid = true;
        }

        if (isBothValid) {
            HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("username", usernameString);
            intent.putExtra("hashMap", hashMap);
            startActivity(intent);
        }
    }

    private Boolean validateUsername(String username) {
        boolean flag = false;
        if (username.length() <= 10) {
            flag = true;
        }
        return flag;
    }

    private Boolean validatePassword(String password) {
        boolean flag = false;
        if (password.length() == 4) {
            flag = true;
        }
        return flag;
    }
}
