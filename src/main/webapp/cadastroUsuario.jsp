<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Cadastro de Usuários</title>
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
                <!-- CADASTRO INICIO -->
                <div class="col-sm-6">
                    <div class="modal-content">
                        <div class="modal-header" style="padding:35px 50px;" id="model-topo">
                            <img src="${pageContext.request.contextPath}/img/logo-login.png" id="img-login"/>
                        </div>
                        <div id="form-cadastro">
                            <div class="modal-body" style="padding:40px 50px;">
                                <p>Venha fazer parte da maior comunidade nerd do Brasil!</p> 
                                <div class="alert alert-danger has-error" role="alert" id="msgErroCadastro" style="display:none;">
                                </div>
                                <c:if test="${not empty mensagemErro}">
                                    <div class="alert alert-danger has-error" role="alert">
                                        ${mensagemErro}
                                    </div>
                                </c:if>
                                <c:if test="${not empty mensagemSucesso}">
                                    <div class="alert alert-success" role="alert">
                                        ${mensagemSucesso}
                                    </div>
                                </c:if>
                                <form action="${pageContext.request.contextPath}/usuarios" method="post" onsubmit="return validaCadastro();">
                                    <input type="hidden" id="act" name="act" value="CADASTRO">
                                    <input type="hidden" id="id" name="id" value="${usuario.id}">
                                    <div class="form-group">
                                        <label for="nome-cadastro"><span class="glyphicon glyphicon-user"></span>Nome</label>
                                        <input type="text" class="form-control" id="nome-cadastro" name="nome-cadastro" placeholder="Nome" maxlength="20" value="${usuario.nome}">
                                    </div>
                                    <div class="form-group">
                                        <label for="username-cadastro"><span class="glyphicon glyphicon-user"></span>Usuário</label>
                                        <input type="text" class="form-control" id="username-cadastro" name="username-cadastro" placeholder="Usuário" maxlength="20" value="${usuario.username}">
                                    </div>
                                    <c:if test="${usuario.id != null}">
                                        <div class="form-group">
                                            <label for="tipo">Permissão</label>
                                            <select class="form-control" id="tipo" name="tipo">
                                                <c:choose>
                                                  <c:when test="${usuario.tipo == 'CLIENTE'}">
                                                      <option value="CLIENTE" selected>Cliente</option>
                                                      <option value="ADMIN">Administrador</option>
                                                  </c:when>
                                                  <c:otherwise>
                                                      <option value="CLIENTE">Cliente</option>
                                                      <option value="ADMIN" selected>Administrador</option>
                                                  </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </div>
                                    </c:if>
                                    <div class="form-group">
                                        <label for="senha-cadastro"><span class="glyphicon glyphicon-eye-open"></span>Senha</label>
                                        <input type="password" class="form-control" id="senha-cadastro" name="senha-cadastro" placeholder="Senha" maxlength="10">
                                    </div>
                                    <button type="submit" class="btn btn-block" style="color:#fff;background-color: #3BB4B4;"><span class="glyphicon glyphicon-off"></span>Cadastrar-se</button>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <p>Já possui uma conta? <a class="btn btn-info stretched-link" href="${pageContext.request.contextPath}/login.jsp">Então faça login!</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- CADASTRO FIM -->
                <div class="col-sm-3">&nbsp;</div>
            </div>
        </div>
    </body>
</html>