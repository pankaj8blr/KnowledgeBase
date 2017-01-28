package org.cmad.blog.data;

import java.util.List;

import org.cmad.blog.api.AppUser;

public interface UserDAO {

	int addAppUser(AppUser appUser);

	AppUser updateAppUser(AppUser appUser);

	int authenticateAppUser(AppUser appUser);

	AppUser getAppUser(String appUserName, String appUserPwd);
	
	AppUser getAppUser(Integer appUserId);
	
	public List<AppUser> getAppUsers() ;
	

	boolean insertAppUser(AppUser appUser);

	boolean deleteAppUser(AppUser appUser);

}