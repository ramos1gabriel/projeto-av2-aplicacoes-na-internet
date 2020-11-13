<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Acesso negado</title>
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
        <div class="container" style="margin-top:30px;align-items: center;">
            <div class="row">
                <div class="col-sm-10" style="text-align: center;">
                    <img src="${pageContext.request.contextPath}/img/403.png" title="acesso nao autorizado"/>
                    <h1 class="cor-do-site">ACESSO NÃO AUTORIZADO!</h1>
                    <br/><br/><br/>
                </div>
            </div>
        </div>
        <!-- CONTEUDO FIM -->

        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>