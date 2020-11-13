//ALERT COM TIMER
function alertaTime(msg) {
    $('#'+msg).fadeTo(2000, 500).slideUp(500, function() {
      $('#'+msg).slideUp(500);
    });
}

//VALIDACAO CADASTRO
function validaCadastro() {
    var retorno = true;
    var msgErro = "";
    var nome = $('#nome');
    var preco = $('#preco');
    var descricao = $('#descricao');
    var url = $('#url');

    if(nome.val() == "") {
        nome.addClass("is-invalid");
        msgErro +="Preencha o campo do nome!<br>";
        retorno = false;
    } else {
        nome.removeClass("is-invalid");
    }

    if(preco.val() == "") {
        preco.addClass("is-invalid");
        msgErro +="Preencha o campo do pre&ccedil;o!<br>";
        retorno = false;
    } else {
        if(preco.val() <= 0) {
            preco.addClass("is-invalid");
            msgErro +="O pre&ccedil;o deve se maior do que ZERO!<br>";
            retorno = false;
        } else {
            preco.removeClass("is-invalid");
        }
    }

    if(descricao.val() == "") {
        descricao.addClass("is-invalid");
        msgErro +="Preencha o campo da descri&ccedil;&atilde;o!<br>";
        retorno = false;
    } else {
        descricao.removeClass("is-invalid");
    }
    
    if(url.val() == "") {
        url.addClass("is-invalid");
        msgErro +="Preencha o campo da URL da imagem do produto!<br>";
        retorno = false;
    } else {
        url.removeClass("is-invalid");
    }

    if(!retorno) {
        $("#msgErroCadastro").html(msgErro);
        alertaTime('msgErroCadastro');
    } else {
        nome.removeClass("is-invalid");
        preco.removeClass("is-invalid");
        descricao.removeClass("is-invalid");
        url.removeClass("is-invalid");
        $("#msgErroCadastro").html("");
    }

    return retorno;
}