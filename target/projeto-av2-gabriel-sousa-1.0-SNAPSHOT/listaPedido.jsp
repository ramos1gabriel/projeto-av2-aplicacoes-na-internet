<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="pt-BR"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Compras</title>
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
    </head>
    <body>
        <jsp:include page = "fragments/topo.jsp"/>

        <!-- CONTEUDO INICIO -->
        <div class="container" style="margin-top:30px">
            
            <div class="row">
                <div class="col-sm-12">
                    <c:choose>
                        <c:when test="${usuarioLogado.tipo == 'ADMIN'}">
                            <h2>Lista de todos as compras fechadas na loja</h2>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${not empty compras}">
                                <h2>Olá ${usuarioLogado.nome}, veja suas compras:</h2>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <br/>
                </div>
            </div>
            
            <div class="row">

                <!-- LISTA INICIO -->
                <div class="col-sm-12">
                    <c:if test="${not empty mensagemSucesso}">
                        <div class="alert alert-success" role="alert">
                            ${mensagemSucesso}
                        </div>
                    </c:if>
                    <c:choose>
                        <c:when test="${not empty compras}">
                            <table class="table">
                                <thead>
                                    <tr id="tabela-usuario-cabecalho">
                                        <th scope="col">N.º do Protocolo</th>
                                        <th scope="col">Produto</th>
                                        <th scope="col">Data da Compra</th>
                                        <th scope="col">Quantidade</th>
                                        <th scope="col">Valor</th>
                                        <c:choose>
                                            <c:when test="${usuarioLogado.tipo == 'ADMIN'}">
                                                <th scope="col">Comprador</th>
                                            </c:when>
                                            <c:otherwise>
                                                <th scope="col">Status</th>
                                            </c:otherwise>
                                        </c:choose>
                                    </tr>
                                </thead>
                                <tbody id="tabela-usuario">
                                    <c:forEach items="${compras}" var="compra">
                                        <tr>
                                            <td scope="row">${compra.protocolo}</td>
                                            <td>${compra.nomeProduto}</td>
                                            <td><fmt:formatDate value="${compra.dataCompra}" type="both" pattern="dd/MM/yyyy" dateStyle="full"/></td>
                                            <td>${compra.quantidade}</td>
                                            <td><fmt:formatNumber value="${compra.valorCompra}" minFractionDigits="2" type="currency"/></td>
                                            <c:choose>
                                                <c:when test="${usuarioLogado.tipo == 'ADMIN'}">
                                                    <td>${compra.nomeUsuario}</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><span class="bg-success text-white">Compra Aprovada</span></td>
                                                </c:otherwise>
                                            </c:choose>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </c:when>
                        <c:otherwise>
                            <div id="msg-sem-compras">
                                <img src="${pageContext.request.contextPath}/img/compras.png" id="img-compras" title="voce ainda nao possui compras"/>
                                <h1 class="cor-do-site">Você ainda não possui nenhuma compra!</h1>
                                <h5 class="cor-do-site">Mude isso agora, veja nossos produtos á venda <a href="${pageContext.request.contextPath}/compras">clicando aqui</a></h5>
                                <br/>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- LISTA FIM -->

            </div>
        </div>
        <!-- CONTEUDO FIM -->

        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>