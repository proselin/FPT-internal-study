/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class Coures_Cate_Model {

    public ArrayList<Course_Category> getListCourse_Categorys() {
        ArrayList<Course_Category> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tblCourse_Category");
            Course_Category acc = null;
            while (rs.next()) {
                acc = new Course_Category();
                acc.setCousre_cate_ID(rs.getString(1));
                acc.setCourse_Cate_Des(rs.getString(2));
                acc.setCourse_Cate_Img(rs.getString(3));
                acc.setCourse_cate_Name(rs.getString(4));
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

    public boolean checkCCExsist(String id) {
        boolean result = false;
        String sql = "SELECT * FROM tblCourse_Category WHERE Course_Cate_ID = ?";
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

    public boolean addCourse_Cate(String id, String des, String img, String name) {
        String sql = "INSERT INTO tblCourse_Category VALUES(?, ?,?,?)";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, des);
            ps.setString(3, img);
            ps.setString(4, name);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }

    public boolean deleteCC(String id) {
        String sql = "DELETE FROM tblCourse_Category WHERE Course_Cate_ID = ?";
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

    public Course_Category getCC(String id) {
        Course_Category acc = null;
        String sql = "SELECT * FROM tblCourse_Category WHERE Course_Cate_ID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new Course_Category();
                acc.setCousre_cate_ID(rs.getString(1));
                acc.setCourse_Cate_Des(rs.getString(2));
                acc.setCourse_Cate_Img(rs.getString(3));
                acc.setCourse_cate_Name(rs.getString(4));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return acc;
    }
     public boolean updateCC(String id, String des, String img, String name) {
        String sql = "UPDATE tblCourse_Category SET Course_Cate_Name = ?, Course_Cate_Des = ?, Course_Cate_Img = ? WHERE Course_Cate_ID = ? ";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, des);
            ps.setString(3, img);
            ps.setString(4, id);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }
}
