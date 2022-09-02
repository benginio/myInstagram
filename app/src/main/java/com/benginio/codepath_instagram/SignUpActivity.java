package com.benginio.codepath_instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {
    public static final String TAG="SignUpActivity";
    private EditText etUsername1;
    private EditText etPassword1;
    private EditText etConfirmPassword;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarr);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //inflate
        etUsername1=findViewById(R.id.etUsername1);
        etPassword1=findViewById(R.id.etPassword1);
        etConfirmPassword=findViewById(R.id.etConfirmPassword);
        btnCreate=findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=etUsername1.getText().toString();
                String pass=etPassword1.getText().toString();
                String conPass=etConfirmPassword.getText().toString();
                if(username.isEmpty() || pass.isEmpty() || conPass.isEmpty()){
                    Toast.makeText(SignUpActivity.this, "the  are a field empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pass.equalsIgnoreCase(conPass)){
                    Toast.makeText(SignUpActivity.this, "confirm password is differen to password !", Toast.LENGTH_SHORT).show();
                    return;
                }

                CreateUser(username, pass);
                Toast.makeText(SignUpActivity.this, "Success", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void CreateUser(String username, String pass) {
        // Create the ParseUser
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(pass);
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if(e!=null){
                    Log.i(TAG,"Error while saving");
                    Toast.makeText(SignUpActivity.this, "Error while saving", Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i(TAG,"User save was Successful");
                etUsername1.setText("");
                etPassword1.setText("");
                etConfirmPassword.setText("");
                goLogin();
            }
        });

    }

    private void goLogin() {
        Intent i=new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}