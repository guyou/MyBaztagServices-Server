package org.aggelos.baztag.app.twitter;

import org.aggelos.baztag.app.Application;
import org.aggelos.baztag.app.ApplicationConfig;
import org.aggelos.baztag.model.PNabaztag;

import twitter4j.DirectMessage;
import twitter4j.ResponseList;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;

/**
 * The behaviour class for the twitter app
 * @author aggelos
 */
public class TwitterApp implements Application {

	// that's where the good stuff happens
	@Override
	public void doYourStuff(ApplicationConfig config, PNabaztag ptag) {
		Twitter twitter = new TwitterFactory().getInstance();
		ResponseList<DirectMessage> msgs = twitter.getDirectMessages();
		for(DirectMessage msg:msgs) {
			
		}
	
	}
	
	
	// both application wide, are provided by twitter
	private String consumerSecret;
	private String consumerKey;
	

	@Override
	public String getConfigContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifier() {
		return "twitter";
	}

	@Override
	public String getListContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPreConfigContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ApplicationConfig newConfig() {
		return new TwitterConfig("twitter");
	}


}
