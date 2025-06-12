COLDIGO.produto = new Object();

COLDIGO.produto.carregarMarcas = function() {
    $.ajax({
        type: "GET",
        url: "/ProjetoTrilhaWebInte_war_exploded/rest/marca/buscar",
        dataType: 'json',
        success: function(marcas) {
            $("#selMarca").html("");

            if (Array.isArray(marcas) && marcas.length > 0) {
                var option = document.createElement("option");
                option.setAttribute("value", "");
                option.innerHTML = "Selecione";
                $("#selMarca").append(option);

                $("#selMarca").removeClass("aviso");
                
                for (var i = 0; i < marcas.length; i++) {
                    var option = document.createElement("option");
                    option.setAttribute("value", marcas[i].id);
                    option.innerHTML = (marcas[i].nome);
                    $("#selMarca").append(option);
                }
            } else {
                var option = document.createElement("option");

                option.setAttribute("value", "");

                option.innerHTML = "Cadastre uma marca primeiro!";
                $("#selMarca").append(option);
                $("#selMarca").addClass("aviso");
            }
        },
        error: function(info) {
            $("#selMarca").html("");
            var option = document.createElement("option");

            option.setAttribute("value", "");
            option.innerHTML = "Erro ao carregar marcas!";

            $("#selMarca").append(option);
            $("#selMarca").addClass("aviso");
        }
    });
};

COLDIGO.produto.cadastrar = function() {
    alert("Função em desenvolvimento");
};

$(document).ready(function() {
    COLDIGO.produto.carregarMarcas();
});