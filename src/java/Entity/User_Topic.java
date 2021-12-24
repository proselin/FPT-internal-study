/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author mangn
 */
public class User_Topic {
    private String UserID;
    private String TopicID;

    public User_Topic() {
    }
    
    public User_Topic(String UserID, String TopicID) {
        this.UserID = UserID;
        this.TopicID = TopicID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getTopicID() {
        return TopicID;
    }

    public void setTopicID(String TopicID) {
        this.TopicID = TopicID;
    }
    
}
