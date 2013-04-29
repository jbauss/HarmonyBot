package bot

import twitter4j.StatusListener
import twitter4j.StatusDeletionNotice
import twitter4j.StallWarning
import twitter4j.Status

class TwitterMainStreamListener extends StatusListener {
  
  var lastTweet : Status = null
  
  def onDeletionNotice(deletionNotice: StatusDeletionNotice) {
    
  }
  
  def onScrubGeo(long: Long, lat: Long) {
    
  }
  
  def onStallWarning(stallWarning: StallWarning) {
    
  }
  
  def onStatus(tweet: Status) {
    lastTweet = tweet
  }
  
  def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {
    
  }
  
  def onException(exc: Exception) {
    
  }

}