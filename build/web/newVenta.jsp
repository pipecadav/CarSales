<%-- 
    Document   : newCliente
    Created on : 21/11/2019, 09:46:48 PM
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
            <h1>Ingrese una nueva venta</h1>
        <c:if test="${param.error==2}">
            <font color="red">El ID ingresado ya existe</font>
        </c:if>
        <div class="container well">
            <form action="VentasServlet?action=insert" method="post">
                <table>                    
                    <tr>
                        <th> <label><b>ID Vehiculo :</b></label></th>
                        <th> <select name="idv" required="">    
                                <c:forEach var="a" items="${vehiculos}">
                                    <option value="${a.vehiculoPK.id}">  ${a.vehiculoPK.id}   </option> 
                                </c:forEach>
                            </select> 
                        </th>
                    <tr>
                        <th> <label><b>Precio :</b></label></th>
                        <th><input type="number" placeholder="Máximo 9 digitos" class="form-control" 
                                   name="precio" required="" pattern="[0-9]{9}"/> </th>
                    </tr>
                    <tr>
                        <th> <label> <b>Fecha :</b></label> </th>
                        <th>
                            <input type="date" placeholder="Enter fecha" class="form-control" name="fecha" required=""/>
                        </th>
                    </tr>
                    <div class="break"></div>
                    </div>
                    <tr>
                        <td colspan="2">
                            <input class="btn icon-btn btn-success" type="submit" name="action" value="Insertar">
                            <span class="glyphicon glyphicon-ok-sing"></span>

                            <input class="btn btn-info btn-lg" type="reset" name="action" value="Reset">
                            <span class="glyphicon glyphicon-remove"></span>
                        </td>
                    </tr>
                </table>
            </form>
            <br>
        </div>
    </body>
</html>
