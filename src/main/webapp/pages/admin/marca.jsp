<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Administração de Marcas</title>
    <link rel="stylesheet" type="text/css" href="../../css/admin.css">
    <script src="../../js/jquery-ui.js"></script>
    <script src="../../js/admin.js"></script>
    <script src="../../js/marca.js"></script>
</head>
<body>
    <h2>Cadastro de Marcas</h2>
    <form id="formMarca" name="formMarca">
        <input type="hidden" name="idMarca" id="idMarca">
        <label for="nomeMarca">Nome:</label>
        <input type="text" name="nome" id="nomeMarca" required>
        <button type="button" id="btnSalvarMarca">Salvar</button>
        <button type="reset">Limpar</button>
    </form>
    <h3>Marcas cadastradas</h3>
    <div id="listaMarcas" class="listaRegistros"></div>
    <!-- Modal de edição de marca -->
    <div id="modalEditaMarca" class="modalEditar"></div>
</body>
</html> 