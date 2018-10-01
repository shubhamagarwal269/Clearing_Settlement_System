package com.ui;


import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.Toast;
import com.dao.SignInPage;
import com.dao_impl.SignInPageImpl;
import com.example.ubuntu.clearing_settlement_system.R;


public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    ProgressBar progressBar;
    private String type="Member";
    private int userType=1;


    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    public void login(View view){
        SignInPage signInPage = new SignInPageImpl();
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        if(validateEmailAndPassword()) {
            if (isConnected()) {
                if(type.equals("Admin")){
                    if(email.equals("cns065918@gmail.com") && password.equals("admin@123")){
                        startActivity(new Intent(this, adminDashboard.class));
                    }
                    else{
                        Toast.makeText(this, "Wrong credentials!", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    int status = signInPage.login(email,password);
                    if (status>0) {
                        startActivity(new Intent(this, memberDashboard.class));
                    }
                    else {
                        Toast.makeText(this, "Wrong credentials!", Toast.LENGTH_LONG).show();
                    }
                }
            }
            else{
                Toast.makeText(this, "Check internet connectivity!", Toast.LENGTH_LONG).show();
            }
        }

        return;
    }

    private boolean validateEmailAndPassword(){
        boolean validate = true;
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();

        if(type.equals("Guest"))
            return true;

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

        if(TextUtils.isEmpty(password)){
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            validate = false;
        }

        if(password.length()<6) {
            editTextPassword.setError("Minimum length of password should be 6");
            editTextPassword.requestFocus();
            validate = false;
        }


        return validate;
    }

    private boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    public void goToSignup(View view) {
        startActivity(new Intent(this, signUpPage.class));
        finish();
    }

    public void goToForgetPassword(View view){

        startActivity(new Intent(this, forgetPassword.class));
        finish();
    }

    public void selectLoginType(View view){

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()){
            case R.id.radioMember:
                if(checked)
                    editTextEmail.setText(null);
                    editTextEmail.setError(null);
                    editTextPassword.setText(null);
                    editTextPassword.setError(null);
                    editTextEmail.setHint("Member Email Id");
                    type = "Member";
                    userType = 1;
                break;
            case R.id.radioAdmin:
                if(checked)
                    editTextEmail.setText(null);
                    editTextEmail.setError(null);
                    editTextPassword.setText(null);
                    editTextPassword.setError(null);
                    editTextEmail.setHint("Admin Email Id");
                    type = "Admin";
                    userType = 0;
                break;
        }
    }

}
