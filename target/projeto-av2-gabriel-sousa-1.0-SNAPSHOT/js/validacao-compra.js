//MOSTRA CAMPO QTD E FECHAR COMPRA
function mostraCampo(produto) {
    $('#compra-produto'+produto).slideToggle('slow');
    $('#quantidade'+produto).val(1);
}

//ALERT COM TIMER
function alertaTime(msg) {
    $('#'+msg).fadeTo(2000, 500).slideUp(500, function() {
      $('#'+msg).slideUp(500);
    });
}

//VALIDACAO QTD
function validaCompra(produto) {
    var retorno = true;
    var msgErro = "";
    var quantidade = $('#quantidade'+produto);

    if(quantidade.val() == "") {
        quantidade.addClass("is-invalid");
        msgErro +="Informe a quantidade desejada!<br>";
        retorno = false;
    } else {
        quantidade.removeClass("is-invalid");
    }

    if(quantidade.val() <= 0 || quantidade.val() > 99) {
        quantidade.addClass("is-invalid");
        msgErro +="A quantidade m&iacute;nima para compra é de 1 item e m&aacute;xima de 99 itens!<br>";
        retorno = false;
    } else {
        quantidade.removeClass("is-invalid");
    }

    if(!retorno) {
        $("#msgErro"+produto).html(msgErro);
        alertaTime('msgErro');
    } else {
        quantidade.removeClass("is-invalid");
        $("#msgErro"+produto).html("");
    }

    return retorno;
}