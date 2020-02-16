/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.ejb.VentasFacadeLocal;
import com.udea.entity.Vehiculo;
import com.udea.entity.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
public class VentasServlet extends HttpServlet {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

    @EJB
    private VentasFacadeLocal ventasFacade;

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
                List<Ventas> findAll = ventasFacade.findAll();
                request.getSession().setAttribute("ventas", findAll);
                int total = 0;
                for (int i = 0; i < findAll.size(); i++) {
                    total += findAll.get(i).getPrecio();
                }
                request.getSession().setAttribute("total", total);

                url = "listVentas.jsp";

            } else if ("nventa".equals(action)) {
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                for (int i = 0; i < findAll.size(); i++) {
                    if (findAll.get(i).getEstado().equals("Vendido")) {
                        findAll.remove(i);
                    }
                }

                request.getSession().setAttribute("vehiculos", findAll);
                url = "newVenta.jsp";

            } else if ("insert".equals(action)) {

                Ventas a = new Ventas();
                a.setIdvehiculo(Integer.parseInt(request.getParameter("idv")));
                a.setPrecio(Integer.parseInt(request.getParameter("precio")));
                a.setFecha(Date.valueOf(request.getParameter("fecha")));
                ventasFacade.create(a);

                int id = Integer.parseInt(request.getParameter("idv"));
                Vehiculo p = new Vehiculo();
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                for (int i = 0; i <= findAll.size(); i++) {
                    if (findAll.get(i).getVehiculoPK().getId() == id) {
                        p = findAll.get(i);
                        break;
                    }

                }
                p.setEstado("Vendido");
                vehiculoFacade.edit(p);
                url = "VentasServlet?action=list";

            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                Ventas a = ventasFacade.find(Integer.valueOf(id));
                ventasFacade.remove(a);
                url = "VentasServlet?action=list";

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
