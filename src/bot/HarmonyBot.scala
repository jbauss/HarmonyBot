package bot

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.UserStreamListener

object HarmonyBot {
  
  def run() = {
    
  }
  
  def main(args: Array[String]) {
    
    val complimentBuilder = new ComplimentBuilder()
    
    println(complimentBuilder.generateCompliment)
    
//    val harmonyListener = new HarmonyUserListener()
//    
//    val twitterStream = TwitterStreamFactory.getSingleton();
//    twitterStream.addListener(harmonyListener)
//    twitterStream.user();
    	  
  }

}