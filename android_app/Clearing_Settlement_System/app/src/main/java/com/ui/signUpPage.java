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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dao.CommonFunctionalities;
import com.dao.SignUpPage;
import com.dao_impl.CommonFunctionalitiesImpl;
import com.dao_impl.SignUpPageImpl;
import com.example.ubuntu.clearing_settlement_system.R;
import com.pojo.Member;
import com.pojo.UserDetails;

public class signUpPage extends AppCompatActivity {
    ProgressBar progressBar;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editBankAccNo;
    private EditText editDematAccNo;
    private EditText editMemberName;
    private EditText editTextConfirmPassword;

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_page);


        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editMemberName = (EditText) findViewById(R.id.editMemberName);
        editBankAccNo = (EditText) findViewById(R.id.editBankAccNumber);
        editDematAccNo = (EditText) findViewById(R.id.editDematAccNumber);
        editTextConfirmPassword = (EditText) findViewById(R.id.editTextConfirmPassword);

    }

    public void signup(View view) {
        SignUpPage signUpPage = new SignUpPageImpl();
        CommonFunctionalities commonFunc = new CommonFunctionalitiesImpl();
        String name = editMemberName.getText().toString().trim();
        int bankAccNum = Integer.parseInt(editBankAccNo.getText().toString().trim());
        int dematAccNum = Integer.parseInt(editDematAccNo.getText().toString().trim());
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        int memId = commonFunc.getNextMemberId();
        Member mem = new Member(memId,name,password,email,bankAccNum,dematAccNum);
        if(validateFields()){
            if(isConnected()) {
                int flag = signUpPage.registerMember(mem);
                if(flag>0) {
                    Toast.makeText(this, "Sign up Successful! Please log in", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, MainActivity.class));
                    finish();
                }
                else{
                    Toast.makeText(this, "Please try again!", Toast.LENGTH_LONG).show();
                }
            }
            else{
                Toast.makeText(this, "Please check internet connectivity!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean validateFields(){
        boolean validate = true;
        //getting email and password from edit texts
        String name = editMemberName.getText().toString().trim();
        String bankAccNum = editBankAccNo.getText().toString().trim();
        String dematAccNum = editDematAccNo.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();
        String confirmPassword  = editTextConfirmPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if(TextUtils.isEmpty(name)){
            editMemberName.setError("Please enter member name");
            editMemberName.requestFocus();
            validate = false;
        }
        if(!name.matches("[a-zA-Z ]*")){
            editMemberName.setError("Please enter valid name");
            editMemberName.requestFocus();
            validate = false;
        }
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
            editTextEmail.setError("Email id already exists");
            editTextEmail.requestFocus();
            validate = false;
        }
        if(bankAccNum.length()!=10){
            editBankAccNo.setError("Length of bank account number should be 10");
            editBankAccNo.requestFocus();
            Toast.makeText(this, Integer.toString(bankAccNum.length()), Toast.LENGTH_LONG).show();
            validate = false;
        }
        if(!bankAccNum.matches("[0-9]*")){
            editBankAccNo.setError("Bank Account number can only be numeric");
            editBankAccNo.requestFocus();
            validate = false;
        }
        if(dematAccNum.length()!=10){
            editDematAccNo.setError("Length of demat account number should be 10");
            editDematAccNo.requestFocus();
            validate = false;
        }
        if(!dematAccNum.matches("[0-9]*")){
            editDematAccNo.setError("Demat Account number can only be numeric");
            editDematAccNo.requestFocus();
            validate = false;
        }
        if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,}$")){
            editTextPassword.setError("Minimum six characters, at least one uppercase letter, one lowercase letter, one number and one special character");
            editTextPassword.requestFocus();
            validate = false;
        }
        if(!confirmPassword.equals(password)){
            editTextConfirmPassword.setError("Password and confirm password do not match");
            editTextConfirmPassword.requestFocus();
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

    public void goToLogin(View view) {
        //calling register method on click
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
