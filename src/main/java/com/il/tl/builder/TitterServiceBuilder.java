package com.il.tl.builder;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import com.il.tl.dto.UserAccessToken;
import com.il.tl.utils.ConfigUtil;
import com.il.tw.exception.TwitterServiceException;

public class TitterServiceBuilder {
	
	public static Twitter buildIntance(UserAccessToken tlAccessTocken)
			throws TwitterServiceException {
		
		Twitter twitter = new TwitterFactory().getInstance();
		AccessToken accessToken = null;
		accessToken = new AccessToken(tlAccessTocken.getAccessToken(),
				tlAccessTocken.getAccessTokenSecret());
		twitter.setOAuthAccessToken(accessToken);
		return twitter;
	}
	
	public static Twitter buildIntance()
			throws TwitterServiceException {
		
		Twitter twitter = new TwitterFactory().getInstance();
		AccessToken accessToken = new AccessToken(
				ConfigUtil.getConfigurationItem(ConfigUtil.OAUTH_CONSUMERKEY),
				ConfigUtil.getConfigurationItem(ConfigUtil.OAUTH_CONSUMERSECRET));
		twitter.setOAuthAccessToken(accessToken);
		return twitter;
	}
}
