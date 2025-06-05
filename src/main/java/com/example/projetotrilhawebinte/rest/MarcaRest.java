package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.example.projetotrilhawebinte.modelo.Marca;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;


@Path("marca")
public class MarcaRest {

    @GET
    @Path("/buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscar(){
        List<Marca> listaMarcas = new ArrayList<Marca>();

        Conexao conec = new Conexao();
        Connection conexao = conec.abrirConexao();
        JDBCMarcaDAO jdbcMarca = new JDBCMarcaDAO(conexao);
        listaMarcas = jdbcMarca.buscar();

        conec.fecharConexao();
    }
}
