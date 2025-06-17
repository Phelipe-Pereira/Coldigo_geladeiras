package com.example.projetotrilhawebinte.rest;

import com.example.projetotrilhawebinte.db.Conexao;
import com.example.projetotrilhawebinte.jdbc.JDBCMarcaDAO;
import com.example.projetotrilhawebinte.modelo.Marca;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
