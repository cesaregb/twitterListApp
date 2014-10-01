package com.il.tl.dao.services.impl;

import static com.il.tl.builder.TitterServiceBuilder.buildIntance;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;

import com.il.tl.dao.services.ITwitterUserDAO;
import com.il.tw.exception.TwitterServiceException;

public class TwitterUserDAO implements ITwitterUserDAO {

	public User getUser()
			throws TwitterServiceException {
		User tUser = null;
		try {
			Twitter twitter = buildIntance();
			tUser = twitter.verifyCredentials();
		} catch (TwitterException te) {
			System.out.println("Failed to show the list: " + te.getMessage());
			throw new TwitterServiceException(TwitterServiceException.CAUSE_ONE, te);
		}
		return tUser;
	}
	
//	@Override
//	public IDs getUserFriends(UserAccessToken tlAccessTocken) throws TwitterServiceException {
//		IDs ids = null;
//		try {
//			Twitter twitter = buildIntance(tlAccessTocken);
//			User tUser = twitter.verifyCredentials();
//			ids = twitter.getFriendsIDs(tUser.getId() , -1);
//			long[] idArray = ids.getIDs();
//			for (int i = 0; i < idArray.length; i++){
//				System.out.println(idArray[i]);
//			}
//		} catch (TwitterException te) {
//			System.out.println("Failed to show the list: " + te.getMessage());
//			throw new TwitterServiceException(TwitterServiceException.CAUSE_ONE, te);
//		}
//		return ids;
//	}
//
//
//	@Override
//	public ResponseList<UserList> getUserLists(UserAccessToken tlAccessTocken)
//			throws TwitterServiceException {
//		ResponseList<UserList> userLists = null;
//		try {
//			Twitter twitter = buildIntance(tlAccessTocken);
//			User tUser = twitter.verifyCredentials();
//			userLists = twitter.getUserLists(tUser.getId());
//			for (UserList list : userLists) {
//				System.out.println("id:" + list.getId() + ", name:" + list.getName() + ", description:"
//						+ list.getDescription() + ", slug:" + list.getSlug() + "");
//			}
//		} catch (TwitterException te) {
//			System.out.println("Failed to show the list: " + te.getMessage());
//			throw new TwitterServiceException(TwitterServiceException.CAUSE_ONE, te);
//		}
//		return userLists;
//	}
//
//	@Override
//	public void sendTwitt(String msg, UserAccessToken tlAccessTocken) throws TwitterServiceException {
//		try {
//			Twitter twitter = null;
//            try {
//            	twitter = buildIntance(tlAccessTocken);
//            } catch (IllegalStateException ie) {
//                if (!twitter.getAuthorization().isEnabled()) {
//                    System.out.println("OAuth consumer key/secret is not set. " + ie.getMessage());
//                }
//                throw new TwitterServiceException(TwitterServiceException.CAUSE_ONE, ie);
//            }
//            Status status = twitter.updateStatus(msg);
//            System.out.println("Successfully updated the status to [" + status.getText() + "].");
//        } catch (TwitterException te) {
//            te.printStackTrace();
//            System.out.println("Failed to get timeline: " + te.getMessage());
//            throw new TwitterServiceException(TwitterServiceException.CAUSE_ONE, te);
//        } 
//	}
	
}
