package org.aggelos.baztag.app.twitter;

import org.aggelos.baztag.app.Application;
import org.aggelos.baztag.app.ApplicationConfig;
import org.aggelos.baztag.app.ZTampApplicationConfig;
import org.aggelos.baztag.model.PNabaztag;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * The behaviour class for the twitter app
 * @author aggelos
 */
public class TwitterApp implements Application {

	// that's where the good stuff happens
	@Override
	public void doYourStuff(ApplicationConfig config, PNabaztag ptag) {
		/*TwitterConfig tconf = (TwitterConfig) config;
		Nabaztag tag = ptag.getBindedNabaztag();
		//config.say("Twitter ! ");
		Twitter twitter = configureTwitter(tconf);
		try {
			String messages = readHome(twitter,tconf,ptag.getBindedNabaztag());
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		if(tconf.isReadDirectMessages()) {
			
		}
		if(tconf.isReadMentions()) {
			
		}*/
	
	}
	
	public void say(String text) {
		/*NabaztagInstructionSequence seq = new NabaztagInstructionSequence();
		VoiceInstruction vi = new VoiceInstruction(Lang.FRJulie);
		TextInstruction ti = new TextInstruction(text);
		seq.add(ti);
		seq.add(vi);
		nabaztag.execute(seq);*/
	}

	private String readHome(Twitter twitter, TwitterConfig config) throws TwitterException {
		/*if(config.getLastHomeId()!=-1) {
			Paging homePaging = new Paging(0,5,config.getLastHomeId());
			ResponseList<Status> status = twitter.getHomeTimeline(homePaging);
			for(Status stat:status) {
				say(stat.getUser().getName()+" : "+stat.getText());
			}
		}else {
			Paging homePaging = new Paging(1,5);
			ResponseList<Status> status = twitter.getHomeTimeline(homePaging);
			StringBuffer buffer = new StringBuffer("Twitter : ");
			for(Status stat:status) {
				buffer.append(stat.getUser().getName()+" : "+stat.getText()+".");
			}
			say(buffer.toString(), tag);
		}*/
		return null;
	}

	/**
	 * @param tconf
	 */
	private Twitter configureTwitter(TwitterConfig tconf) {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		  .setOAuthConsumerKey(consumerKey)
		  .setOAuthConsumerSecret(consumerSecret)
		  .setOAuthAccessToken(tconf.getToken())
		  .setOAuthAccessTokenSecret(tconf.getTokenSecret());
		TwitterFactory tf = new TwitterFactory(cb.build());
		return tf.getInstance();
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

	@Override
	public void doYourStuff(ZTampApplicationConfig config, PNabaztag ptag) {
		// TODO Auto-generated method stub
		
	}


}
