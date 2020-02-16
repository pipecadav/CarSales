<%-- 
    Document   : listVendedores
    Created on : 21/11/2019, 09:30:02 PM
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
            <h1>Vendedores</h1>
            <table width="50%" border="1" align="center">
                <tr>                    <th>ID</th>
                    <th>USERNAME</th>
                    <th>NOMBRES</th>
                    <th>APELLIDOS</th>
                </tr>
            <c:forEach var="a" items="${vendedores}">
                <tr align="center" >
                    <td>${a.id}</td>
                    <td>${a.username}</td>
                    <td>${a.nombres}</td>
                    <td>${a.apellidos}</td>
                    <td><a onclick="return confirm('Esta seguro?')" 
                           href="VendedoresServlet?action=delete&id=${a.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>

