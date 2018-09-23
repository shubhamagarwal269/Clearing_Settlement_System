package com.dao;

public interface ResetPassword {
	boolean updatePassword(String currentPassword, String newPassword, String memberId);
}
