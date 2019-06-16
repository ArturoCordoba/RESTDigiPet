package com.digipet.prototype.api.twitter;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterManager {
    private static final String consumerApiKey = "MxoY0W5q85UooHorh8wPqBqBY";
    private static final String consumerApiKeySecret = "yyX7qiPvPEL10O2opuJEWGuXsh7KG7jIBewKMWRL8HxChcpqCq";

    private static final String accessTokenStr = "1135786488065646592-ccBr2ZtJPfg4GeuYWp8nfTWWedVIPn";
    private static final String accessTokenSecret = "luPy5vtzREQPvVHf73F3UfHDQZCobIDJPJf7BGwv5LErz";

    public static void tweet(String message){
        try{
            Twitter twitter = new TwitterFactory().getInstance();

            twitter.setOAuthConsumer(consumerApiKey, consumerApiKeySecret);
            AccessToken accessToken = new AccessToken(accessTokenStr, accessTokenSecret);

            twitter.setOAuthAccessToken(accessToken);

            twitter.updateStatus(message);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }
}
