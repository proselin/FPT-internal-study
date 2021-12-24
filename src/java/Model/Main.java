/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author mangn
 */
public class Main {
    public static void main(String[] args) {
        GetConnection gc = new GetConnection();
        TrainerInfo t = new TrainerInfo();
        System.out.println(t.getTrainerCourse("TR2").size());
       
    }
}
