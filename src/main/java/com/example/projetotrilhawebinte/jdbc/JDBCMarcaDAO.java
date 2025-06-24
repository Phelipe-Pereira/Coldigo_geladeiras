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
            Statement stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(comando);

            while (rs.next()) {
                marca = new Marca();

                int id = rs.getInt("id");
                String nome = rs.getString("nome");

                marca.setId(id);
                marca.setNome(nome);

                listMarcas.add(marca);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listMarcas;
    }

    @Override
    public boolean inserir(Marca marca) {
        String comando = "INSERT INTO marcas (nome) VALUES (?)";
        try (java.sql.PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setString(1, marca.getNome());
            p.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean alterar(Marca marca) {
        String comando = "UPDATE marcas SET nome=? WHERE id=?";
        try (java.sql.PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setString(1, marca.getNome());
            p.setInt(2, marca.getId());
            p.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        // Verifica se há produtos vinculados à marca
        String verifica = "SELECT COUNT(*) FROM produtos WHERE marcas_id=?";
        try (java.sql.PreparedStatement p = this.conexao.prepareStatement(verifica)) {
            p.setInt(1, id);
            java.sql.ResultSet rs = p.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Existem produtos vinculados, não pode excluir
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        // Se não houver produtos vinculados, pode excluir
        String comando = "DELETE FROM marcas WHERE id=?";
        try (java.sql.PreparedStatement p = this.conexao.prepareStatement(comando)) {
            p.setInt(1, id);
            p.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
