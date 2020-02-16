<%-- 
    Document   : listVentas
    Created on : 2/11/2019, 09:56:10 PM
    Author     : fcadavid, cdiaz
--%>
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
            <h1>Lista de ventas</h1>
            <table width="50%" border="1" align="center">
                <tr>
                    <th>ID</th>
                    <th>ID VEHICULO</th>
                    <th>PRECIO</th>
                    <th>FECHA</th>
                </tr>
            <c:forEach var="a" items="${ventas}">
                <tr align="center" >
                    <td>${a.id}</td>
                    <td>${a.idvehiculo}</td>
                    <td>${a.precio}</td>
                    <td>${a.fecha}</td>                  
                </tr>
            </c:forEach>
            <br>
        </table>
        <table width="50%" border="1" align="center">
            <tr>
                <th> TOTAL VENTAS </th>
                <th> ${total} </th>
            </tr>
        </table>
    </body>
</html>

