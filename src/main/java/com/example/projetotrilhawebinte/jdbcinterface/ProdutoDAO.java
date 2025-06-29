package com.example.projetotrilhawebinte.jdbcinterface;

import com.example.projetotrilhawebinte.modelo.Produto;
import com.google.gson.JsonObject;

import java.util.List;

public interface ProdutoDAO {
    public void cadastrar(Produto produto);
    public List<JsonObject> buscarPorNome(String nome);
    public boolean deletar(int id);
    public Produto buscarPorId(int id);
    public boolean alterar(Produto produto);
}