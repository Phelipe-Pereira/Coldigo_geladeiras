package com.example.projetotrilhawebinte.db;

import java.sql.Connection;

public class Conexao {
    private Connection conexao;

    public Connection abrirConexao() {
        try {
            conexao = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://localhost/bdcoldigo?"
                            + "user=root&password=Lipe@9182&useTimezone=true&serverTimezone=UTC"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }

    public void fecharConexao() {
        try{
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
