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
public class Course_Category {
    private String Cousre_cate_ID;
    private String Course_cate_Name;
    private String Course_Cate_Img;
    private String Course_Cate_Des;
    public Course_Category() {
    }

    public Course_Category(String Cousre_cate_ID, String Course_cate_Name, String Course_Cate_Img, String Course_Cate_Des) {
        this.Cousre_cate_ID = Cousre_cate_ID;
        this.Course_cate_Name = Course_cate_Name;
        this.Course_Cate_Img = Course_Cate_Img;
        this.Course_Cate_Des = Course_Cate_Des;
    }

    public String getCourse_Cate_Des() {
        return Course_Cate_Des;
    }

    public void setCourse_Cate_Des(String Course_Cate_Des) {
        this.Course_Cate_Des = Course_Cate_Des;
    }
    public String getCousre_cate_ID() {
        return Cousre_cate_ID;
    }

    public void setCousre_cate_ID(String Cousre_cate_ID) {
        this.Cousre_cate_ID = Cousre_cate_ID;
    }

    public String getCourse_cate_Name() {
        return Course_cate_Name;
    }

    public void setCourse_cate_Name(String Course_cate_Name) {
        this.Course_cate_Name = Course_cate_Name;
    }

    public String getCourse_Cate_Img() {
        return Course_Cate_Img;
    }

    public void setCourse_Cate_Img(String Course_Cate_Img) {
        this.Course_Cate_Img = Course_Cate_Img;
    }
    
}
