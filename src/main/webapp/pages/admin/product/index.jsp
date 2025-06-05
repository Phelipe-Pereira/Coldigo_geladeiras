<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Administração de Produtos</title>
    <link rel="stylesheet" type="text/css" href="../../../css/admin.css">
    <script type="text/javascript" src="../../../js/jquery-3.6.0.min.js"></script>
    <script type="text/javascript" src="../../../js/admin.js"></script>
    <script src="../../../js/product.js"></script>
</head>
<body>
    <div class="container">
        <h2>Registro de produtos</h2>
        <form name="frmAddProduto" id="addProduto" class="frmInsert">
            <fieldset>
                <legend>Novo produto</legend>
                <table>
                    <tr>
                        <th><label for="categoria">Categoria</label></th>
                        <td>
                            <select name="categoria" id="categoria">
                                <option value="">Selecione</option>
                                <option value="1">Geladeira</option>
                                <option value="2">Freezer</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="marcaId">Marca</label></th>
                        <td>
                            <select name="marcaId" id="selMarca">
                                <option value="" class="buscando">Aguarde, buscando marcas...</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th><label for="modelo">Modelo</label></th>
                        <td>
                            <input type="text" name="modelo" id="modelo">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="capacidade">Capacidade(l)</label></th>
                        <td>
                            <input type="text" name="capacidade" id="capacidade">
                        </td>
                    </tr>
                    <tr>
                        <th><label for="valor">Valor (R$)</label></th>
                        <td>
                            <input type="text" name="valor" id="valor">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button type="button" onclick="COLDIGO.cadastrarProduto()">Cadastrar</button>
                            <button type="reset">Limpar</button>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
    </div>
</body>
</html> 