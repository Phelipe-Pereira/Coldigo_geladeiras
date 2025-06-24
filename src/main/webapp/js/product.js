COLDIGO.produto = new Object();

COLDIGO.produto.carregarMarcas = function(idMarca, selectId) {
    var select = selectId ? "#"+selectId : "#selMarca";
    $.ajax({
        type: "GET",
        url: COLDIGO.PATH + "marca/buscar",
        dataType: 'json',
        success: function(marcas) {
            $(select).html("");
            var option = document.createElement("option");
            option.setAttribute("value", "");
            option.innerHTML = "Escolha";
            $(select).append(option);
            for (var i = 0; i < marcas.length; i++) {
                var option = document.createElement("option");
                option.setAttribute("value", marcas[i].id);
                if (idMarca != undefined && idMarca == marcas[i].id) {
                    option.setAttribute("selected", "selected");
                }
                option.innerHTML = marcas[i].nome;
                $(select).append(option);
            }
        },
        error: function(info) {
            $(select).html("");
            var option = document.createElement("option");
            option.setAttribute("value", "");
            option.innerHTML = "Erro ao carregar marcas!";
            $(select).append(option);
            $(select).addClass("aviso");
        }
    });
};

COLDIGO.produto.cadastrar = function() {
    var produto = {};
    produto.categoria = parseInt($("#categoria").val());
    produto.idMarca = parseInt($("#selMarca").val());
    produto.modelo = $("#modelo").val();
    produto.capacidade = parseInt($("#capacidade").val());
    produto.valor = parseFloat($("#valor").val().replace(',', '.'));

    $.ajax({
        type: "GET",
        url: COLDIGO.PATH + "marca/buscar",
        success: function(marcas) {
            var existe = marcas.some(function(m) { return m.id == produto.idMarca; });
            if (!existe) {
                COLDIGO.exibirAviso("A marca selecionada não existe. Atualize a página e tente novamente.");
                return;
            }

            $.ajax({
                type: "POST",
                url: COLDIGO.PATH + "produto/inserir",
                data: JSON.stringify(produto),
                contentType: "application/json",
                success: function(msg) {
                    COLDIGO.exibirAviso(msg);
                    COLDIGO.produto.buscar();
                    $("#addProduto")[0].reset();
                },
                error: function(info) {
                    COLDIGO.exibirAviso("Erro ao cadastrar produto: " + info.status + " - " + info.statusText);
                }
            });
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao verificar marca: " + info.status + " - " + info.statusText);
        }
    });
};

$(document).ready(function() {
    COLDIGO.produto.carregarMarcas();

    COLDIGO.produto.buscar = function() {
        var valorBusca = $("#campoBuscaProduto").val();
        $.ajax({
            type: "GET",
            url: COLDIGO.PATH + "produto/buscar",
            data: "valorBusca=" + valorBusca,
            dataType: 'json',
            success: function (dados) {
                $("#listaProdutos").html(COLDIGO.produto.exibir(dados));
            },
            error: function (info) {
                COLDIGO.exibirAviso("Erro ao consultar os produtos: " + info.status + " - " + info.statusText);
            }
        });
    };

    COLDIGO.produto.buscar();

    $("#filtraProduto button").click(function() {
        COLDIGO.produto.buscar();
    });
});

COLDIGO.produto.exibir = function(listaDeProdutos) {
    var tabela = "<table>" +
        "<tr>" +
        "<th>Categoria</th>" +
        "<th>Marca</th>" +
        "<th>Modelo</th>" +
        "<th>Cap.(l)</th>" +
        "<th>Valor</th>" +
        "<th class='acoes'>Ações</th>" +
        "</tr>";
    if (listaDeProdutos != undefined && listaDeProdutos.length > 0) {
        for (var i = 0; i < listaDeProdutos.length; i++) {
            tabela += "<tr>" +
                "<td>" + listaDeProdutos[i].categoria + "</td>" +
                "<td>" + listaDeProdutos[i].marca + "</td>" +
                "<td>" + listaDeProdutos[i].modelo + "</td>" +
                "<td>" + listaDeProdutos[i].capacidade + "</td>" +
                "<td>R$ " + COLDIGO.formatarDinheiro(listaDeProdutos[i].valor) + "</td>" +
                "<td>" +
                    "<img src='imgs/edit.png' alt='Editar registro' style='cursor:pointer;' onclick=\"COLDIGO.produto.exibirEdicao('"+listaDeProdutos[i].id+"')\">" +
                    "<img src='imgs/delete.png' alt='Excluir registro' style='cursor:pointer;' onclick=\"COLDIGO.produto.excluir('"+listaDeProdutos[i].id+"')\">" +
                "</td>" +
            "</tr>";
        }
    } else {
        tabela += "<tr><td colspan='6'>Nenhum registro encontrado</td></tr>";
    }
    tabela += "</table>";
    return tabela;
};

COLDIGO.formatarDinheiro = function(valor){
    return valor.toFixed(2).replace('.', ',').replace(/(\d)(?=(\d{3})+,)/g, '$1.');
};

COLDIGO.produto.excluir = function(id) {
    $.ajax({
        type: "DELETE",
        url: COLDIGO.PATH + "produto/excluir/" + id,
        success: function(msg) {
            COLDIGO.exibirAviso(msg);
            COLDIGO.produto.buscar();
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao excluir produto: " + info.status + " - " + info.statusText);
        }
    });
};

COLDIGO.produto.exibirEdicao = function(id) {
    $.ajax({
        type: "GET",
        url: COLDIGO.PATH + "produto/buscarPorId",
        data: "id=" + id,
        dataType: 'json',
        success: function(produto) {
            document.frmEditaProduto.idProduto.value = produto.id;
            document.frmEditaProduto.modelo.value = produto.modelo;
            document.frmEditaProduto.capacidade.value = produto.capacidade;
            document.frmEditaProduto.valor.value = produto.valor;
            
            var selCategoria = document.getElementById('selCategoriaEdicao');
            for (var i = 0; i < selCategoria.length; i++) {
                if (selCategoria.options[i].value == produto.categoria) {
                    selCategoria.options[i].setAttribute("selected", "selected");
                } else {
                    selCategoria.options[i].removeAttribute("selected");
                }
            }
            
            COLDIGO.produto.carregarMarcas(produto.idMarca, 'selMarcaEdicao');
            
            var modalEditaProduto = {
                title: "Editar Produto",
                height: 400,
                width: 500,
                modal: true,
                buttons: {
                    "Salvar": function() { $(this).dialog("close"); },
                    "Cancelar": function() { $(this).dialog("close"); }
                }
            };
            $("#modalEditaProduto").dialog(modalEditaProduto);
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao buscar produto para edição: " + info.status + " - " + info.statusText);
        }
    });
};

COLDIGO.produto.editar = function() {
    var produto = new Object();
    produto.id = document.frmEditaProduto.idProduto.value;
    produto.categoria = document.frmEditaProduto.categoria.value;
    produto.idMarca = document.frmEditaProduto.marca.value;
    produto.modelo = document.frmEditaProduto.modelo.value;
    produto.capacidade = document.frmEditaProduto.capacidade.value;
    produto.valor = document.frmEditaProduto.valor.value;

    $.ajax({
        type: "PUT",
        url: COLDIGO.PATH + "produto/alterar",
        data: JSON.stringify(produto),
        contentType: "application/json",
        success: function(msg) {
            COLDIGO.exibirAviso(msg);
            COLDIGO.produto.buscar();
            $("#modalEditaProduto").dialog("close");
        },
        error: function(info) {
            COLDIGO.exibirAviso("Erro ao editar produto: " + info.status + " - " + info.statusText);
        }
    });
};