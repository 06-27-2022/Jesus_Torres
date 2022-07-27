package com.business.repository;

import java.util.List;

import com.business.model.userprofiles;

public interface userprofilesRepository {
	List<userprofiles> findAllUserprofiles();
	
	void newprofile(userprofiles User);
	
	userprofiles findbyUserName(String username);
	
	boolean checkPassword(String username, String password);
	
}
