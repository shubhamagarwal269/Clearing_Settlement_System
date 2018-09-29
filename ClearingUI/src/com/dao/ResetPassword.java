package com.dao;

public interface ResetPassword {
	int updatePassword(String newPassword, String memberMail);
	int delPasswordFromTemplist(String memberMail);
}
