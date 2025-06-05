<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<img src="/ProjetoTrilhaWebInte_war_exploded/imgs/logo.png" alt="Logo do Website.">
<h1>Coldigo Geladeiras - Administração</h1>
<nav>
    <div class="opcao dropdown">
        <a href="#"><div class="dropbtn">Registros</div></a>
        <div class="dropdown-content">
            <a href="#" onclick="COLDIGO.carregaPagina('marca'); return false;">Marca</a>
            <a href="#" onclick="COLDIGO.carregaPagina('product'); return false;">Produto</a>
            <a href="#" onclick="COLDIGO.carregaPagina('usuario'); return false;">Usuário</a>
        </div>
    </div>
    <div class="opcao dropdown">
        <a href="#"><div class="dropbtn">Gerenciar</div></a>
        <div class="dropdown-content">
            <a href="#">Compras</a>
            <a href="#">Fale conosco</a>
        </div>
    </div>
    <div class="opcao dropdown">
        <a href="#"><div class="dropbtn">Relatórios</div></a>
        <div class="dropdown-content">
            <a href="#">Produtos</a>
            <a href="#">Compras</a>
            <a href="#">Fale conosco</a>
        </div>
    </div>
    <a href="#"><div class="opcao">Meus dados</div></a>
    <a href="#"><div class="opcao">Sair</div></a>
</nav>
