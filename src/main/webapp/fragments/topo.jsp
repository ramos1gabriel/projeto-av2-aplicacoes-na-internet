<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- TOPO -->
<div class="jumbotron text-center" style="margin-bottom:0" id="topo">
    <div id="logosite">
        <a href="${pageContext.request.contextPath}/index.jsp">
            <img src="${pageContext.request.contextPath}/img/logo-nerdstore.png" title="voltar para pagina inicial"/>
        </a>
    </div>
    <p>A maior loja nerd do Brasil, temos produtos dos mais distintos universos da cultura pop e nerd, camisetas personalizadas, decorações e edições exclusivas de O Hobbit e O Senhor dos Anéis.</p> 
</div>

<!-- MENU INICIO -->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <c:choose>
      <c:when test="${not empty usuarioLogado}">
          <a class="navbar-brand" id="myBtn">${sessionScope.usuarioLogado.nome}</a>
      </c:when>
      <c:otherwise>
          <a class="navbar-brand" href="${pageContext.request.contextPath}/login.jsp" id="myBtn">Entrar</a>
      </c:otherwise>
    </c:choose>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
        <ul class="navbar-nav">
            <c:if test="${usuarioLogado.tipo == 'ADMIN'}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Produtos</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/cadastroProduto.jsp">Cadastrar produtos</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/produtos">Lista de produtos</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/pedidos">Compras fechadas</a>
                    </div>
                </li>
            </c:if>
            <c:if test="${usuarioLogado.tipo == 'CLIENTE'}">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Compras</a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/compras">Produtos</a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/pedidos">Suas Compras</a>
                    </div>
                </li>
            </c:if>
            <c:if test="${usuarioLogado.tipo == 'ADMIN'}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/usuarios">Usuários</a>
                </li>
            </c:if>
            <c:if test="${not empty usuarioLogado}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login?act=LOGOUT" onclick="return confirm('Tem certeza que deseja sair?');">Sair</a>
                </li>
            </c:if>
        </ul>
    </div>  
</nav>
<!-- MENU FIM -->