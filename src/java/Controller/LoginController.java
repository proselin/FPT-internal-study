/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.User;
import Model.checkLogin;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mangn
 */
public class LoginController extends HttpServlet {

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
         PrintWriter out = response.getWriter();
        try {
            String username = request.getParameter("txtUsn");
            String password = request.getParameter("txtPw");
            // tao Session
            checkLogin am = new checkLogin();
            if (am.checkLogin(username, password)) {
                // lay thong tin role ve         
                User user = am.getlogin(username, password);
                String RoleID = user.getRoleID();
                String fullname = user.getFullName();
                String UserID = user.getUserID();
                // tao session va them cac gia tri vao trong sesstion
                HttpSession session = request.getSession();
                session.setAttribute("User", username);
                session.setAttribute("Pass", password);
                session.setAttribute("RoleID", RoleID);
                session.setAttribute("FullName", fullname);
                session.setAttribute("UserID", UserID);
                // chuyen ve tung trang home theo tung role khac nhau 
                if ("2".equals(RoleID)) {
                    response.sendRedirect("view/Admin/index.jsp");
                }
                if ("4".equals(RoleID)) {
                    response.sendRedirect("view/Staff/index.jsp");
                }
                if ("3".equals(RoleID)) {
                    response.sendRedirect("view/Trainer/home.jsp");
                }
                if ("1".equals(RoleID)) {
                    response.sendRedirect("view/Trainee/home.jsp");
                }
                

                //request.getRequestDispatcher("Testlogin.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Username and Password invalid !");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }

        } finally {
            out.close();
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
