package com.example.vaish.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by twiganator on 4/11/17.
 */

public class RegisterActivity extends Activity{

    AppDatabase database_obj = new AppDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgiter);
    }

    /**
     *
     *Takes in a View object which usually represents a rectangular area on the prototype
     * @param v
     */
    public void onRegisterClick(View v){
        if(v.getId() == R.id.register){


            EditText uname = (EditText)findViewById(R.id.username);
            String uname_str = uname.getText().toString();
            EditText pass = (EditText)findViewById(R.id.password);
            String pass_str = pass.getText().toString();
            EditText confirmPass = (EditText)findViewById(R.id.confirmPassword);
            String confirmPass_str = confirmPass.getText().toString();

            //checks if the password and the confirm password are the same if not then there will be a pop up
            //it won't register if it's different
            if(!pass_str.equals(confirmPass_str)){

                //Pop up message if passwords don't match
                Toast error = Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_LONG);
                error.show();
            }
            else
            {
                //Inserting info in the database
                UserInformation userInfo_obj = new UserInformation();
                userInfo_obj.setUsername(uname_str);
                userInfo_obj.setPassword(pass_str);

                database_obj.insertInfo(userInfo_obj);

                //Pop message after registered
                Toast reg_message = Toast.makeText(RegisterActivity.this, "Now go back to login form!", Toast.LENGTH_LONG);
                reg_message.show();
            }

        }
    }
}
