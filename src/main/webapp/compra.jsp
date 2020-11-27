<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Comprar produtos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/img/favicon.png"/>
        <!-- JQUERY -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.min.js"></script>
        <!-- BOOTSTRAP -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <!-- ESTILO -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilo.css">
        <script src="${pageContext.request.contextPath}/js/validacao-compra.js"></script>
    </head>
    <body>
        <jsp:include page = "fragments/topo.jsp"/>

        <!-- CONTEUDO INICIO -->
        <div class="container" style="margin-top:30px">
            <div class="row">
                <div class="col-sm-12">
                    <h2>Os melhores produtos só aqui na Nerdstore! A maior loja nerd do Brasil!</h2><br>
                </div>
            </div>
            <div class="row">
                
                <div class="col-sm-2"></div>

                <!-- PRODUTOS INICIO -->
                <div class="col-sm-8">
                    <c:if test="${not empty mensagemErro}">
                        <div class="alert alert-danger has-error" role="alert">
                            ${mensagemErro}
                        </div>
                    </c:if>
                    <c:forEach items="${produtos}" var="produto" varStatus="id">
                        <div class="produto-vitrine" id="produto${id.count}">
                            <div class="alert alert-danger has-error" role="alert" id="msgErro${id.count}" style="display:none;"></div>
                            <h5>${produto.nome}</h5>
                            <c:choose>
                                <c:when test="${produto.url != null}">
                                    <img class="imgproduto" src="${produto.url}" title="${produto.nome}"/>
                                </c:when>
                                <c:otherwise>
                                    <img class="imgproduto" src="${pageContext.request.contextPath}/img/indisponivel.png" title="imagem indisponivel"/>
                                </c:otherwise>
                            </c:choose>
                            <h5><fmt:formatNumber value="${produto.preco}" minFractionDigits="2" type="currency"/></h5>
                            <p>${produto.descricao}</p>
                            <p><button type="button" class="btn btn-info" onclick="mostraCampo('${id.count}');">Comprar</button></p>
                            <form action="${pageContext.request.contextPath}/compras" method="post" onsubmit="return validaCompra('${id.count}');">
                                <input type="hidden" id="act" name="act" value="COMPRA">
                                <input type="hidden" name="nome" id="nome${id.count}" value="${produto.nome}"/>
                                <input type="hidden" name="preco" id="preco${id.count}" value="${produto.preco}"/>
                                <input type="hidden" name="id-produto" id="id-produto${id.count}" value="${produto.id}"/>
                                <div id="compra-produto${id.count}" style="display:none;">
                                     <div class="form-group">
                                        <label for="quantidade"><span class="glyphicon glyphicon-user"></span>Quantidade</label>
                                        <input type="number" id="quantidade${id.count}" name="quantidade" min="1" max="99" step="1" value="1"/>
                                    </div>
                                    <button type="submit" class="btn btn-block" style="color:#fff;background-color: #3BB4B4;"><span class="glyphicon glyphicon-off"></span>Fechar Compra</button>
                                </div>
                            </form>
                        </div>
                        <br/>
                    </c:forEach>
                </div>
                <!-- PRODUTOS FIM -->
                
                <div class="col-sm-2"></div>

            </div>
        </div>
        <!-- CONTEUDO FIM -->

        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>