/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Course_Category;
import Entity.User;
import Model.Coures_Cate_Model;
import Model.TraineeModel;
import java.io.IOException;
import java.io.PrintWriter;
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
public class CourseCateController extends HttpServlet {

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
            Coures_Cate_Model am = new Coures_Cate_Model();
            ArrayList<Course_Category> list = am.getListCourse_Categorys();
            request.setAttribute("listCC", list);
            request.getRequestDispatcher("view/Admin/course-cate.jsp").forward(request, response);
        }
        if (act.equals("add")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String des = request.getParameter("description");
            String file = request.getParameter("file");
            Coures_Cate_Model am = new Coures_Cate_Model();
            if (am.checkCCExsist(id)) {
                try (PrintWriter out = response.getWriter()) {
                    request.setAttribute("error", "ID already empty");
                    request.getRequestDispatcher("view/Admin/course-cate.jsp").forward(request, response);
                }
            } else {
                if (am.addCourse_Cate(id,des,file ,name)) {
                    response.sendRedirect("view/Admin/course-cate.jsp");
                } else {
                    request.setAttribute("error", "Error add !");
                    response.sendRedirect("view/Admin/course-cate.jsp");
                }
            }
        }
        if (act.equals("del")) {
            String id = request.getParameter("id");
             Coures_Cate_Model am = new Coures_Cate_Model();
            if (am.deleteCC(id)) {
                response.sendRedirect("view/Admin/course-cate.jsp");
            } else {
                response.sendRedirect("error.jsp");
            }
        }
         if (act.equals("getid")) {
            String id = request.getParameter("id");
            Coures_Cate_Model am = new Coures_Cate_Model();
            Course_Category list = am.getCC(id);
            request.setAttribute("data", list);
            request.getRequestDispatcher("view/Admin/UpdateCC.jsp").forward(request, response);
        }
        if (act.equals("doUpdate")) {
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String des = request.getParameter("description");
            String file = request.getParameter("file");
            Coures_Cate_Model am = new Coures_Cate_Model();
            if (am.updateCC(id,des,file,name)) {
                response.sendRedirect("view/Admin/course-cate.jsp");
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
