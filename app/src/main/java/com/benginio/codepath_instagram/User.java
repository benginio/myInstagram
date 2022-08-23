package com.benginio.codepath_instagram;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class User extends ParseObject {
    public static final String KEY_USERNAME="username";
    public static final String KEY_PASSWORD="password";

    public String getUsername(){
        return getString(KEY_USERNAME);
    }
    public void setUsername(String username){
        put (KEY_USERNAME, username);
    }
    public String getPassword(){
        return getString(KEY_PASSWORD);
    }
    public void setPassword(String password){
        put (KEY_PASSWORD, password);
    }

}
