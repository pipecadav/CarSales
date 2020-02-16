<%-- 
    Document   : newCliente
    Created on : 2/11/2019, 10:7:59 PM
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
            <h1>Ingrese un nuevo cliente</h1>        
        <c:if test="${param.error==2}">
            <font color="red">El ID ingresado ya existe</font>
        </c:if>        
        <div class="container well">
            <form action="ClientesServlet?action=insert" method="post">
                <table>
                    <tr>
                        <th> <label><b>ID:</b></label></th>
                        <th><input type="number" placeholder="Máximo 9 digitos" 
                                   class="form-control" name="id" required="" pattern="[0-9]{9}"/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Nombres :</b></label></th>
                        <th><input type="text" placeholder="Enter nombres" 
                                   class="form-control" name="nombres" required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label> <b>Apellidos :</b></label> </th>
                        <th>
                            <input type="text" placeholder="Enter apellidos" 
                                   class="form-control" name="apellidos" required=""/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Telefono :</b></label></th>
                        <th><input type="number" placeholder="Máximo 8 digitos" 
                                   class="form-control" name="telefono" required="" pattern="[0-9]{8}"/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Dirección :</b></label></th>
                        <th><input type="text" placeholder="Enter dirección" 
                                   class="form-control" name="direccion" required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Email :</b></label></th>
                        <th><input type="text" placeholder="Enter email" 
                                   class="form-control" name="email" required=""/> </th>
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
