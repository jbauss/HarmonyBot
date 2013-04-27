package bot

import twitter4j.UserStreamListener
import twitter4j.User
import twitter4j.DirectMessage
import twitter4j.Status
import twitter4j.UserList
import twitter4j.StallWarning
import twitter4j.StatusDeletionNotice

class HarmonyUserListener extends UserStreamListener {
  
  def onException(ex : Exception) {
    
  }
  
  def onDeletionNotice(statusDeletionNotice : StatusDeletionNotice) {
    
  }
  
  def onScrubGeo(userId : Long, upToStatusId : Long) {
    
  }
  
  def onStallWarning(warning : StallWarning) {
    
  }
  
  def onStatus(status : Status) {
    println("Status posted by HarmonyBot:")
    println("\t@" + status.getUser().getName() + ":")
    println("\t" + status.getText())
  }
  
  def onTrackLimitationNotice(numberOfLimitedStatuses : Int) {
    
  }
  
  def onBlock(source : User, blockedUser : User) {
    
  }
  
  def onDeletionNotice(directMessageId : Long, userId : Long) {
    
  }
  
  def onDirectMessage(directMessage : DirectMessage) {
    
  }
  
  def onFavorite(source : User, target : User, favoritedStatus : Status) {
    
  }
  
  def onFollow(source : User, followedUser : User) {
    
  }
  
  def onFriendList(friendIds : Array[Long]) {
    
  }
  
  def onUnblock(source : User, unblockedUser : User) {
    
  }
  
  def onUnfavorite(source : User, target : User, unfavoritedStatus : Status) {
    
  }
  
  def onUserListCreation(listOwner : User, list : UserList) {
    
  }
  
  def onUserListDeletion(listOwner : User, list : UserList) {
    
  }
  
  def onUserListMemberAddition(addedMember : User, listOwner : User, list : UserList) {
    
  }
  
  def onUserListMemberDeletion(deletedMember : User, listOwner : User, list : UserList) {
    
  }
  
  def onUserListSubscription(subscriber : User, listOwner : User, list : UserList) {
    
  }
  
  def onUserListUnsubscription(subscriber : User, listOwner : User, list : UserList) {
    
  }
  
  def onUserListUpdate(listOwner : User, list : UserList) {
    
  }
  
  def onUserProfileUpdate(updatedUser : User) {
    
  }
  
}