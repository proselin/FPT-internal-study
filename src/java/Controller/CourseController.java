/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.google.gson.Gson;
import Entity.Course;
import Entity.Course_Category;
import Entity.Topic;
import Entity.User;
import Model.Coures_Cate_Model;
import Model.CourseModel;
import Model.TopicModel;
import Model.TraineeModel;
import Model.TrainerModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mangn
 */
public class CourseController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String act = request.getParameter("ac");
        if (act.equals("add")) {
            String id = request.getParameter("id");
            String des = request.getParameter("description");
            String time = request.getParameter("time");
            String room = request.getParameter("room");
            String schedule = request.getParameter("schedule");
            String status = request.getParameter("status");
            String chooseCC = request.getParameter("chooseCC");
            String select = request.getParameter("select");
            String chooseT = request.getParameter("chooseT");
            CourseModel am = new CourseModel();
            if (am.checkCourseExsist(id)) {
                try (PrintWriter out = response.getWriter()) {
                    request.setAttribute("error", "ID already empty");
                    ArrayList<Course> list = am.getListCourse();
                    request.setAttribute("listT", list);
                    request.getRequestDispatcher("view/Admin/course.jsp").forward(request, response);
                }
            } else {
                if (am.addCourse(id, des, time, room, schedule, status, chooseCC, select, chooseT)) {
                    response.sendRedirect("view/Admin/course.jsp");
                } else {
                    request.setAttribute("error", "Error add !");
                    response.sendRedirect("view/Admin/course.jsp");
                }
            }
        }
        if (act.equals("viewCC")) {
            Coures_Cate_Model am = new Coures_Cate_Model();
            ArrayList<Course_Category> list = am.getListCourse_Categorys();
            request.setAttribute("listCC", list);
            request.getRequestDispatcher("view/Admin/AddCourse.jsp").forward(request, response);
        }
        if (act.equals("viewCC1")) {
            Coures_Cate_Model am = new Coures_Cate_Model();
            ArrayList<Course_Category> list = am.getListCourse_Categorys();
            request.setAttribute("listCC1", list);
            request.getRequestDispatcher("view/Admin/UpdateCourse.jsp").forward(request, response);
        }
        if (act.equals("viewTopic")) {
            TopicModel am = new TopicModel();
            ArrayList<Topic> list = am.getListTopic();
            request.setAttribute("listTopic", list);
            request.getRequestDispatcher("view/Admin/AddCourse.jsp").forward(request, response);
        }
        if (act.equals("viewTopic2")) {
            TopicModel am = new TopicModel();
            ArrayList<Topic> list = am.getListTopic();
            request.setAttribute("listTopic1", list);
            request.getRequestDispatcher("view/Admin/UpdateCourse.jsp").forward(request, response);
        }
        if (act.equals("viewTrainer")) {
            String op = request.getParameter("select");
            Model.CourseModel am = new Model.CourseModel();
            ArrayList<User> list = am.getTrainer(op);
            Gson json = new Gson();
            String listTrainer = json.toJson(list);
            response.setContentType("text/html");
            response.getWriter().write(listTrainer);
        }
        if (act.equals("viewTrainer2")) {
            String op = request.getParameter("select");
            Model.CourseModel am = new Model.CourseModel();
            ArrayList<User> list = am.getTrainer(op);
            Gson json = new Gson();
            String listTrainer = json.toJson(list);
            response.setContentType("text/html");
            response.getWriter().write(listTrainer);
        }
        if (act.equals("viewTrainee")) {
            String op = request.getParameter("getid");
            Model.CourseModel am = new Model.CourseModel();
            ArrayList<User> list = am.getTraineeList(op);
            Gson json = new Gson();
            String listTrainee = json.toJson(list);
            response.setContentType("text/html");
            response.getWriter().write(listTrainee);
        }
        if (act.equals("view")) {
            CourseModel am = new CourseModel();
            ArrayList<Course> list = am.getListCourse();
            request.setAttribute("listC", list);
            request.getRequestDispatcher("view/Admin/course.jsp").forward(request, response);
        }
        if (act.equals("del")) {
            String id = request.getParameter("id");
            CourseModel am = new CourseModel();
            if (am.deleteCourse(id)) {
                response.sendRedirect("view/Admin/course.jsp");
            }
        }
        if (act.equals("viewCD")) {
            String op = request.getParameter("getid");
            CourseModel am = new CourseModel();
            Course list = am.viewDetailCourse(op);
            Gson json = new Gson();
            String CourseDetail = json.toJson(list);
            response.setContentType("text/html");
            response.getWriter().write(CourseDetail);
        }
         if (act.equals("viewAllTrainee")) {
            TraineeModel am = new TraineeModel();
            ArrayList<User> list = am.getListTrainee();
            request.setAttribute("listT", list);
            request.getRequestDispatcher("view/Admin/AddStudentToCourse.jsp").forward(request, response);
        }
        if (act.equals("addTrainee")) {
            String Cid = request.getParameter("Cid");
            String Uid = request.getParameter("Uid");
            CourseModel am = new CourseModel();
                if (am.addStudentToCourse(Cid, Uid)) {
                    response.sendRedirect("view/Admin/ListStudentofCourse.jsp?id="+Cid);
                } else {
                    request.setAttribute("error", "Error add !");
                    response.sendRedirect("view/Admin/course.jsp");
                }
        }
        if (act.equals("getid")) {
            String id = request.getParameter("id");
            CourseModel am = new CourseModel();
            Course list = am.getCourse(id);
            request.setAttribute("data", list);
            request.getRequestDispatcher("view/Admin/UpdateCourse.jsp").forward(request, response);
        }
        if (act.equals("doUpdate")) {
           String id = request.getParameter("id");
            String des = request.getParameter("description");
            String content = request.getParameter("content");
            String time = request.getParameter("time");
            String room = request.getParameter("room");
            String schedule = request.getParameter("schedule");
            String status = request.getParameter("status");
            String chooseCC = request.getParameter("chooseCC");
            String select = request.getParameter("select");
            String chooseT = request.getParameter("chooseT");
            CourseModel am = new CourseModel();
            if (am.updateCourse( id,des, time, room, content, schedule, status ,chooseCC, select,chooseT )) {
                response.sendRedirect("view/Admin/course.jsp");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
