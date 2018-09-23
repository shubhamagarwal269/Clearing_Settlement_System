package com.dao_impl;

import java.util.Properties;
import java.util.Random;

import com.dao.ForgetPassword;

public class ForgetPasswordImpl implements ForgetPassword{
	  
	 static String tempPass = "abc";
	 private static final String CHAR_LIST = 
		        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    private static final int RANDOM_STRING_LENGTH = 10;
		     
		    /**
		     * This method generates random string
		     * @return
		     */
		    public String generateRandomString(){
		         
		        StringBuffer randStr = new StringBuffer();
		        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
		            int number = getRandomNumber();
		            char ch = CHAR_LIST.charAt(number);
		            randStr.append(ch);
		        }
		        return randStr.toString();
		    }
		     
		    /**
		     * This method generates random numbers
		     * @return int
		     */
		    private int getRandomNumber() {
		        int randomInt = 0;
		        Random randomGenerator = new Random();
		        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
		        if (randomInt - 1 == -1) {
		            return randomInt;
		        } else {
		            return randomInt - 1;
		        }
		    }
	@Override
	public void sendTempPassword(String emailId) {
		// TODO Auto-generated method stub
		
		ForgetPasswordImpl fp = new ForgetPasswordImpl();
        tempPass = fp.generateRandomString();
        String host = "smtp.gmail.com";
        String port = "587";
        String mailFrom = "cns065918@gmail.com";
        String password = "Admin_1234";
 
        // outgoing message information
        String mailTo = emailId;
        String subject = "Reset Password";
        String message = "Hello, your temporary password is: "+tempPass;
 
        TestMail mailer = new TestMail();
 
        try {
            mailer.sendPlainTextEmail(host, port, mailFrom, password, mailTo,
                    subject, message);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Failed to sent email.");
            ex.printStackTrace();
        }
       
		
	}
	
	// remove later, just for trying
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForgetPasswordImpl fp1 = new ForgetPasswordImpl();
		fp1.sendTempPassword("shriya.talwar99@gmail.com"); 
		  
	}


}
