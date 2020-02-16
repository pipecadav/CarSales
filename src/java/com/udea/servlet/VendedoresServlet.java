/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VendedoresFacadeLocal;
import com.udea.entity.Vendedores;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jefry
 */
public class VendedoresServlet extends HttpServlet {

    @EJB
    private VendedoresFacadeLocal vendedoresFacade;

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

            String action = request.getParameter("action");
            String url = "index.jsp";

            if ("list".equals(action)) {
                List<Vendedores> findAll = vendedoresFacade.findAll();
                request.getSession().setAttribute("vendedores", findAll);
                url = "listVendedores.jsp";

            } else if ("login".equals(action)) {
                String u = request.getParameter("username");
                String p = request.getParameter("password");
                boolean checklogin = vendedoresFacade.checkLogin(u, p);
                if (checklogin) {
                    request.getSession().setAttribute("login", u);
                    url = "manager.jsp";

                } else {
                    url = "login.jsp?error=1";
                }

            } else if ("insert".equals(action)) {
                boolean checkUser = vendedoresFacade.existUsuario(request.getParameter("username"));
                boolean checkId = vendedoresFacade.existID(Integer.parseInt(request.getParameter("id")));

                if (checkId) {
                    url = "newVendedor.jsp?error=2";
                    
                }else if(checkUser){ 
                    
                     url = "newVendedor.jsp?error=1";
                } else {

                    Vendedores a = new Vendedores();

                    a.setUsername(request.getParameter("username"));
                    a.setPassword(request.getParameter("password"));
                    a.setId(Integer.parseInt(request.getParameter("id")));
                    a.setNombres(request.getParameter("nombres"));
                    a.setApellidos(request.getParameter("apellidos"));
                    vendedoresFacade.create(a);
                    url = "login.jsp";
                }

            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                Vendedores a = vendedoresFacade.find(Integer.valueOf(id));
                vendedoresFacade.remove(a);
                url = "VendedoresServlet?action=list";

            } else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            }
            response.sendRedirect(url);
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
