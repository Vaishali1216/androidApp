package com.example.vaish.myapplication;

import android.util.Log;

/**
 * Created by twiganator on 4/11/17.
 */

public class UserInformation {

    public String username;
    public String password;

//    public void setId(int id){
//        this.id = id;
//    }
//
//    public int getId(){
//        return this.id;
//    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
}
