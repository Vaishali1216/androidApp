package com.example.vaish.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    AppDatabase database_obj = new AppDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void onButtonClick(View v){
        if(v.getId() == R.id.sign_in){

            EditText uname = (EditText)findViewById(R.id.username);
            String uname_str = uname.getText().toString();
            EditText pass = (EditText)findViewById(R.id.password);
            String pass_str = pass.getText().toString();

            String password = database_obj.searchPassword(uname_str);   //retrieving the

            if(pass_str.equals(password)){
                Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                i.putExtra("Username", uname_str);
                startActivity(i);
            }
            else {
                Toast error = Toast.makeText(LoginActivity.this, "Username and password don't match", Toast.LENGTH_SHORT);
                error.show();
            }
        }
    }

    public void onRegisterClick(View v){
        if(v.getId() == R.id.register){
            Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(i);

        }
    }
}
