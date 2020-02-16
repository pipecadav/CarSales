<%-- 
    Document   : menu
    Created on : 2/11/2019, 10:01:30 PM
    Author     : fcadavid, cdiaz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty login}">
    |<a href="login.jsp">Login</a>|
    |<a href="newVendedor.jsp">Register</a>|   
</c:if>
<c:if test="${not empty login}">
    |<a href="VendedoresServlet?action=logout">Logout</a>|
    |<a href="VendedoresServlet?action=list">Lista de Vendedores</a>|
    |<a href="VehiculoServlet?action=list">Lista de Vehiculos</a>|
    |<a href="newVehiculo.jsp">Nuevo vehiculo</a>|
    |<a href="ClientesServlet?action=list">Lista de Clientes</a>|
    |<a href="newCliente.jsp">Nuevo cliente</a>|
    |<a href="VentasServlet?action=list">Lista de ventas</a>|
    |<a href="VentasServlet?action=nventa">Nueva venta</a>|
</c:if>
|<a href="about.jsp">About</a>
<hr/>