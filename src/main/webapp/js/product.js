COLDIGO.produto = new Object()

$(document).ready(function() {

    COLDIGO.produto.carregarMarcas = function() {
        $.ajax({
            url: '/ProjetoTrilhaWebInte_war_exploded/rest/marca/buscar',
            type: 'GET',
            success: function(){

            },
            error: function(){}
        })
    }
})