package bot

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.UserStreamListener

object BotStarter {
  
  def main(args: Array[String]) {
    
    val harmonyListener = new HarmonyUserListener()
    
    val twitterStream = TwitterStreamFactory.getSingleton();
    twitterStream.addListener(harmonyListener)
    twitterStream.user();
  }

}