<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<fmt:setLocale value="pt-BR"/>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Consulta Produtos</title>
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
                    <h2>Lista de produtos cadastrados na loja</h2><br/>
                </div>
            </div>
            <div class="row">

                <!-- LISTA INICIO -->
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr id="tabela-usuario-cabecalho">
                                <th scope="col">ID</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Preço</th>
                                <th scope="col">Descrição</th>
                                <th scope="col">&nbsp;</th>
                                <th scope="col">&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody id="tabela-usuario">
                            <c:forEach items="${produtos}" var="produto">
                                <tr>
                                    <td scope="row">${produto.id}</td>
                                    <td>${produto.nome}</td>
                                    <td><fmt:formatNumber value="${produto.preco}" minFractionDigits="2" type="currency"/></td>
                                    <td>${produto.descricao}</td>
                                    <td><a href="${pageContext.request.contextPath}/produtos?act=EDITAR&id=${produto.id}" class="btn btn-primary">Editar</a></td>
                                    <td><a href="${pageContext.request.contextPath}/produtos?act=EXCLUIR&id=${produto.id}" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja excluir esse registro?');">Excluir</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- LISTA FIM -->

            </div>
        </div>
        <!-- CONTEUDO FIM -->

        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>