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
    println(complimentBuilder.generateCompliment)
  }

}