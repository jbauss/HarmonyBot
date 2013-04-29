package bot

class ComplimentBuilder {
    
  val fileReader = new FileReader()
  
  def generateCompliment() : String = {
    def generateCompliment(compliment : String) : String = {
      if(compliment.length() <= BotStarter.MAX_TWEET_LENGTH && compliment != "")
        return compliment
	  else {
	    val sentenceTemplate = fileReader.getRandomLine(BotStarter.SENTENCE_FILE)
		val adjectivePlaceholders = countPlaceholders(sentenceTemplate, BotStarter.ADJECTIVE_PLACEHOLDER)
		val nounPlaceholders = countPlaceholders(sentenceTemplate, BotStarter.PERSON_PLACEHOLDER)
		val adjectiveList = fileReader.gatherUniqueLines(BotStarter.ADJECTIVES_FILE, adjectivePlaceholders)
		val nounList = fileReader.gatherUniqueLines(BotStarter.PERSON_FILE, nounPlaceholders)
	    val newCompliment =fillPlaceholders(sentenceTemplate, adjectiveList, nounList)
	    
	    return newCompliment
	  }
    }
    
    return generateCompliment("")
  }
  
  def countPlaceholders(sentenceTemplate : String, placeholder : String) : Int = {
    return sentenceTemplate.split(" ").count((s : String) => s.contains(placeholder))
  }
  
  def fillPlaceholders(sentenceTemplate : String, adjectives : List[String], nouns : List[String]) : String = {
    val complimentWithAdjectives = adjectives.foldLeft(sentenceTemplate)((sentence, adjective) => sentence.replaceFirst(BotStarter.ADJECTIVE_PLACEHOLDER, adjective))
    val fullCompliment = nouns.foldLeft(complimentWithAdjectives)((sentence, person) => sentence.replaceFirst(BotStarter.PERSON_PLACEHOLDER, person))
    
    return fullCompliment
  }

}