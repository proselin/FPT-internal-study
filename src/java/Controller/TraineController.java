/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Model.GetConnection;
import Model.TraineeModel;
import Model.UserModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mangn
 */
public class TraineController extends HttpServlet {

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
        if (act.equals("view")) {
            TraineeModel am = new TraineeModel();
            ArrayList<User> list = am.getListTrainee();
            request.setAttribute("listT", list);
            request.getRequestDispatcher("view/Admin/trainee.jsp").forward(request, response);
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
            TraineeModel am = new TraineeModel();
            if (am.checkTraineeExsist(id)) {
                try (PrintWriter out = response.getWriter()) {
                    request.setAttribute("error", "ID already empty");
                    ArrayList<User> list = am.getListTrainee();
                    request.setAttribute("listT", list);
                    request.getRequestDispatcher("view/Admin/trainee.jsp").forward(request, response);
                }
            } else {
                if (am.addTrainee(id, fname, add, phone, email, date, uname, pass, "1")) {
                    response.sendRedirect("view/Admin/trainee.jsp");
                } else {
                    request.setAttribute("error", "Error add !");
                    response.sendRedirect("view/Admin/trainee.jsp");
                }
            }
        }
        if (act.equals("del")) {
            String id = request.getParameter("id");
            TraineeModel am = new TraineeModel();
            if (am.deleteTrainee(id)) {
                response.sendRedirect("view/Admin/trainee.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
         if (act.equals("getid")) {
            String id = request.getParameter("id");
            TraineeModel am = new TraineeModel();
            User list = am.getUser(id);
            request.setAttribute("data", list);
            request.getRequestDispatcher("view/Admin/UpdateTrainee.jsp").forward(request, response);
        }
        if (act.equals("doUpdate")) {
            String id = request.getParameter("id");
            String fname = request.getParameter("fname");
            String add = request.getParameter("add");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String uname = request.getParameter("uname");
            String pass = request.getParameter("pass");
            String date = request.getParameter("birthdaytime");
            TraineeModel am = new TraineeModel();
            if (am.updateTrainee(id,fname, add,phone,email,date,uname,pass)) {
                response.sendRedirect("view/Admin/trainee.jsp");
            } else {
                response.sendRedirect("error.jsp");
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
