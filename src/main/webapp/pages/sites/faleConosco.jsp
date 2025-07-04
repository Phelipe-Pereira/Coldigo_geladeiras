<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html lang="pt-br">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cóldigo geladeiras</title>
    <link rel="stylesheet" type="text/css" href="../../css/site.css"/>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  </head>
  <body>
    <header></header>
    <nav></nav>
    <section>
        <h2>Fale conosco!</h2>
        <p>Ficou com alguma dúvida? Preencha este formulário e entraremos e contato!</p>
        <form name="formFaleConosco" method="get" action="#" onsubmit="return valideFaleConosco()">
            <fieldset class="faleConosco">
                <legend>Dados pessoais: </legend>
                <label for="nome">Nome: </label>
                <input type="text" name="txtName" id="nome">

                <label for="fone">Telefone: </label>
                <input type="text" name="txtTelefone" id="fone" placeholder="(XX)XXXXX-XXXX">
                
                <label for="email">E-mail: </label>
                <input type="email" name="txtEmail" id="email" placeholder="xxxxxxx@xxxxx.xxx">
            </fieldset>
            <fieldset class="faleConosco">
                <legend>Motivo do contato:</legend>
                <label for="motivo">Motivo: </label>
                <select name="selMotivo" id="motivo" onchange="verificarMotivo(this.value)">
                    <option value="">Escolha</option>
                    <option value="RE">Reclamação</option>
                    <option value="SU">Sugestão</option>
                    <option value="PR">Informação sobre produto</option>
                </select>
                <div id="opcaoProduto"></div>
                <label for="comentario">Comentário: </label>
                <textarea name="txaComentario" id="comentario"></textarea>
                <button type="reset" onclick="verificarMotivo(null)">Limpar</button><button type="submit">Enviar</button>
            </fieldset>
        </form>
    </section>
    <footer></footer>
  </body>
  <script src="../../js/site.js"></script>
</html>