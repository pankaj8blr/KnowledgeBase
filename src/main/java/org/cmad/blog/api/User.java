package org.cmad.blog.api;

import java.util.List;

import org.cmad.blog.api.exception.UserNotFoundException;

public interface User {

	int addAppUser(AppUser user) throws UserNotFoundException;

	AppUser updateAppUser(AppUser user) throws UserNotFoundException;

	int authenticatedAppUser(AppUser user) throws UserNotFoundException;

	List<AppUser> getAppUser() throws UserNotFoundException;

	AppUser getAppUser(int appUserId) throws UserNotFoundException;

}