<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png"/>
        <!-- JQUERY -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- ESTILO -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <script src="${pageContext.request.contextPath}/js/validacao.js"></script>
    </head>
    <body>
        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-3">&nbsp;</div>
                <!-- LOGIN INICIO -->
                <div class="col-sm-6">
                    <div class="modal-content">
                        <div class="modal-header" style="padding:35px 50px;" id="model-topo">
                            <img src="${pageContext.request.contextPath}/img/logo-login.png" id="img-login" title="logo"/>
                        </div>
                        <div id="form-login">
                            <div class="modal-body" style="padding:40px 50px;">
                                <div class="alert alert-danger has-error" role="alert" id="msgErro" style="display:none;">
                                </div>
                                <c:if test="${not empty mensagemErro}">
                                    <div class="alert alert-danger has-error" role="alert" id="msgErro">
                                        ${mensagemErro}
                                    </div>
                                </c:if>
                                <form action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validaLogin();">
                                    <input type="hidden" id="act" name="act" value="LOGIN">
                                    <div class="form-group">
                                        <label for="username"><span class="glyphicon glyphicon-user"></span>Usuário</label>
                                        <input type="text" class="form-control" id="username" name="username" placeholder="Usuário">
                                    </div>
                                    <div class="form-group">
                                        <label for="senha"><span class="glyphicon glyphicon-eye-open"></span>Senha</label>
                                        <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
                                    </div>
                                    <button type="submit" class="btn btn-block" style="color:#fff;background-color: #3BB4B4;"><span class="glyphicon glyphicon-off"></span>Entrar</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <p>Não tem uma conta? <a class="btn btn-info stretched-link" href="${pageContext.request.contextPath}/cadastroUsuario.jsp">Crie uma!</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- LOGIN FIM -->
                <div class="col-sm-3">&nbsp;</div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="centralizar">
                        <a href="${pageContext.request.contextPath}/index.jsp"><h3 class="cor-do-site">Voltar para página inicial</h3></a>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>