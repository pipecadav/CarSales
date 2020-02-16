<%-- 
    Document   : newVehiculo
    Created on : 21/11/2019, 09:52:12 PM
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
            <h1>Ingrese un nuevo vehículo</h1>
        <c:if test="${param.error==1}">
            <font color="red">Estado invalido. Sólo se admite un estado</font>
        </c:if>
        <c:if test="${param.error==2}">
            <font color="red">El ID ingresado ya existe</font>
        </c:if>
        <c:if test="${param.error==3}">
            <font color="red">La Placa ya existe</font>
        </c:if>
        <c:if test="${param.error==4}">
            <font color="red">La matricula ya existe</font>
        </c:if>
        <div class="container well">
            <form method="post" action="VehiculoServlet?action=insert"  enctype="multipart/form-data" >
                <table>
                    <tr>
                        <th> <label><b>ID:</b></label></th>
                        <th><input type="number" placeholder="Máximo 9 digitos" class="form-control" 
                                   name="id" required pattern="[A-Z]{3}[0-9]{3}"/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Matricula:</b></label></th>
                        <th><input type="number" placeholder="Máximo 5 digitos" class="form-control" 
                                   name="matricula" required="" pattern="[0-9]{5}"/> </th>
                    </tr>
                    <tr>
                        <th> <label> <b>Placa:</b></label> </th>
                        <th>
                            <input type="text" placeholder="3 letras mayúsculas + 3 números" class="form-control" 
                                   name="placa" required="" pattern="[A-Z]{3}[0-9]{3}"/>
                        </th>
                    </tr>
                    <tr>
                        <th> <label><b>Marca:</b></label></th>
                        <th><input type="text" placeholder="Enter Marca" class="form-control" 
                                   name="marca" required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Linea :</b></label></th>
                        <th><input type="text" placeholder="Enter linea" class="form-control" 
                                   name="linea" required=""/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Modelo :</b></label></th>
                        <th><input type="number" placeholder="Sólo 4 digitos" class="form-control" 
                                   name="modelo" required="" pattern="[0-9]{4}"/> </th>
                    </tr>
                    <tr>
                        <th> <label><b>Foto :</b></label></th>
                        <th><input type="file" class="form-control" name="foto" required=""/> </th>
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
