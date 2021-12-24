/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Course;
import Entity.Course_Category;
import Entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mangn
 */
public class CourseModel {

    public ArrayList<Course> getListCourse() {
        ArrayList<Course> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tblCourse,tblUser WHERE tblCourse.UserID = tblUser.UserID");
            Course acc = null;
            while (rs.next()) {
                acc = new Course();
                acc.setCourseID(rs.getString(1));
                acc.setCourseDes(rs.getString(2));
                acc.setCourseTime(rs.getString(3));
                acc.setCourseRoom(rs.getString(4));
                acc.setCourseContent(rs.getString(5));
                acc.setCourseSchedule(rs.getString(6));
                acc.setCourseStatus(rs.getString(7));
                acc.setUserID(rs.getString(12));
                acc.setCourse_Cate_ID(rs.getString(9));
                acc.setTopicID(rs.getString(10));
                list.add(acc);
            }
            rs.close();
            stm.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public boolean checkCourseExsist(String id) {
        boolean result = false;
        String sql = "SELECT * FROM tblCourse WHERE Course_ID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            result = rs.next();
            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result;
    }

    public boolean addCourse(String CouresID, String CourseDes, String CourseTime, String CourseRoom, String CourseSchedule, String CourseStatus, String CouresCID, String TopicID, String UserID) {
        String sql = "INSERT INTO tblCourse (Course_ID, Course_Des, Course_Time, Course_Room,Course_Schedule,Course_Status,Course_Cate_ID,Topic_ID,UserID)\n"
                + "VALUES(?,?,?,?,?,?,?,?,?) ";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, CouresID);
            ps.setString(2, CourseDes);
            ps.setString(3, CourseTime);
            ps.setString(4, CourseRoom);
            ps.setString(5, CourseSchedule);
            ps.setString(6, CourseStatus);
            ps.setString(7, CouresCID);
            ps.setString(8, TopicID);
            ps.setString(9, UserID);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }

    public ArrayList<User> getTrainer(String TopiciId) {
        ArrayList<User> list = new ArrayList<>();
        User acc = null;
        String sql = "SELECT * FROM User_Topic,tblUser WHERE User_Topic.Topic_ID  = ? AND User_Topic.UserID=tblUser.UserID";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, TopiciId);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new User();
                acc.setUserID(rs.getString(1));
                acc.setFullName(rs.getString(4));
                list.add(acc);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public boolean deleteCourse(String id) {
        String sql = "DELETE FROM tblCourse WHERE Course_ID = ?";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }

    public Course viewDetailCourse(String id) {
        ArrayList<User> list = new ArrayList<>();
        Course acc = null;
        String sql = "SELECT * FROM tblUser,tblTopic,tblCourse_Category,tblCourse WHERE tblCourse.Course_Cate_ID = tblCourse_Category.Course_Cate_ID\n"
                + "AND tblCourse.Topic_ID = tblTopic.Topic_ID AND tblUser.UserID= tblCourse.UserID AND tblCourse.Course_ID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new Course();
                acc.setCourseID(rs.getString(18));
                acc.setCourse_Cate_ID(rs.getString(17));
                acc.setTopicID(rs.getString(11));
                acc.setUserID(rs.getString(2));
                acc.setCourseTime(rs.getString(20));
                acc.setCourseSchedule(rs.getString(23));
                acc.setCourseRoom(rs.getString(21));
                acc.setCourseStatus(rs.getString(24));
                acc.setCourseDes(rs.getString(19));
                acc.setCourseContent(rs.getString(22));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return acc;
    }

    public ArrayList<User> getTraineeList(String CourseID) {
        ArrayList<User> list = new ArrayList<>();
        User acc = null;
        String sql = "SELECT * FROM Course_user,tblUser WHERE Course_ID = ? AND Course_user.UserID=tblUser.UserID";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, CourseID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new User();
                acc.setUserID(rs.getString(2));
                acc.setFullName(rs.getString(4));
                acc.setEmail(rs.getString(7));
                acc.setPhone(rs.getString(6));
                acc.setAddress(rs.getString(5));
                list.add(acc);
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public boolean addStudentToCourse(String CouresID, String UserID) {
        String sql = "INSERT INTO Course_user(Course_ID,UserID) VALUES (?,?)";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, CouresID);
            ps.setString(2, UserID);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }

    public Course getCourse(String id) {
        Course acc = null;
        String sql = "SELECT * FROM tblCourse WHERE Course_ID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new Course();
                acc.setCourseID(rs.getString(1));
                acc.setCourseDes(rs.getString(2));
                acc.setCourseTime(rs.getString(3));
                acc.setCourseRoom(rs.getString(4));
                acc.setCourseContent(rs.getString(5));
                acc.setCourseSchedule(rs.getString(6));
                acc.setCourseStatus(rs.getString(7));
                acc.setUserID(rs.getString(12));
                acc.setCourse_Cate_ID(rs.getString(9));
                acc.setTopicID(rs.getString(10));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return acc;
    }

    public boolean updateCourse(String CouresID, String CourseDes, String CourseTime, String CourseRoom, String Content, String CourseSchedule, String CourseStatus, String CouresCID, String TopicID, String UserID) {
        String sql = "UPDATE tblCourse SET Course_Des = ?, Course_Time = ?, Course_Room = ?, Course_Content = ?, Course_Schedule = ?, Course_Status = ?, UserID = ?,Course_Cate_ID = ?,Topic_ID=? WHERE Course_ID = ? ";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, CourseDes);
            ps.setString(2, CourseTime);
            ps.setString(3, CourseRoom);
            ps.setString(4, Content);
            ps.setString(5, CourseSchedule);
            ps.setString(6, CourseStatus);
            ps.setString(7, UserID);
            ps.setString(8, CouresCID);
            ps.setString(9, TopicID);
            ps.setString(10, CouresID);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }
}
