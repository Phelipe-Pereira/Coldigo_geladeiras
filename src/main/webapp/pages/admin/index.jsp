<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="Administração do Site da Código Geladeiras">
    <meta name="keywords" content="Geladeiras, Frost-free, Refrigeração">
    <meta name="author" content="Phelipe Pereira">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Coldigo Geladeiras - Administração</title>

    <base href="/ProjetoTrilhaWebInte_war_exploded/">

    <link rel="stylesheet" type="text/css" href="css/admin.css">
    <link rel="stylesheet" type="text/css" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
    <script src="js/admin.js"></script>
    <script src="js/site.js"></script>
</head>

<body>
<header>
</header>
<section>
    <h2>O que você deseja fazer hoje?</h2>
    <label for="selCategoria">Categoria</label>
    <select id="selCategoria" name="categoria">
      <option value="">Selecione</option>
      <option value="1">Geladeira</option>
      <option value="2">Freezer</option>
    </select>
</section>
<div id="modalAviso"></div>
<footer>
</footer>
</body>
</html>
