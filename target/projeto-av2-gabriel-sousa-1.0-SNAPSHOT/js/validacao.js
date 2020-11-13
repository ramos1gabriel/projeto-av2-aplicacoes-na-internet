//ALERT COM TIMER
function alertaTime(msg) {
    $('#'+msg).fadeTo(2000, 500).slideUp(500, function() {
      $('#'+msg).slideUp(500);
    });
}

//VALIDACAO LOGIN
function validaLogin() {
    var retorno = true;
    var msgErro = "";
    var username = $('#username');
    var senha = $('#senha');

    if(username.val() == "") {
        username.addClass("is-invalid");
        msgErro +="Informe o usu&aacute;rio!<br>";
        retorno = false;
    } else {
        username.removeClass("is-invalid");
    }

    if(senha.val() == "") {
        senha.addClass("is-invalid");
        msgErro +="Informe a senha!<br>";
        retorno = false;
    } else {
        if(senha.val().length < 6) {
            senha.addClass("is-invalid");
            msgErro +="A senha deve conter no m&iacute;nimo 6 digitos";
            retorno = false;
        } else {
            senha.removeClass("is-invalid");
        }
    }
    
    if(!retorno) {
        $("#msgErro").html(msgErro);
        //$("#msgErro").show();
        alertaTime('msgErro');
    } else {
        username.removeClass("is-invalid");
        senha.removeClass("is-invalid");
        $("#msgErro").html("");
        //$("#msgErro").hide();
    }

    return retorno;
}

////validacao cadastro
//function alteraForm(tipo) {
//    if(tipo==1) { //login
//        $('#form-login').show();
//        $("#form-cadastro").hide();
//        //limpa
//        $('#nome-cadastro').removeClass("is-invalid");
//        $('#username-cadastro').removeClass("is-invalid");
//        $('#senha-cadastro').removeClass("is-invalid");
//    }
//    if(tipo==2) { //cadastro
//        $('#form-login').hide();
//        $("#form-cadastro").show();
//        //limpa
//        $('#username').removeClass("is-invalid");
//        $('#senha').removeClass("is-invalid");
//    }
//}

//VALIDACAO CADASTRO
function validaCadastro() {
    var retorno = true;
    var msgErro = "";
    var nome = $('#nome-cadastro');
    var username = $('#username-cadastro');
    var senha = $('#senha-cadastro');
    console.log("nome="+nome.val()+"username="+username.val());

    if(nome.val() == "") {
        nome.addClass("is-invalid");
        msgErro +="Preencha o campo do nome!<br>";
        retorno = false;
    } else {
        nome.removeClass("is-invalid");
    }

    if(username.val() == "") {
        username.addClass("is-invalid");
        msgErro +="Preencha o campo do usu&aacute;rio!<br>";
        retorno = false;
    } else {
        username.removeClass("is-invalid");
    }

    if(senha.val() == "") {
        senha.addClass("is-invalid");
        msgErro +="Preencha o campo da senha!<br>";
        retorno = false;
    } else {
        if(senha.val().length < 6) {
            senha.addClass("is-invalid");
            msgErro +="A senha deve conter no m&iacute;nimo 6 digitos";
            retorno = false;
        } else {
            senha.removeClass("is-invalid");
        }
    }

    if(!retorno) {
        $("#msgErroCadastro").html(msgErro);
        //$("#msgErroCadastro").show();
        alertaTime('msgErroCadastro');
    } else {
        nome.removeClass("is-invalid");
        username.removeClass("is-invalid");
        senha.removeClass("is-invalid");
        $("#msgErroCadastro").html("");
        //$("#msgErroCadastro").hide();
    }

    return retorno;
}