package com.example.grishma.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.grishma.myfirstapp.util.Validator;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Shows user login form
 */

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
        Log.i("MyActivity", "at onCreate.");
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
        Validator validator = new Validator();



        if (!validator.validateUsername(usernameString) && !validator.validatePassword(passwordString)) {
            username.setError("invalid username");
            password.setError("invalid password");
            isBothValid = false;
        } else if (!validator.validateUsername(usernameString)) {
            isBothValid = false;
            username.setError("invalid username");
        } else if (!validator.validatePassword(passwordString)) {
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

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MyActivity", "at onResume.");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MyActivity", "at onRestart.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MyActivity", "at onPause.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MyActivity", "at onStop.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MyActivity", "at onDestroy.");
    }
}
