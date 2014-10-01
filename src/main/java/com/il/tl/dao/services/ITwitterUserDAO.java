package com.il.tl.dao.services;

import twitter4j.User;

import com.il.tw.exception.TwitterServiceException;

public interface ITwitterUserDAO {
	
	public User getUser() throws TwitterServiceException;

//	public ResponseList<UserList> getUserLists(UserAccessToken accessToken ) throws TwitterServiceException;
//	
//	public IDs getUserFriends(UserAccessToken accessToken) throws TwitterServiceException; 
//	
//	public void sendTwitt(String msg, UserAccessToken tlAccessTocken) throws TwitterServiceException;
}
