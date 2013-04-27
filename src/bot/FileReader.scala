package bot

import scala.io.Source
import scala.util.Random

class FileReader {
  
  def getRandomLine(fileName : String) : String = {
    
	  val bufferedSource = Source.fromFile(fileName)
	  val (it1, it2) = bufferedSource.getLines.duplicate
	  val numOfLines = it1.size
	  val random = new Random()
	  val lineIndex = random.nextInt(numOfLines) + 1
	  it2.drop(lineIndex-1)
	  
	  return it2.next()
	  
  }

}