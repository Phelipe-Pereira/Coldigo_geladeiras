package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.google.gson.JsonObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRest extends UtilRest{

    @GET
    @Path("/busca")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response buscarPorNome(@QueryParam("valorBusca") String nome) {

        try {
            List<JsonObject> listaProdutos = new ArrayList<JsonObject>();

            Conexao conec = new Conexao();
            Connection conexao = conec.abrirConexao();
            JDBCMarcaDAO jdbcProduto/

        } catch (Exception e) {
            e.printStackTrace();
            return this.buildErrorResponse(e.getMessage());
        }
    }
}
