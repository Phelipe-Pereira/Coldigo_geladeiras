package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCProdutoDAO;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.example.projetotrilhawebinte.modelo.Produto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Path("/produto")
public class ProdutoRest extends UtilRest{

    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscarPorNome(@QueryParam("valorBusca") String nome) {
        try {
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
            List<JsonObject> listaProdutos = jdbcProduto.buscarPorNome(nome != null ? nome : "");
            conec.fecharConexao();
            return this.buildResponse(listaProdutos);
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @DELETE
    @Path("/excluir/{id}")
    @Consumes("application/*")
    public Response excluir(@PathParam("id") int id) {
        try {
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
            boolean retorno = jdbcProduto.deletar(id);
            String msg = retorno ? "Produto excluído com sucesso!" : "Erro ao excluir produto.";
            conec.fecharConexao();
            return this.buildResponse(msg);
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @GET
    @Path("/buscarPorId")
    @Consumes("application/*")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@QueryParam("id") int id) {
        try {
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
            Produto produto = jdbcProduto.buscarPorId(id);
            conec.fecharConexao();
            return this.buildResponse(produto);
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @PUT
    @Path("/alterar")
    @Consumes("application/*")
    public Response alterar(String produtoParam) {
        try {
            Produto produto = new Gson().fromJson(produtoParam, Produto.class);
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
            boolean retorno = jdbcProduto.alterar(produto);
            String msg = retorno ? "Produto alterado com sucesso!" : "Erro ao alterar produto.";
            conec.fecharConexao();
            return this.buildResponse(msg);
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @POST
    @Path("/inserir")
    @Consumes("application/json")
    public Response inserir(String produtoParam) {
        try {
            Produto produto = new Gson().fromJson(produtoParam, Produto.class);
            if (produto.getCategoria() <= 0 || produto.getIdMarca() <= 0) {
                return this.buildErrorResponse("Categoria e marca devem ser selecionadas.");
            }
            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            boolean marcaExiste = jdbcMarca.buscar().stream().anyMatch(m -> m.getId() == produto.getIdMarca());
            if (!marcaExiste) {
                conec.fecharConexao();
                return this.buildErrorResponse("A marca selecionada não existe. Atualize a página e tente novamente.");
            }
            JDBCProdutoDAO jdbcProduto = new JDBCProdutoDAO(conexao);
            jdbcProduto.cadastrar(produto);
            conec.fecharConexao();
            return this.buildResponse("Produto cadastrado com sucesso!");
        } catch(com.google.gson.JsonSyntaxException e) {
            e.printStackTrace();
            return this.buildErrorResponse("Erro ao converter JSON: " + e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }
}
