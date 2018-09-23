package com.dao;

import com.pojo.Member;
import com.pojo.UserDetails;

public interface SignUpPage {
	int registerMember(Member member,UserDetails user);
}
