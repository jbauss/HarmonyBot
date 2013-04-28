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
  val PERSON_PLACEHOLDER = "<person>"
  
  def main(args: Array[String]) {
    
//    val harmonyListener = new HarmonyUserListener()
//    
//    val twitterStream = TwitterStreamFactory.getSingleton();
//    twitterStream.addListener(harmonyListener)
//    twitterStream.user();
    
	  println(generateCompliment())
  }
  
  def generateCompliment() : String = {
	  val fileReader = new FileReader()
	  
	  val sentenceTemplate = fileReader.getRandomLine(SENTENCE_FILE)
	  val adjectivePlaceholders = countPlaceholders(sentenceTemplate, ADJECTIVE_PLACEHOLDER)
	  val nounPlaceholders = countPlaceholders(sentenceTemplate, PERSON_PLACEHOLDER)
	  val adjectiveList = fileReader.gatherUniqueLines(ADJECTIVES_FILE, adjectivePlaceholders)
	  val nounList = fileReader.gatherUniqueLines(PERSON_FILE, nounPlaceholders)
	  val compliment = fillPlaceholders(sentenceTemplate, adjectiveList, nounList)
	  
	  return compliment
  }
  
  def countPlaceholders(sentenceTemplate : String, placeholder : String) : Int = {
    return sentenceTemplate.split(" ").count((s : String) => s.contains(placeholder))
  }
  
  def fillPlaceholders(sentenceTemplate : String, adjectives : List[String], nouns : List[String]) : String = {
    val complimentWithAdjectives = adjectives.foldLeft(sentenceTemplate)((sentence, adjective) => sentence.replaceFirst(ADJECTIVE_PLACEHOLDER, adjective))
    val fullCompliment = nouns.foldLeft(complimentWithAdjectives)((sentence, person) => sentence.replaceFirst(PERSON_PLACEHOLDER, person))
    
    return fullCompliment
  }

}