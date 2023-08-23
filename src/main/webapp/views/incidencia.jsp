<%--
  Created by IntelliJ IDEA.
  User: CC10
  Date: 23/08/2023
  Time: 10:31 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crear Incidencia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</head>
<body>
    <div>
        <div class="card">
            <h5 class="card-header">Crear Incidencia</h5>
            <div class="card-body">
                <form action="/user/save-incidencia" method="post">
                    <div class="mb-3">
                        <label for="titulo" class="form-label">Titulo:</label>
                        <input type="text" class="form-control" id="titulo" name="titulo">
                    </div>
                    <div class="mb-3">
                        <label for="descripcion" class="form-label">Descripcion</label>
                        <input type="text" class="form-control" id="descripcion" name="descripcion">
                    </div>
                    <div class="input-group mb-3">
                        <label class="input-group-text" for="inputGroupSelect01">Options</label>
                        <select class="form-select" id="inputGroupSelect01" name="tipo">
                            <option selected value="Justificacion">Justificacion</option>
                            <option value="Muerte">Muerte</option>
                            <option value="PEdir dias Libres">Pedir dias libres</option>
                            <option value="Enfermedad">Enfermedad</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">

</body>
</html>
