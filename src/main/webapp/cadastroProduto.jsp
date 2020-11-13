<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Cadastro de Produtos</title>
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
        <script src="${pageContext.request.contextPath}/js/validacao-produto.js"></script>
    </head>
    <body>
        <jsp:include page = "fragments/topo.jsp"/>
        
        <div class="container" style="margin-top:30px">
            <div class="row">
                <!-- CADASTRO INICIO -->
                <div class="col-sm-12">
                    <div class="modal-content">
                        <div class="modal-header" style="padding:35px 50px;" id="model-topo">
                            Cadastro dos produtos da loja
                        </div>
                        <div class="modal-body" style="padding:40px 50px;">
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
                            <form action="${pageContext.request.contextPath}/produtos" method="post" onsubmit="return validaCadastro();">
                                <input type="hidden" id="act" name="act" value="CADASTRO">
                                <input type="hidden" id="id" name="id" value="${produto.id}">
                                <div class="form-group">
                                    <label for="nome"><span class="glyphicon glyphicon-user"></span>Nome</label>
                                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" maxlength="50" value="${produto.nome}">
                                </div>
                                <div class="form-group">
                                    <label for="preco"><span class="glyphicon glyphicon-user"></span>Preço</label>
                                    <input type="number" min="1.00" max="10000.00" step="0.01" class="form-control" id="preco" name="preco" value="${produto.preco}">
                                </div>
                                <div class="form-group">
                                    <label for="descricao"><span class="glyphicon glyphicon-user"></span>Descrição</label>
                                    <input type="text" class="form-control" id="descricao" name="descricao" placeholder="Descrição" maxlength="100" value="${produto.descricao}">
                                </div>
                                <div class="form-group">
                                    <label for="url"><span class="glyphicon glyphicon-user"></span>URL da imagem</label>
                                    <input type="text" class="form-control" id="url" name="url" placeholder="Url imagem" maxlength="100" value="${produto.url}">
                                </div>
                                <button type="submit" class="btn btn-block" style="color:#fff;background-color: #3BB4B4;"><span class="glyphicon glyphicon-off"></span>Cadastrar Produto</button>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- CADASTRO FIM -->
            </div>
        </div>
                                    
        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>