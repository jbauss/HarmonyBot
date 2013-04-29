package bot

object BotStarter {

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