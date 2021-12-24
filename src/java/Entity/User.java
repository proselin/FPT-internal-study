/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author mangn
 */
public class User {
    private String UserID;
    private String FullName;
    private String Address;
    private String Phone;
    private String Email;
    private Date Date_Of_Birth;
    private String Username;
    private String Password;
    private String RoleID;

    public User() {
    }

    public User(String UserID, String FullName, String Address, String Phone, String Email, Date Date_Of_Birth, String Username, String Password, String RoleID) {
        this.UserID = UserID;
        this.FullName = FullName;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Username = Username;
        this.Password = Password;
        this.RoleID = RoleID;
    }

    public User(String userid, String name, String roleid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    
    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Date getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(Date Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }



    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }
    
}
