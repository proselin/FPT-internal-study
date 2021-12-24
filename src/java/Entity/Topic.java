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
public class Topic {
    private String TopicID;
    private String TopicName;
    private String TopicDes;
    private String TopicImg;

    public Topic() {
    }
    
    public Topic(String TopicID, String TopicName, String TopicDes, String TopicImg) {
        this.TopicID = TopicID;
        this.TopicName = TopicName;
        this.TopicDes = TopicDes;
        this.TopicImg = TopicImg;
    }

    public String getTopicID() {
        return TopicID;
    }

    public void setTopicID(String TopicID) {
        this.TopicID = TopicID;
    }

    public String getTopicName() {
        return TopicName;
    }

    public void setTopicName(String TopicName) {
        this.TopicName = TopicName;
    }

    public String getTopicDes() {
        return TopicDes;
    }

    public void setTopicDes(String TopicDes) {
        this.TopicDes = TopicDes;
    }

    public String getTopicImg() {
        return TopicImg;
    }

    public void setTopicImg(String TopicImg) {
        this.TopicImg = TopicImg;
    }
    
}
