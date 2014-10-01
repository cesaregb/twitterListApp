package com.il.tl.dao.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public final class UpdateStatus {
	/**
     * Usage: java twitter4j.examples.tweets.UpdateStatus [text]
     *
     * @param args message
     */
    public void twittThisInBehalf(String twitterMessage) {
        try {
            Twitter twitter = new TwitterFactory().getInstance();
            try {
                // get request token.
                // this will throw IllegalStateException if access token is already available
                RequestToken requestToken = twitter.getOAuthRequestToken();
                System.out.println("Got request token.");
                System.out.println("Request token: " + requestToken.getToken());
                System.out.println("Request token secret: " + requestToken.getTokenSecret());
                AccessToken accessToken = null;
                accessToken = new AccessToken("1710981037-EJLpqSiD5HOeGUUyVY4IxOkMwh9hgnURYJIBDXW", "Cxc0VpLzEgOpYhsMKrqYjKzIhV5MUTtDhpEMJJRUxyqaf");
                twitter.setOAuthAccessToken(accessToken);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                while (null == accessToken) {
                    System.out.println("Open the following URL and grant access to your account:");
                    System.out.println(requestToken.getAuthorizationURL());
                    System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
                    String pin = br.readLine();
                    try {
                        if (pin.length() > 0) {
                            accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                        } else {
                            accessToken = twitter.getOAuthAccessToken(requestToken);
                        }
                    } catch (TwitterException te) {
                        if (401 == te.getStatusCode()) {
                            System.out.println("Unable to get the access token.");
                        } else {
                            te.printStackTrace();
                        }
                    }
                }
                System.out.println("Got access token.");
                System.out.println("Access token: " + accessToken.getToken());
                System.out.println("Access token secret: " + accessToken.getTokenSecret());
            } catch (IllegalStateException ie) {
                // access token is already available, or consumer key/secret is not set.
                if (!twitter.getAuthorization().isEnabled()) {
                    System.out.println("OAuth consumer key/secret is not set. " + ie.getMessage());
                    System.exit(-1);
                }
            }
            Status status = twitter.updateStatus(twitterMessage);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get timeline: " + te.getMessage());
            System.exit(-1);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("Failed to read the system input.");
            System.exit(-1);
        }
    }
    
    public void getTwitterTimeline() {
    	try {
    		Twitter twitter = new TwitterFactory().getInstance();
    		try {
    			RequestToken requestToken = twitter.getOAuthRequestToken();
    			System.out.println("Got request token.");
    			System.out.println("Request token: " + requestToken.getToken());
    			System.out.println("Request token secret: " + requestToken.getTokenSecret());
    			AccessToken accessToken = null;
    			accessToken = new AccessToken("36063580-4ct4i8XBLnT1i7CcoLEPSyx0JofWXLWvA9XsuJraa", "HwC4qx8u0gLDcXlIUOEuw54JFYAsB0LKSVDmV4xy6KF2H");
    			twitter.setOAuthAccessToken(accessToken);
    			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    			while (null == accessToken) {
    				System.out.println("Open the following URL and grant access to your account:");
    				System.out.println(requestToken.getAuthorizationURL());
    				System.out.print("Enter the PIN(if available) and hit enter after you granted access.[PIN]:");
    				String pin = br.readLine();
    				try {
    					if (pin.length() > 0) {
    						accessToken = twitter.getOAuthAccessToken(requestToken, pin);
    					} else {
    						accessToken = twitter.getOAuthAccessToken(requestToken);
    					}
    				} catch (TwitterException te) {
    					if (401 == te.getStatusCode()) {
    						System.out.println("Unable to get the access token.");
    					} else {
    						te.printStackTrace();
    					}
    				}
    			}
    			System.out.println("Got access token.");
    			System.out.println("Access token: " + accessToken.getToken());
    			System.out.println("Access token secret: " + accessToken.getTokenSecret());
    		} catch (IllegalStateException ie) {
    			// access token is already available, or consumer key/secret is not set.
    			if (!twitter.getAuthorization().isEnabled()) {
    				System.out.println("OAuth consumer key/secret is not set. " + ie.getMessage());
    				System.exit(-1);
    			}
    		}
    		List<Status> statuses = twitter.getHomeTimeline();
    	    System.out.println("Showing home timeline.");
    	    for (Status status : statuses) {
    	        System.out.println(status.getUser().getName() + ":" +
    	                           status.getText());
    	    }
    	} catch (TwitterException te) {
    		te.printStackTrace();
    		System.out.println("Failed to get timeline: " + te.getMessage());
    		System.exit(-1);
    	} catch (IOException ioe) {
    		ioe.printStackTrace();
    		System.out.println("Failed to read the system input.");
    		System.exit(-1);
    	}
    }
    
    public static void main(String... args){
    	UpdateStatus us = new UpdateStatus();
//    	us.twittThisInBehalf("this is if I set the access token...  please,..");
    	us.getTwitterTimeline();
    }
}