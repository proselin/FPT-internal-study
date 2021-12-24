/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Course_Category;
import Entity.Topic;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author mangn
 */
public class TopicModel {
    public ArrayList<Topic> getListTopic() {
        ArrayList<Topic> list = new ArrayList<>();
        GetConnection cn = new GetConnection();
        Connection conn = cn.getConnection();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM tblTopic");
            Topic acc = null;
            while (rs.next()) {
                acc = new Topic();
                acc.setTopicID(rs.getString(1));
                acc.setTopicName(rs.getString(2));
                acc.setTopicDes(rs.getString(3));
                acc.setTopicImg(rs.getString(4));
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
}
