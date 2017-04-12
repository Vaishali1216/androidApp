package com.example.vaish.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


/**
 * Created by twiganator on 4/11/17.
 */

public class HomeActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        //gets the user's name and displays it in the home screen
        String username = getIntent().getStringExtra("Username");
        TextView displayUname = (TextView)findViewById(R.id.displayUsername);
        displayUname.setText(username);
    }
}
