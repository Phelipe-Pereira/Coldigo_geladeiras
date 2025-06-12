var COLDIGO = COLDIGO || {};

COLDIGO.exibirAviso = function(aviso) {
    console.log("Tentando exibir modal com mensagem:", aviso);
    
    if (!$("#modalAviso").length) {
        console.error("Elemento #modalAviso não encontrado!");
        $("body").append('<div id="modalAviso"></div>');
        console.log("Elemento #modalAviso criado dinamicamente");
    }
    
    var modal = {
        title: "Mensagem",
        height: 250,
        width: 400,
        modal: true,
        buttons: {
            "OK": function() {
                $(this).dialog("close");
            }
        }
    };
    
    try {
        $("#modalAviso").html(aviso);
        $("#modalAviso").dialog(modal);
        console.log("Modal exibido com sucesso");
    } catch(e) {
        console.error("Erro ao exibir modal:", e);
        alert(aviso); // Fallback para alert caso o modal falhe
    }
};

$(document).ready(function () {
    $("header").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/general/header.jsp");
    $("footer").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/general/footer.jsp");

    COLDIGO.carregaPagina = function(pagename) {
        $("section").empty();
        $("section").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/" + pagename + "/index.jsp", function(response, status, info) {
            if (status === "error") {
                var msg = "Houve um erro ao encontrar a página: " + info.status + " - " + info.statusText;
                console.error(msg);
                $("section").html(msg);
            }
        });
    };
});
