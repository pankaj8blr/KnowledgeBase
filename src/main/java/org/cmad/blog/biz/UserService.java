package org.cmad.blog.biz;

import java.util.List;

import org.cmad.blog.api.AppUser;
import org.cmad.blog.api.PersonalInfo;
import org.cmad.blog.api.User;
import org.cmad.blog.api.exception.BlogException;
import org.cmad.blog.api.exception.UserNotFoundException;
import org.cmad.blog.data.AppUserDAO;
import org.cmad.blog.data.UserDAO;

public class UserService implements User {

	private UserDAO userDao = new AppUserDAO();

	
	public UserService() {
		super();
		this.userDao = new AppUserDAO();
	}
	
	public UserService(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	
	
	@Override
	public int addAppUser(AppUser appUser) throws UserNotFoundException {
		int appUserId = -1;
		// TODO Auto-generated method stub
		System.out.println("UserService.addAppUser()appUser: "+appUser);
		System.out.println("UserService.addAppUser()userDao: "+userDao);
		if(/*!isUserExist(appUser) &&*/ isUserPersonalInfoProper(appUser)){
			appUserId = userDao.addAppUser(appUser);
		}
		System.out.println("UserService.addAppUser()appUserId: "+appUserId);
		return appUserId;
	}


	@Override
	public AppUser updateAppUser(AppUser appUser) throws UserNotFoundException {
		AppUser updatedUser = null;
		System.out.println("UserService.updateAppUser()appUser: "+appUser);
		if(isUserExist(appUser) && isUserPersonalInfoProper(appUser)){
			userDao.updateAppUser(appUser);
		}
		System.out.println("UserService.updateAppUser()updatedUser: "+updatedUser);
		return updatedUser;
	}

	@Override
	public int authenticatedAppUser(AppUser appUser) throws UserNotFoundException {
		return userDao.authenticateAppUser(appUser);
	}
	
	private boolean isUserExist(AppUser user) throws UserNotFoundException{
		boolean isUserExist = false;
		if(user==null || user.getPersonalInfo()==null){
			throw new UserNotFoundException(UserNotFoundException.USER_NOT_FOUND);
		}else{
			isUserExist = true;
		}
		System.out.println("UserService.isUserExist()isUserExist: "+isUserExist);
		return isUserExist;
	}
	
	private boolean isUserPersonalInfoProper(AppUser user) throws UserNotFoundException{
		boolean isUserPersonalInfoProper = false;
		PersonalInfo personInfo = user.getPersonalInfo();
		if(personInfo.getName()!=null 
				&& personInfo.getName().trim().length()>0  
				&& personInfo.getPhoneNum()!=null 
				&& personInfo.getPhoneNum().trim().length()>0){
			isUserPersonalInfoProper = true;
		}else{
			throw new UserNotFoundException(UserNotFoundException.USER_DETAILS_NOT_PROPER);
		}
		System.out.println("UserService.isUserPersonalInfoProper()isUserPersonalInfoProper: "+isUserPersonalInfoProper);
		return isUserPersonalInfoProper;
	}

	

	@Override
	public List<AppUser> getAppUser() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser getAppUser(int appUserId) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}


}
