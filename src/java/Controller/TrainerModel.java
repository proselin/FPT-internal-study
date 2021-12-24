/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Topic;
import Entity.User;
import Model.TopicModel;
import Model.TraineeModel;
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
public class TrainerModel extends HttpServlet {

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
        if (act.equals("viewTopic")) {
            TopicModel am = new TopicModel();
            ArrayList<Topic> list = am.getListTopic();
            request.setAttribute("listTopic", list);
            request.getRequestDispatcher("view/Admin/Addtrainer.jsp").forward(request, response);
        }
         if (act.equals("view")) {
            Model.TrainerModel am = new Model.TrainerModel();
            ArrayList<User> list = am.getListTrainer();
            request.setAttribute("listT", list);
            request.getRequestDispatcher("view/Admin/trainer.jsp").forward(request, response);
        }
         if (act.equals("add")) {
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            String add = request.getParameter("add");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");
            String date = request.getParameter("birthdaytime");
            String topics [] = request.getParameterValues("topics");
            Model.TrainerModel am = new Model.TrainerModel();
            if (am.checkTraineeExsist(id)) {
                try (PrintWriter out = response.getWriter()) {
                    request.setAttribute("error", "ID already empty");
                    ArrayList<User> list = am.getListTrainer();
                    request.setAttribute("listT", list);
                    request.getRequestDispatcher("view/Admin/trainer.jsp").forward(request, response);
                }
            } else {
                if (am.addTrainer(id, fname, add, phone, email, date, uname, pass, "3")) {
                    for(String s : topics ){
                        am.addTopicforTrainer(id, s);
                    }
                    response.sendRedirect("view/Admin/trainer.jsp");
                    
                } else {
                    request.setAttribute("error", "Error add !");
                    response.sendRedirect("view/Admin/trainer.jsp");
                }
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
