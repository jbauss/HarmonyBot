package bot

import scala.io.Source
import scala.util.Random

class FileReader {
  
  def getRandomLine(filePath : String) : String = {
	  val bufferedSource = Source.fromFile(filePath)
	  val (it1, it2) = bufferedSource.getLines.duplicate
	  val numOfLines = it1.size
	  val random = new Random()
	  val lineIndex = random.nextInt(numOfLines) + 1
	  it2.drop(lineIndex-1)
	  
	  return it2.next() 
  }
  
  def gatherUniqueLines(filePath : String, numberOfLines : Int) : List[String] = {
    var lines = List[String]()
    
    while(lines.size < numberOfLines) {
      val randomLine = getRandomLine(filePath)
      if(!lines.contains(randomLine))
    	  lines = randomLine :: lines
    }
    
    return lines
  }

}