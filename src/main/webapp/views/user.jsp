<%--
  Created by IntelliJ IDEA.
  User: Ayala
  Date: 22/08/2023
  Time: 10:12 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<h1>Usuario</h1>
<form action="/user/view-incidencia">
<div class="col-3 col-md-2">
    <button  type="submit" class="btn btn-outline-success btn-sm buttonColor"
             style="width: 180px; height: 100px; color: #002F5D" onclick="">
        <h5>Crear incidencia</h5>
    </button>
</div>
</form>
<div class="row justify-content-center mt-5">
    <div class="col-10">
        <div class="card">
            <div class="card-header" style="background-color: #002F5D; text-align: center">
                <div class="row">
                    <div class="col" style="color: white">Listado de usuarios</div>
                </div>
            </div>
            <table class="table table-stripped" id="userTable">
                <thead style="background-color: #00AA83; color: white">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Descripcion</th>
                    <th>Tipo</th>
                    <th>Estado</th>
                    <th>Mensaje</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="incidencia" items="${incidencias}" varStatus="s">
                    <tr>
                        <td>
                            <c:out value="${incidencia.id}"/>
                        </td>
                        <td>
                            <c:out value="${incidencia.titulo}"/>
                        </td>
                        <td>
                            <c:out value="${incidencia.descripcion}"/>
                        </td>
                        <td>
                            <c:out value="${incidencia.tipo}"/>
                        </td>
                        <td>
                            <c:out value="${incidencia.estado}"/>
                        </td>
                        <td>
                            <c:out value="${incidencia.mensaje}"/>
                        </td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="6">
                        SIn registros
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
