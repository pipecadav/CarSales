/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servlet;

import com.udea.ejb.VehiculoFacadeLocal;
import com.udea.entity.Vehiculo;
import com.udea.entity.VehiculoI;
import com.udea.entity.VehiculoPK;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Jefry
 */
@MultipartConfig(maxFileSize = 16177215)
public class VehiculoServlet extends HttpServlet {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;

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
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                List<VehiculoI> findAllI = new ArrayList<VehiculoI>();
                for (int i = 0; i < findAll.size(); i++) {
                    byte[] photo = findAll.get(i).getFoto();
                    String bphoto = Base64.getEncoder().encodeToString(photo);
                    VehiculoI v = new VehiculoI(findAll.get(i).getVehiculoPK(), findAll.get(i).getMarca(),
                            findAll.get(i).getModelo(), findAll.get(i).getLinea(), findAll.get(i).getEstado(),
                            findAll.get(i).getPlaca(), bphoto);
                    findAllI.add(v);
                }
                request.getSession().setAttribute("vehiculos", findAllI);
                url = "listVehiculos.jsp";

            } else if ("buscar".equals(action)) {
                List<Vehiculo> findAll = vehiculoFacade.findAll();
                List<VehiculoI> findAllI = new ArrayList<VehiculoI>();
                String d = request.getParameter("busqueda");
                for (int i = 0; i < findAll.size(); i++) {
                    if (request.getParameter("busqueda").equals(findAll.get(i).getPlaca())) {
                        byte[] photo = findAll.get(i).getFoto();
                        String bphoto = Base64.getEncoder().encodeToString(photo);
                        VehiculoI v = new VehiculoI(findAll.get(i).getVehiculoPK(), findAll.get(i).getMarca(),
                                findAll.get(i).getModelo(), findAll.get(i).getLinea(), findAll.get(i).getEstado(),
                                findAll.get(i).getPlaca(), bphoto);
                        findAllI.add(v);
                        request.getSession().setAttribute("vehiculos", findAllI);
                        url = "listVehiculos.jsp";
                        break;
                    }
                }

                if (findAllI.isEmpty()) {
                    url = "listVehiculos.jsp?error=1";
                } else {

                    request.getSession().setAttribute("vehiculos", findAllI);
                    url = "listVehiculos.jsp";
                }

            } else if ("Insertar".equals(action)) {

                boolean checkId = vehiculoFacade.existID(Integer.parseInt(request.getParameter("id")));
                boolean checkplaca = vehiculoFacade.existPlaca(request.getParameter("placa"));
                boolean checkMatricula = vehiculoFacade.existMatricula(Integer.parseInt(request.getParameter("matricula")));
                if (checkId) {
                    url = "newVehiculo.jsp?error=2";

                } else if (checkplaca) {
                    url = "newVehiculo.jsp?error=3";
                } else if (checkMatricula) {
                    url = "newVehiculo.jsp?error=4";
                } else {

                    Vehiculo a = new Vehiculo();

                    a.setVehiculoPK(new VehiculoPK(Integer.parseInt(request.getParameter("id")), 
                            Integer.parseInt(request.getParameter("matricula"))));
                    a.setPlaca(request.getParameter("placa"));
                    a.setMarca(request.getParameter("marca"));
                    a.setLinea(request.getParameter("linea"));
                    a.setModelo(Integer.parseInt(request.getParameter("modelo")));
                    Part filepart = request.getPart("foto");
                    
                    InputStream is = filepart.getInputStream();

                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    byte[] buffer = new byte[0xFFFF];
                    for (int len = is.read(buffer); len != -1; len = is.read(buffer)) {
                        os.write(buffer, 0, len);
                    }
                    a.setFoto(os.toByteArray());
                    a.setEstado("Disponible");
                    vehiculoFacade.create(a);
                    url = "VehiculoServlet?action=list";
                }
            } else if ("delete".equals(action)) {
                int id = Integer.valueOf(request.getParameter("id"));
                int matricula = Integer.valueOf(request.getParameter("matricula"));
                Vehiculo a = vehiculoFacade.find(new VehiculoPK(id, matricula));
                vehiculoFacade.remove(a);
                url = "VehiculoServlet?action=list";
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
