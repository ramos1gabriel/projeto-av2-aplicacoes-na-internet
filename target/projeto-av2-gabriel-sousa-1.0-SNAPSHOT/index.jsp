<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Nerdstore - Página Inicial</title>
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

                 <!-- ABOUT INICIO -->
                <div class="col-sm-4">
                    <h2>Fundadores</h2>
                    <img src="${pageContext.request.contextPath}/img/donos.jpg" title="donos da nerdstore" id="img-about"/>
                    <p>Nerdstore é uma loja brasileira de comércio eletrônico. Criada em setembro de 2007 pela empresa Jovem Nerd, a Nerdstore se tornou "a maior loja nerd do Brasil"</p>
                    <h3>Outros projetos</h3>
                    <ul class="nav nav-pills flex-column">
                        <li class="nav-item">
                            <a class="nav-link text-info" href="https://jovemnerd.com.br/nerdcast/" target="_blank">NerdCast</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="https://jovemnerd.com.br/nerdplayer/" target="_blank">NerdPlayer</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-info" href="https://jovemnerd.com.br/nerdologia/" target="_blank">Nerdologia</a>
                        </li>
                    </ul>
                    <hr class="d-sm-none">
                </div>
                <!-- ABOUT FIM -->

                <!-- NOTICIAS INICIO -->
                <div class="col-sm-8">
                    <h2>Camisetas</h2>
                    <div><img src="${pageContext.request.contextPath}/img/camisetas_ajuste.png" width="730" height="200" title="camisas disponiveis"/></div>
                    <br>
                    <p>Chegou uma nova remessa de camisetas que você não pode perder! Milhões de camisetas do universo pop, que incluem, filmes, séries, tv, mangás, HQs, quadrinhos, gibi e tudo mais do universo nerd e geek. Veja nossos produtos clicando no botão abaixo.</p>
                    <c:choose>
                        <c:when test="${not empty usuarioLogado}">
                            <p><a href="${pageContext.request.contextPath}/compras" class="btn btn-info">Ver produtos</a></p>
                        </c:when>
                        <c:otherwise>
                            <p>
                                <button type="button" class="btn btn-info" disabled="disabled">Ver produtos</button>
                                <span class="bg-danger text-white">&nbsp;(É necessário estar logado)</span>
                            </p>
                        </c:otherwise>
                      </c:choose>
                    <br>
                    <h2>Novas franquias pelo mundo</h2>
                    <div><img src="${pageContext.request.contextPath}/img/nova-loja.png" width="730" height="200" title="novas lojas pelo mundo!"/></div>
                    <br>
                    <p>Novas lojas estão sendo abertas pelo mundo todo, sim é isso mesmo que você leu! MUNDO INTEIRO! Agora você de qualquer país pode comprar na Nerdstore, a maior loja nerd do mundo! Veja nossos produtos clicando no botão abaixo.</p>
                    <c:choose>
                        <c:when test="${not empty usuarioLogado}">
                            <p><a href="${pageContext.request.contextPath}/compras" class="btn btn-info">Ver produtos</a></p>
                        </c:when>
                        <c:otherwise>
                            <p>
                                <button type="button" class="btn btn-info" disabled="disabled">Ver produtos</button>
                                <span class="bg-danger text-white">&nbsp;(É necessário estar logado)</span>
                            </p>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!-- NOTICIAS FIM -->

            </div>
        </div>
        <!-- CONTEUDO FIM -->

        <jsp:include page = "fragments/rodape.jsp"/>
    </body>
</html>