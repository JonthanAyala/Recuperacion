<%--
  Created by IntelliJ IDEA.
  User: Ayala
  Date: 22/08/2023
  Time: 10:12 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
<h1>Usuario</h1>

<div class="col-3 col-md-2">
    <button  type="button" class="btn btn-outline-success btn-sm buttonColor"
             data-bs-toggle="modal" data-bs-target="#ModalI"
             style="width: 180px; height: 100px; color: #002F5D" onclick="">
        <h5>Crear incidencia</h5>
    </button>
</div>

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
                    <th>Descripcion</th>
                    <th>Mensaje</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="incidencia" items="${incidencias}" varStatus="s">
                    <tr>
                        <td>
                            <c:out value="${user.id}"/>
                        </td>
                        <td>
                            <c:out value="${user.descripcion}"/>
                        </td>
                        <td>
                            <c:out value="${user.mensaje}"/>
                        </td>
                        <td>
                            <c:out value="${user.estado}"/>
                        </td>
                        <td>

                            <form method="post" action="/user/aprove">
                                <input hidden value="${user.id}" name="id">
                                <button type="submit" class="btn btn-outline-inadvertent btn-sm">
                                    Aprovar
                                </button>
                            </form>
                            <form method="post" action="/user/des-aprove">
                                <input hidden value="${user.id}" name="id">
                                <button type="submit" class="btn btn-outline-danger btn-sm">
                                    Eliminar
                                </button>
                            </form>
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

<div class="modal fade" id="ModalI" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="exampleModalLabel"> Nueva incidencia </h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="teacherForm" class="needs-validation" novalidate action="/user/save-teacher" method="post">
                    <div class="row">
                        <div class="col">
                            <label for="titulo" class="fw-bold col-form-label">Titulo:</label>
                            <input type="text" name="titulo" id="titulo" class="form-control" required>
                            <div class="invalid-feedback">Campo obligatorio</div>
                        </div>
                        <div class="col">
                            <textarea class="form-control textareaTittle" name="descripcion" id="descripcion"
                                      style="font-size: 30px; overflow: hidden; resize: none"
                                      maxlength="50" oninput="autoResize(this)"
                                      placeholder="Descripcion de la incidencia" required >
                            </textarea>
                            <div class="invalid-feedback">Campo obligatorio</div>
                        </div>
                        <div class="col">
                            <label for="tipo" class="fw-bold col-form-label">Tipo incidencia:</label>
                            <input type="text" name="tipo" id="tipo" class="form-control" required>
                            <div class="invalid-feedback">Campo obligatorio</div>
                        </div>
                    </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancelar </button>
                <button type="submit" id="SaveTeacher" class="btn btn-primary" >Guardar</button>
            </div>
            </form>
        </div>
    </div>
</div>


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</body>
</html>
