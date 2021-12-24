/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mangn
 */
public class TraineeModel {
    public static Date convertUtilDateToSqlDate(java.util.Date date){
        java.sql.Date sDate = new java.sql.Date(date.getTime());
        return sDate;
    }
    public ArrayList<User> getListTrainee() {
        ArrayList<User> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tblUser WHERE RoleID = 1");
            User acc = null;
            while (rs.next()) {
                acc = new User();
                acc.setUserID(rs.getString(1));
                acc.setFullName(rs.getString(2));
                acc.setAddress(rs.getString(3));
                acc.setPhone(rs.getString(4));
                acc.setEmail(rs.getString(5));
                acc.setDate_Of_Birth(rs.getDate(6));
                acc.setUsername(rs.getString(7));
                acc.setPassword(rs.getString(8));
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
    public boolean checkTraineeExsist(String id) {
        boolean result = false;
        String sql = "SELECT * FROM tblUser WHERE UserID = ?";
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
    public boolean addTrainee(String UserID, String FullName ,String Address,String Phone,String Email,String date,String u,String p,String Role) {
        String sql = "INSERT INTO tblUser VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, UserID);
            ps.setString(2, FullName);
            ps.setString(3, Address);
            ps.setString(4, Phone);
            ps.setString(5, Email);
            ps.setString(6, date);
            ps.setString(7, u);
            ps.setString(8, p);
            ps.setString(9, Role);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }
    public boolean deleteTrainee(String id) {
        String sql = "DELETE FROM tblUser WHERE UserID = ?";
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

    public boolean updateTrainee(String UserID, String FullName ,String Address,String Phone,String Email,String Date,String u,String p) {
        String sql = "UPDATE tblUser SET FullName = ?, _Address = ?, Phone = ?, Email = ?, Date_of_birth = ?, _UserName = ?,_Password =? WHERE UserID = ? ";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, FullName);
            ps.setString(2, Address);
            ps.setString(3, Phone);
            ps.setString(4, Email);
             ps.setString(5, Date);
            ps.setString(6, u);
            ps.setString(7, p);
            ps.setString(8, UserID);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }
        public User getUser(String id) {
        User acc = null;
        String sql = "SELECT * FROM tblUser WHERE UserID = ?";
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                acc = new User();
                acc.setUserID(id);
                acc.setFullName(rs.getString(2));
                acc.setAddress(rs.getString(3));
                acc.setPhone(rs.getString(4));
                acc.setEmail(rs.getString(5));
                acc.setDate_Of_Birth(rs.getDate(6));
                acc.setUsername(rs.getString(7));
                acc.setPassword(rs.getString(8));
            }
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return acc;
    }
}
