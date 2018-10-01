package com.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ubuntu.clearing_settlement_system.R;

public class forgetPassword extends AppCompatActivity {
    private EditText editTextEmail;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
    }

    public void goNext(View view) {
        if (validateEmailAndPassword()) {
            if (isConnected()) {
                startActivity(new Intent(this, resetPassPage.class));
            }
            else{
                Toast.makeText(this, "Check internet connectivity!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void goBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    private boolean validateEmailAndPassword(){
        boolean validate = true;
        String email = editTextEmail.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            editTextEmail.setError("Please enter email id");
            editTextEmail.requestFocus();
            validate = false;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter a valid email id");
            editTextEmail.requestFocus();
            validate = false;
        }

        if(alreadyExists(email)){
            editTextEmail.setError("Email id does not exists");
            editTextEmail.requestFocus();
            validate = false;
        }

        return validate;
    }

    private boolean alreadyExists(String email){
        boolean flag = false;
        return flag;
    }

    private boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }
}
