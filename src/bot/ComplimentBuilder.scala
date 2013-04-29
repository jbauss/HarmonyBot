package bot

class ComplimentBuilder {
  
  val ADJECTIVES_FILE = "res/adjectives.txt"
  val SENTENCE_FILE = "res/sentenceTemplates.txt"
  val PERSON_FILE = "res/personDescriptors.txt"
    
  val ADJECTIVE_PLACEHOLDER = "<adjective>"
  val PERSON_PLACEHOLDER = "<person>"
    
  val MAX_TWEET_LENGTH = 140
    
  val fileReader = new FileReader()
  
  def generateCompliment() : String = {
    def generateCompliment(compliment : String) : String = {
      if(compliment.length() <= MAX_TWEET_LENGTH && compliment != "")
        return compliment
	  else {
	    val sentenceTemplate = fileReader.getRandomLine(SENTENCE_FILE)
		val adjectivePlaceholders = countPlaceholders(sentenceTemplate, ADJECTIVE_PLACEHOLDER)
		val nounPlaceholders = countPlaceholders(sentenceTemplate, PERSON_PLACEHOLDER)
		val adjectiveList = fileReader.gatherUniqueLines(ADJECTIVES_FILE, adjectivePlaceholders)
		val nounList = fileReader.gatherUniqueLines(PERSON_FILE, nounPlaceholders)
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
    val complimentWithAdjectives = adjectives.foldLeft(sentenceTemplate)((sentence, adjective) => sentence.replaceFirst(ADJECTIVE_PLACEHOLDER, adjective))
    val fullCompliment = nouns.foldLeft(complimentWithAdjectives)((sentence, person) => sentence.replaceFirst(PERSON_PLACEHOLDER, person))
    
    return fullCompliment
  }

}