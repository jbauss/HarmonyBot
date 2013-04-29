package bot

import scala.io.Source
import scala.collection.mutable.HashSet
import scala.collection.mutable.MutableList
import java.io.PrintWriter
import java.io.File

object BotStarter {
  
  val ADJECTIVES_FILE = "res/adjectives.txt"
  val SENTENCE_FILE = "res/sentenceTemplates.txt"
  val PERSON_FILE = "res/personDescriptors.txt"
    
  val ADJECTIVE_PLACEHOLDER = "<adjective>"
  val PERSON_PLACEHOLDER = "<person>"
    
  val MAX_TWEET_LENGTH = 140

  def main(args: Array[String]): Unit = {
    val harmony = new HarmonyBot()
    harmony.run()
    
    //    val harmonyListener = new HarmonyUserListener()
	//    
	//    val twitterStream = TwitterStreamFactory.getSingleton();
	//    twitterStream.addListener(harmonyListener)
	//    twitterStream.user();
    
  }

}