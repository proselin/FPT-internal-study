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
public class Role {
    private String RoleID;
    private String RoleName;
    private String RoleDes;

    public Role() {
    }
    
    public Role(String RoleID, String RoleName, String RoleDes) {
        this.RoleID = RoleID;
        this.RoleName = RoleName;
        this.RoleDes = RoleDes;
    }

    public String getRoleID() {
        return RoleID;
    }

    public void setRoleID(String RoleID) {
        this.RoleID = RoleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String RoleName) {
        this.RoleName = RoleName;
    }

    public String getRoleDes() {
        return RoleDes;
    }

    public void setRoleDes(String RoleDes) {
        this.RoleDes = RoleDes;
    }
    
}
