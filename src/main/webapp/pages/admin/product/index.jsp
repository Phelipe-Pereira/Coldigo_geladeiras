<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
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
                        <button type="button" onclick="COLDIGO.produto.cadastrar()">Cadastrar</button>
                        <button type="reset">Limpar</button>
                    </td>
                </tr>
            </table>
        </fieldset>
    </form>
    <h3>Produtos registrados</h3>
    <form id="filtraProduto" class="frmFiltrar">
        <fieldset>
            <legend>Filtrar</legend>
            <input type="text" name="txtBusca" id="campoBuscaProduto" placeholder="Pesquise pelo modelo">
            <button type="button">Buscar</button>
        </fieldset>
    </form>
    <div id="listaProdutos" class="listaRegistros">

    </div>
    <!-- Modal de edição de produto -->
    <div id="modalEditaProduto" class="modalEditar">
        <form name="frmEditaProduto" id="editProduto" class="frmEditar">
            <table>
                <tr>
                    <th>Categoria</th>
                    <td>
                        <select name="categoria" id="selCategoriaEdicao">
                            <option value="">Selecione</option>
                            <option value="1">Geladeira</option>
                            <option value="2">Freezer</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Marca</th>
                    <td>
                        <select name="marcaId" id="selMarcaEdicao">
                            <option value="" class="buscando">Aguarde, buscando marcas...</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>Modelo</th>
                    <td><input type="text" name="modelo" id="modelo"></td>
                </tr>
                <tr>
                    <th>Capacidade(l)</th>
                    <td><input type="text" name="capacidade" id="capacidade"></td>
                </tr>
                <tr>
                    <th>Valor (R$)</th>
                    <td><input type="text" name="valor" id="valor"></td>
                </tr>
            </table>
            <input type="hidden" name="idProduto" id="idProduto">
        </form>
    </div>
</div>
<div id="modalAviso"></div>
<script src="js/product.js"></script> 