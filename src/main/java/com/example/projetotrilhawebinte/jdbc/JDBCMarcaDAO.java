package com.example.projetotrilhawebinte.jdbc;

import com.example.projetotrilhawebinte.jdbcinterface.MarcaDAO;
import com.example.projetotrilhawebinte.modelo.Marca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCMarcaDAO implements MarcaDAO {

    private Connection conexao;

    public JDBCMarcaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Marca> buscar() {
        String comando = "SELECT * FROM marcas";
        List<Marca> listMarcas = new ArrayList<Marca>();
        Marca marca = null;

        try {
            System.out.println("Executando consulta: " + comando);
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                marca = new Marca();

                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                marca.setId(id);
                marca.setNome(nome);

                listMarcas.add(marca);
                System.out.println("Marca encontrada: " + nome);
            }

            System.out.println("Total de marcas encontradas: " + listMarcas.size());

        } catch (Exception ex) {
            System.out.println("Erro ao buscar marcas: " + ex.getMessage());
            ex.printStackTrace();
        }

        return listMarcas;
    }
}
