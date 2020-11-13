<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Consulta Usuários</title>
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

                <!-- LISTA INICIO -->
                <div class="col-sm-12">
                    <table class="table">
                        <thead>
                            <tr id="tabela-usuario-cabecalho">
                                <th scope="col">ID</th>
                                <th scope="col">Nome</th>
                                <th scope="col">Usuário</th>
                                <th scope="col">Senha</th>
                                <th scope="col">Permissão</th>
                                <th scope="col">&nbsp;</th>
                                <th scope="col">&nbsp;</th>
                            </tr>
                        </thead>
                        <tbody id="tabela-usuario">
                            <c:forEach items="${usuarios}" var="usuario">
                                <tr>
                                    <td scope="row">${usuario.id}</td>
                                    <td>${usuario.nome}</td>
                                    <td>${usuario.username}</td>
                                    <td>${usuario.senha}</td>
                                    <td>${usuario.tipo}</td>
                                    <c:choose>
                                        <c:when test="${usuario.username == 'admin'}">
                                            <td><button class="btn btn-primary" disabled="disabled">Editar</button></td>
                                            <td><button class="btn btn-danger" disabled="disabled">Excluir</button></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><a href="${pageContext.request.contextPath}/usuarios?act=EDITAR&id=${usuario.id}" class="btn btn-primary">Editar</a></td>
                                            <td><a href="${pageContext.request.contextPath}/usuarios?act=EXCLUIR&id=${usuario.id}" class="btn btn-danger" onclick="return confirm('Tem certeza que deseja excluir esse registro?');">Excluir</a></td>
                                        </c:otherwise>
                                    </c:choose>
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