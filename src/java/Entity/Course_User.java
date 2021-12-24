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
public class Course_User {
    private String CourseID;
    private String UserID;

    public Course_User() {
    }
    
    public Course_User(String CourseID, String UserID) {
        this.CourseID = CourseID;
        this.UserID = UserID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String CourseID) {
        this.CourseID = CourseID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    
}
