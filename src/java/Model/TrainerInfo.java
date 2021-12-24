/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quoch
 */
public class TrainerInfo {

     public ArrayList<Course> getTrainerCourse(String id) {
        String sql = "SELECT * FROM tblUser,tblTopic,tblCourse_Category,tblCourse WHERE tblCourse.Course_Cate_ID = tblCourse_Category.Course_Cate_ID AND tblCourse.Topic_ID "
                + "= tblTopic.Topic_ID AND tblUser.UserID=tblCourse.UserID AND tblCourse.UserID=?";
        ArrayList<Course> list = new ArrayList<>();
        Course acc = null;
        try {
            GetConnection cn = new GetConnection();
            Connection conn = cn.getConnection();
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
                list.add(acc);
            }
            st.close();
            conn.close();
            rs.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return list;

    }

  public ArrayList<Course> getTrainer(String id) {
        String sql = "Select * from tblCourse,tblUser where  tblCourse.UserID = tblUser.UserID AND tblCourse.UserID = ? ";
        ArrayList<Course> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            Course acc = null;
            // lay du lieu 
            while (rs.next()) {
                acc = new Course();
                acc.setCourseID(rs.getString(1));
                acc.setCourseDes(rs.getString(2));
                acc.setCourseTime(rs.getString(3));
                acc.setCourseRoom(rs.getString(4));
                acc.setCourseContent(rs.getString(5));
                acc.setCourseSchedule(rs.getString(6));
                acc.setCourseStatus(rs.getString(7));
                acc.setUserID(rs.getString(8));
                acc.setCourse_Cate_ID(rs.getString(9));
                acc.setTopicID(rs.getString(10));
                list.add(acc);
            }
            rs.close();
            conn.close();
        } catch (Exception e) {
        }
        return list;
}
}
