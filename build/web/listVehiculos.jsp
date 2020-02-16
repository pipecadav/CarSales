<%-- 
    Document   : listVehiculos
    Created on : 2/11/2019, 10:53:25 PM
    Author     : fcadavid, cdiaz
--%>
<%@page import="java.sql.Blob"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>Concesionario</title>
    </head>
    <body class="home">
        <jsp:include page="menu.jsp"></jsp:include>
            <h1>Lista de vehículos</h1>
            <br>
        <c:if test="${param.error==1}">
            <font color="red">Vehículo no encontrado</font>
        </c:if>
        <br>
        <form action="VehiculoServlet?action=buscar" method="post">
            <div>
                <label for="Busqueda por ">Busqueda por placa :</label>
                <input type="search" id="busqueda" name="busqueda"
                       placeholder="Tres letras mayusculas seguidas de 3 números" required=""
                       size="40" pattern="[A-Z]{3}[0-9]{3}">
                <button>Buscar</button>
                <span class="validity"></span>
            </div>
        </form>
        <br>
        <br> 
        <br>
        <table width="50%" border="1" align="center">
            <tr>
                <th>ID</th>
                <th>MATRICULA</th>
                <th>MARCA</th>
                <th>LINEA</th>
                <th>ESTADO</th>
                <th>PLACA</th>
                <th>FOTO</th>
            </tr>
            <c:forEach var="a" items="${vehiculos}">
                <tr align="center" >
                    <td>${a.vehiculoPK.id}</td>
                    <td>${a.vehiculoPK.matricula}</td>
                    <td>${a.marca}</td>
                    <td>${a.linea}</td>
                    <td>${a.estado}</td>
                    <td>${a.placa}</td>
                    <td><img src="data:image/*;base64,${a.bfoto}" width="200" height="100"/></td>
                    <td><a onclick="return confirm('Esta seguro?')" 
                           href="VehiculoServlet?action=delete&id=${a.vehiculoPK.id}&matricula=${a.vehiculoPK.matricula}">
                            Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

