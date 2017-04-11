package com.example.vaish.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by twiganator on 4/11/17.
 */

public class RegisterActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgiter);
    }

    public void onRegisterClick(View v){
        if(v.getId() == R.id.register){
            Intent i = new Intent(RegisterActivity.this, HomeActivity.class);
            startActivity(i);
        }
    }
}
