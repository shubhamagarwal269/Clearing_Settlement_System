package com.dao;

public interface ResetPassword {
	int updatePassword(String currentPassword, String newPassword, int memberId);
}
