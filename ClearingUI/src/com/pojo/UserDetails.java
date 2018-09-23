package com.pojo;
//comment1
public class UserDetails {
		private String email;
		private String userPass;
		private int userType;
		
		public UserDetails() {
			// TODO Auto-generated constructor stub
			email="NULL";
			userPass="NULL";
			userType=0;
		}

		public UserDetails(String email, String userPass, int userType) {
			this.email = email;
			this.userPass = userPass;
			this.userType = userType;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getUserPass() {
			return userPass;
		}

		public void setUserPass(String userPass) {
			this.userPass = userPass;
		}

		public int getUserType() {
			return userType;
		}

		public void setUserType(int userType) {
			this.userType = userType;
		}

		@Override
		public String toString() {
			return "UserDetails [email=" + email + ", userPass=" + userPass + ", userType=" + userType + "]";
		}
		
		
		
}
