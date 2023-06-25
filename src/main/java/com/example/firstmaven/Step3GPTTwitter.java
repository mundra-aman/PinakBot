package com.example.firstmaven;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
public class Step3GPTTwitter {
    public static void main(String[] args) {
        // Twitter API credentials
        String consumerKey = "NBJeGPuo8qVJ2n2GVdxoZHKeo";
        String consumerSecret = "lBVROpUa4m90fVJKak93XdbpEqVa7Fj0GS3X1cOwLcQuSPen20";
        String accessToken = "1318976049133293571-sEcUOswpX2ouQQ1CjgqN6G7HZzo9n5";
        String accessTokenSecret = "suJCGgWIo4Um5Te535EUoYSZmk5RpsukBzelbXkLQhQzg";
//lBVROpUa4m90fVJKak93XdbpEqVa7Fj0GS3X1cOwLcQuSPen20
        // Instantiate a Twitter instance
        Twitter twitter = new TwitterFactory().getInstance();

        // Set the API credentials
        twitter.setOAuthConsumer(consumerKey, consumerSecret);
        twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));

        // The message to be posted as a tweet
        String tweetMessage = "So Conor is not fighting until 2024.";

        try {
            // Post the tweet
            Status status = twitter.updateStatus(tweetMessage);
            System.out.println("Tweet posted successfully. Tweet ID: " + status.getId());
        } catch (TwitterException e) {
            System.err.println("Error posting tweet: " + e.getMessage());
        }
    }
}
