package com.example.firstmaven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.Date;


public class FirstmavenApplication {

	public static void main(String[] args) throws TwitterException {

//		ConfigurationBuilder cb = new ConfigurationBuilder();
//		cb.setDebugEnabled(true)
//				.setOAuthConsumerKey("5GXwVatGn8D1kYyM2oI0ug4JO")
//				.setOAuthConsumerSecret("ErpSyz28HLFkSFBNdgV2fvQXN7ALERdmFoWIPzTydCjw1og6Eu")
//				.setOAuthAccessToken("1318976049133293571-Py2zCNfx6Fmvv6HZknJDhiqfhyOClG")
//				.setOAuthAccessTokenSecret("SXs8MQVs0gtxLK5t5Pps9XsvLkfMippq6QYeEVU9rDvt8");
//		TwitterFactory tf = new TwitterFactory(cb.build());
//		Twitter twitter = tf.getInstance();
//		twitter.updateStatus("So Conor is not fighting until 2024.");
//		//return status.getText();


		Date currentTime = new Date();

		// Print the current time
		System.out.println("Current Time: " + currentTime);

	}

}