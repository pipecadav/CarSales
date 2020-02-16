
package com.udea.servlet;

import com.udea.ejb.ClienteFacadeLocal;
import com.udea.entity.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ClientesServlet extends HttpServlet {

    @EJB
    private ClienteFacadeLocal clienteFacade;

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
                List<Cliente> findAll = clienteFacade.findAll();
                request.getSession().setAttribute("clientes", findAll);
                url = "listClientes.jsp";

            } else if ("insert".equals(action)) {
                boolean checkId = clienteFacade.existID(Integer.parseInt(request.getParameter("id")));
                if (checkId) {
                    url = "newCliente.jsp?error=2";

                } else {

                    Cliente a = new Cliente();

                    a.setId(Integer.parseInt(request.getParameter("id")));
                    a.setNombres(request.getParameter("nombres"));
                    a.setApellidos(request.getParameter("apellidos"));
                    a.setTelefono(Integer.parseInt(request.getParameter("telefono")));
                    a.setDireccion(request.getParameter("direccion"));
                    a.setEmail(request.getParameter("email"));
                    clienteFacade.create(a);
                    url = "ClientesServlet?action=list";
                }
            } else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                Cliente a = clienteFacade.find(Integer.valueOf(id));
                clienteFacade.remove(a);
                url = "ClientesServlet?action=list";

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
