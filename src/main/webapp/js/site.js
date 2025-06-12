function valideFaleConosco(){
    var nome = document.formFaleConosco.txtName.value;
    var expRegNome = new RegExp("^[A-zÀ-ü]{3,}([]{1}[A-zÀ-ü]{2,}+$");
    
    if(!expRegNome.test(nome)){
        alert("Preencha seu nome!");    
        document.formFaleConosco.txtName.focus();
        return false;
    }

    var fone = document.formFaleConosco.txtTelefone.value;
    var expRegFone = new RegExp("^[(]{1}[1-9]{2}[)]{1}[0-9]{4,5}[-]{1}[0-9]{4}$");

    if(!expRegFone.test(fone)){
        alert("Preencha seu telefone!");    
        document.formFaleConosco.txtTelefone.focus();
        return false;
    }

    if(document.formFaleConosco.txtEmail.value==""){
        alert("Preencha seu email!");    
        document.formFaleConosco.txtEmail.focus();
        return false;
    }

    if (document.formFaleConosco.selMotivo.value == "PR") {
        var produtoSelect = document.formFaleConosco.selProduto;
        if (produtoSelect && produtoSelect.value == "") {
            alert("Selecione o produto desejado.");    
            produtoSelect.focus();
            return false;
        }
    }

    if(document.formFaleConosco.comentario.value==""){
        alert("Insira um comentário!");    
        document.formFaleConosco.comentario.focus();
        return false;
    }

    return true;
}

function verificarMotivo(motivo){
    var elemento = document.getElementById("opcaoProduto");

    if(motivo == "PR"){
        
        var select = document.createElement("select")
        select.setAttribute("name", "selProduto")

        var option = document.createElement("option");
        option.setAttribute("value", "");
        
        var texto = document.createTextNode("Escolha");

        option.appendChild(texto)

        select.appendChild(option)

        var option = document.createElement("option");
        option.setAttribute("value", "FR");

        var texto = document.createTextNode("Freezer");
        option.appendChild(texto);

        select.appendChild(option);
        
        var option = document.createElement("option");
        option.setAttribute("value", "GE");

        var texto = document.createTextNode("Geladeira");

        option.appendChild(texto);

        select.appendChild(option);

        elemento.appendChild(select);
    }else{
        if(elemento.firstChild){
            elemento.removeChild(elemento.firstChild);
        }
    }
}

$(document).ready(function () {
    $("header").load("/ProjetoTrilhaWebInte_war_exploded/pages/sites/general/cabecalho.jsp")
    $("nav").load("/ProjetoTrilhaWebInte_war_exploded/pages/sites/general/menu.jsp")
    $("footer").load("/ProjetoTrilhaWebInte_war_exploded/pages/sites/general/rodape.jsp")
})