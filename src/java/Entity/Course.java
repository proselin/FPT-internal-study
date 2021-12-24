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
public class Course {
    private String CourseID;
    private String CourseName;
    private String CourseDes;
    private String CourseTime;
    private String CourseRoom;
    private String CourseContent;
    private String CourseSchedule;
    private String CourseStatus;
    private String UserID;
    private String Course_Cate_ID;
    private String TopicID;

    public Course() {
    }
    
    public Course(String CourseID, String CourseName, String CourseDes, String CourseTime, String CourseRoom, String CourseContent, String CourseSchedule, String CourseStatus, String UserID, String Course_Cate_ID, String TopicID) {
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.CourseDes = CourseDes;
        this.CourseTime = CourseTime;
        this.CourseRoom = CourseRoom;
        this.CourseContent = CourseContent;
        this.CourseSchedule = CourseSchedule;
        this.CourseStatus = CourseStatus;
        this.UserID = UserID;
        this.Course_Cate_ID = Course_Cate_ID;
        this.TopicID = TopicID;
    }

    public Course(String sid, String cateName, String time, String room, String topic, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Course(String cid, String string, String date, String room, String string0, String schedule, String status, String topic, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getCourseDes() {
        return CourseDes;
    }

    public void setCourseDes(String CourseDes) {
        this.CourseDes = CourseDes;
    }

    public String getCourseTime() {
        return CourseTime;
    }

    public void setCourseTime(String CourseTime) {
        this.CourseTime = CourseTime;
    }

    public String getCourseRoom() {
        return CourseRoom;
    }

    public void setCourseRoom(String CourseRoom) {
        this.CourseRoom = CourseRoom;
    }

    public String getCourseContent() {
        return CourseContent;
    }

    public void setCourseContent(String CourseContent) {
        this.CourseContent = CourseContent;
    }

    public String getCourseSchedule() {
        return CourseSchedule;
    }

    public void setCourseSchedule(String CourseSchedule) {
        this.CourseSchedule = CourseSchedule;
    }

    public String getCourseStatus() {
        return CourseStatus;
    }

    public void setCourseStatus(String CourseStatus) {
        this.CourseStatus = CourseStatus;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getCourse_Cate_ID() {
        return Course_Cate_ID;
    }

    public void setCourse_Cate_ID(String Course_Cate_ID) {
        this.Course_Cate_ID = Course_Cate_ID;
    }

    public String getTopicID() {
        return TopicID;
    }

    public void setTopicID(String TopicID) {
        this.TopicID = TopicID;
    }
    
}
