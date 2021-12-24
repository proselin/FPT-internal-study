/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class TrainerModel {
     public ArrayList<User> getListTrainer() {
        ArrayList<User> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tblUser WHERE RoleID = 3");
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
    public boolean addTrainer(String UserID, String FullName ,String Address,String Phone,String Email,String date,String u,String p,String Role) {
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
    public boolean addTopicforTrainer(String TrainerId, String TopicID) {
        String sql = "INSERT INTO User_Topic VALUES(?,?)";
        int result = 0;
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, TrainerId);
            ps.setString(2, TopicID);
            result = ps.executeUpdate();
            ps.close();
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return result > 0;
    }
}
