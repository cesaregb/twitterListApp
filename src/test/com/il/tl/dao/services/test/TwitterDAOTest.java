package com.il.tl.dao.services.test;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import twitter4j.User;

import com.il.tl.dao.services.ITwitterUserDAO;
import com.il.tl.dao.services.impl.TwitterUserDAO;
import com.il.tw.exception.TwitterServiceException;

public class TwitterDAOTest {
	ITwitterUserDAO service = null;
	@Before
	public void setUp() throws Exception {
		service = new TwitterUserDAO();
	}

	@After
	public void tearDown() throws Exception {
		service = null;
	}

	@Test
	public void testGetUser() {
		try{
			User user = service.getUser();
			System.out.println(user.getName());
		}catch (TwitterServiceException tse){
			System.out.println("DAMN TwitterServiceException: " + tse.getExceptionCode());
			fail("DAMN TwitterServiceException: " + tse.getExceptionCode());
			
		}catch (Exception e){
			System.out.println("DAMN EXAPTION: " + e.getMessage());
			fail("DAMN EXAPTION");
		}
	}

//	@Test
//	public void testGetUserFriends() {
//		try{
//			IDs ids = service.getUserFriends(accessToken);
//			System.out.println(ids.getAccessLevel());
//		}catch (TwitterServiceException tse){
//			System.out.println("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			fail("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			
//		}catch (Exception e){
//			System.out.println("DAMN EXAPTION: " + e.getMessage());
//			fail("DAMN EXAPTION");
//		}
//	}
//	
//	@Test
//	public void testGetUserLists() {
//		try{
//			ResponseList<UserList> list = service.getUserLists(accessToken);
//			System.out.println(list.size());
//		}catch (TwitterServiceException tse){
//			System.out.println("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			fail("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			
//		}catch (Exception e){
//			System.out.println("DAMN EXAPTION: " + e.getMessage());
//			fail("DAMN EXAPTION");
//		}
//	}
//	
//	@Test
//	public void testSendTwitts() {
//		try{
//			service.sendTwitt("from the testing... ",accessToken);
//		}catch (TwitterServiceException tse){
//			System.out.println("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			fail("DAMN TwitterServiceException: " + tse.getExceptionCode());
//			
//		}catch (Exception e){
//			System.out.println("DAMN EXAPTION: " + e.getMessage());
//			fail("DAMN EXAPTION");
//		}
//	}
}
