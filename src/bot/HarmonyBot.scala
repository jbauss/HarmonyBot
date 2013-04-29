package bot

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.UserStreamListener

class HarmonyBot {
  
  val complimentBuilder = new ComplimentBuilder()
  
  def run() = {
    var compliment = complimentBuilder.generateCompliment()
    
    if(compliment.size < BotStarter.MAX_TWEET_LENGTH - 3)
    	compliment = compliment + " :)"
    	  
    println(compliment)
  }

}