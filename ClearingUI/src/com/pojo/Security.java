package com.pojo;

public class Security {
	private String ISIN;
	private String securityName;
	
	/*Default constructor for Security*/
	public Security() {
		ISIN = "000000000000";
		securityName = "NULL";
	}
	
	/*Parameterized constructor for Security*/
	public Security(String ISIN, String securityName) {
		this.ISIN = ISIN;
		this.securityName = securityName;
	}
	
	/*Getters and Setters for Security*/
	public String getISIN() {
		return ISIN;
	}

	public void setISIN(String ISIN) {
		this.ISIN = ISIN;
	}


	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	
	/*Display Security details*/
	@Override
	public String toString() {
		return "Security [ISIN=" + ISIN + ", securityName=" + securityName + "]";
	}
	

}
