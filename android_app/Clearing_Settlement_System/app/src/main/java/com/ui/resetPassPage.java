package com.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ubuntu.clearing_settlement_system.R;

public class resetPassPage extends AppCompatActivity {

    private EditText editCurrentPassword;
    private EditText editNewPassword;
    private EditText editNewConfirmPassword;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_pass_page);

        //initializing views
        editCurrentPassword = (EditText) findViewById(R.id.editCurrentPassword);
        editNewPassword = (EditText) findViewById(R.id.editNewPassword);
        editNewConfirmPassword = (EditText) findViewById(R.id.editNewConfirmPassword);
    }

    public void confirm(View view) {
        if (validatePasswords()) {
            if (isConnected()) {
                Toast.makeText(this, "Password changed successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(this, MainActivity.class));
            }
            else{
                Toast.makeText(this, "Check internet connectivity!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void goBack(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

    private boolean validatePasswords(){
        boolean validate = true;
        String currentPassword = editCurrentPassword.getText().toString().trim();
        String newPassword = editNewPassword.getText().toString().trim();
        String newConfirmPassword = editNewConfirmPassword.getText().toString().trim();

        if(alreadyExists(currentPassword)){
            editCurrentPassword.setError("Current/Temporary password do not match");
            editCurrentPassword.requestFocus();
            validate = false;
        }
        if(!newPassword.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$")){
            editNewPassword.setError("Minimum six characters, at least one uppercase letter, one lowercase letter, one number and one special character");
            editNewPassword.requestFocus();
            validate = false;
        }
        if(newPassword.equals(currentPassword)){
            editNewPassword.setError("Old and new password can not be same");
            editNewPassword.requestFocus();
            validate = false;
        }
        if(!newConfirmPassword.equals(newPassword)){
            editNewConfirmPassword.setError("Password and confirm password do not match");
            editNewConfirmPassword.requestFocus();
            validate = false;
        }

        return validate;
    }

    private boolean alreadyExists(String currentPassword){
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
