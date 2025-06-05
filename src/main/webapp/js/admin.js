COLDIGO = new Object();

$(document).ready(function () {
    $("header").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/general/header.jsp");
    $("footer").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/general/footer.jsp");

    COLDIGO.carregaPagina = function(pagename) {
        $("section").empty();
        $("section").load("/ProjetoTrilhaWebInte_war_exploded/pages/admin/" + pagename + "/index.jsp", function(response, status, info) {
            if (status === "error") {
                const msg = "Houve um erro ao encontrar a página: " + info.status + " - " + info.statusText;
                console.error(msg);
                $("section").html(msg);
            }
        });
    };
});
