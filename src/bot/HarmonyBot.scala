package bot

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.UserStreamListener

class HarmonyBot {
  
  val THREE_MINUTES_IN_MILLIS = 180000
  
  val complimentBuilder = new ComplimentBuilder()
  val twitter = TwitterFactory.getSingleton()
  val twitterStream = TwitterStreamFactory.getSingleton()
  val mainStreamListener = new TwitterMainStreamListener()
  
  def run() = {
    twitterStream.addListener(mainStreamListener)
    twitterStream.sample()
    
    while(true) {
      var compliment : String = ""
        
      while(compliment.size > BotStarter.MAX_TWEET_LENGTH || compliment == "") {
        val newestTweet = mainStreamListener.lastTweet
        if(newestTweet != null) {
	    	compliment = "@" + newestTweet.getUser().getScreenName() + " " + complimentBuilder.generateCompliment()
        }
      }
      
      twitter.updateStatus(compliment)
      println("HarmonyBot tweeted: " + compliment)      
      Thread.sleep(THREE_MINUTES_IN_MILLIS)
    }
  }

}