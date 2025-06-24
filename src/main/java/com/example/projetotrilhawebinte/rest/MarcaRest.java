package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.example.projetotrilhawebinte.modelo.Marca;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Path("marca")
public class MarcaRest extends UtilRest {

    @GET
    @Path("/buscar")
    @Produces({MediaType.APPLICATION_JSON})
    public Response buscar() {
        try {
            List<Marca> listaMarcas = new ArrayList<Marca>();

            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            
            if (conexao == null) {
                throw new Exception("Não foi possível estabelecer conexão com o banco de dados");
            }
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            listaMarcas = jdbcMarca.buscar();

            conec.fecharConexao();

            return this.buildResponse(listaMarcas);
        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @POST
    @Path("/inserir")
    @Consumes("application/*")
    public Response inserir(String marcaParam) {
        try {
            Marca marca = new Gson().fromJson(marcaParam, Marca.class);
            Conexao conec = new Conexao();
            java.sql.Connection conexao = conec.abrirConexao();
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            boolean retorno = jdbcMarca.inserir(marca);
            String msg = retorno ? "Marca cadastrada com sucesso!" : "Erro ao cadastrar marca.";
            conec.fecharConexao();
            return this.buildResponse(msg);
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }

    @PUT
    @Path("/alterar")
    @Consumes("application/*")
    public Response alterar(String marcaParam) {
        try {
            Marca marca = new Gson().fromJson(marcaParam, Marca.class);
            Conexao conec = new Conexao();
            java.sql.Connection conexao = conec.abrirConexao();
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            boolean retorno = jdbcMarca.alterar(marca);
            String msg = retorno ? "Marca alterada com sucesso!" : "Erro ao alterar marca.";
            conec.fecharConexao();
            return this.buildResponse(msg);
        } catch(Exception e) {
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
            java.sql.Connection conexao = conec.abrirConexao();
            JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
            boolean retorno = jdbcMarca.deletar(id);
            String msg = retorno ? "Marca excluída com sucesso!" : "Não é possível excluir: existem produtos vinculados.";
            conec.fecharConexao();
            return this.buildResponse(msg);
        } catch(Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }
}
