package bot

import twitter4j.Twitter
import twitter4j.TwitterFactory
import twitter4j.Status
import twitter4j.conf.ConfigurationBuilder
import twitter4j.TwitterStreamFactory
import twitter4j.UserStreamListener

object HarmonyBot {
  
  val ADJECTIVES_FILE = "res/adjectives.txt"
  val SENTENCE_FILE = "res/sentenceTemplates.txt"
  val PERSON_FILE = "res/personDescriptors.txt"
    
  val ADJECTIVE_PLACEHOLDER = "<adjective>"
  val NOUN_PLACEHOLDER = "<noun>"
  
  def main(args: Array[String]) {
    
//    val harmonyListener = new HarmonyUserListener()
//    
//    val twitterStream = TwitterStreamFactory.getSingleton();
//    twitterStream.addListener(harmonyListener)
//    twitterStream.user();
	  val fileReader = new FileReader()
	  
	  val sentenceTemplate = fileReader.getRandomLine(SENTENCE_FILE)
	  val adjectivePlaceholders = countPlaceholders(sentenceTemplate, ADJECTIVE_PLACEHOLDER)
	  val nounPlaceholders = countPlaceholders(sentenceTemplate, NOUN_PLACEHOLDER)
	  val adjectiveList = fileReader.gatherUniqueLines(ADJECTIVES_FILE, adjectivePlaceholders)
	  val nounList = fileReader.gatherUniqueLines(PERSON_FILE, nounPlaceholders)
	  
	  val compliment = buildCompliment(sentenceTemplate, adjectiveList, nounList)
	  println(compliment)
  }
  
  def countPlaceholders(sentenceTemplate : String, placeholder : String) : Int = {
    return sentenceTemplate.split(" ").count((s : String) => s.contains(placeholder))
  }
  
  def buildCompliment(sentenceTemplate : String, adjectives : List[String], nouns : List[String]) : String = {
    val complimentWithAdjectives = adjectives.foldLeft(sentenceTemplate)((b,a) => b.replaceFirst(ADJECTIVE_PLACEHOLDER, a))
    val fullCompliment = nouns.foldLeft(complimentWithAdjectives)((b,a) => b.replaceFirst(NOUN_PLACEHOLDER, a))
    
    return fullCompliment
  }

}