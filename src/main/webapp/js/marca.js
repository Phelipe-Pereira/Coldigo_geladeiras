var COLDIGO = COLDIGO || {};
COLDIGO.marca = {};

$(document).ready(function() {
    COLDIGO.marca.buscar();

    $("#btnSalvarMarca").click(function() {
        COLDIGO.marca.salvar();
    });
});

COLDIGO.marca.buscar = function() {
    $.ajax({
        type: "GET",
        url: COLDIGO.PATH + "marca/buscar",
        success: function(marcas) {
            COLDIGO.marca.exibir(marcas);
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao buscar marcas: " + info.status + " - " + info.statusText);
        }
    });
};

COLDIGO.marca.exibir = function(listaDeMarcas) {
    var tabela = "<table>" +
        "<tr><th>Nome</th><th class='acoes'>Ações</th></tr>";
    if (listaDeMarcas && listaDeMarcas.length > 0) {
        $.each(listaDeMarcas, function(i, marca) {
            tabela += "<tr>" +
                "<td>" + marca.nome + "</td>" +
                "<td>" +
                "<button onclick='COLDIGO.marca.exibirEdicao(" + marca.id + ")'>Editar</button> " +
                "<button onclick='COLDIGO.marca.excluir(" + marca.id + ")'>Excluir</button>" +
                "</td>" +
                "</tr>";
        });
    } else {
        tabela += "<tr><td colspan='2'>Nenhuma marca cadastrada</td></tr>";
    }
    tabela += "</table>";
    $("#listaMarcas").html(tabela);
};

COLDIGO.marca.salvar = function() {
    var marca = {};
    marca.id = $("#idMarca").val();
    marca.nome = $("#nomeMarca").val();
    var tipo = marca.id ? "PUT" : "POST";
    var url = COLDIGO.PATH + (marca.id ? "marca/alterar" : "marca/inserir");
    $.ajax({
        type: tipo,
        url: url,
        data: JSON.stringify(marca),
        contentType: "application/json",
        success: function(msg) {
            COLDIGO.exibirAviso(msg);
            COLDIGO.marca.buscar();
            $("#formMarca")[0].reset();
            $("#idMarca").val("");
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao salvar marca: " + info.status + " - " + info.statusText);
        }
    });
};

COLDIGO.marca.exibirEdicao = function(id) {
    $.ajax({
        type: "GET",
        url: COLDIGO.PATH + "marca/buscar",
        success: function(marcas) {
            var marca = marcas.find(function(m) { return m.id === id; });
            if (marca) {
                $("#idMarca").val(marca.id);
                $("#nomeMarca").val(marca.nome);
            }
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao buscar marca para edição: " + info.status + " - " + info.statusText);
        }
    });
};

COLDIGO.marca.excluir = function(id) {
    if (confirm("Deseja realmente excluir esta marca?")) {
        $.ajax({
            type: "DELETE",
            url: COLDIGO.PATH + "marca/excluir/" + id,
            success: function(msg) {
                COLDIGO.exibirAviso(msg);
                COLDIGO.marca.buscar();
            },
            error: function(info) {
                COLDIGO.exibirAviso("Erro ao excluir marca: " + info.status + " - " + info.statusText);
            }
        });
    }
}; 