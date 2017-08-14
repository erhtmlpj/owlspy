<%-- 
    Document   : logout
    Created on : 02/08/2017, 09:05:16
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head> <!--Aqui são colocados os elementos do head tal como os icones e a descrição do site, também são colocados os links para as folhas de estilo externas e os
    scripts em javascript-->
        <meta charset="utf-8">
        <title>Home - Monitoramento</title>
        <meta name="description" content="Site que forneçe ferramenta de monitoramento de máquinas para sua(s) empresa(s) ou sala(s) de aula"> <!-- O elemento description dá uma
    Descrição da Página, isso é util quando navegadors procuram pelo seu site-->
        <link rel="icon" href="Imagem1.png"> <!-- icon indica que o elemento head possui como icone como imagem1.-->
        <link rel="stylesheet" href="style.css" type="text/css"> <!--indica a página de estilos style.css como página a ser usada nesse site. -->
        <script type="text/javascript" src="mainScript.js"></script>
    </head>

    <body>
        <header>
            <h1>Owlspy</h1>
            <img src="Imagem1.png"> 
        </header>

        <nav> <!-- Barra de navegação principal-->
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="download.html">Downloads</a></li>
                <li><a href="registro.html">Cadastro</a></li>
                <li><a href="login.html">Login</a></li>
                <li><a href="ferramenta.html">Sobre a Ferramenta</a></li>
                <li><a href="sobre.html">Sobre nós</a></li>
            </ul>
        </nav>
        
        
        <%
                String nome = "";
                if (request.getAttribute("name") != null) {
                    session.setAttribute("name", request.getAttribute("name"));
                    nome = (String) session.getAttribute("name");
                } else {
                    nome = (String) session.getAttribute("name");
                }
                if (nome == null) {
                    response.sendRedirect("login.html");
                }
            %>
        
        <%
                if (nome != null) { //http://www.java2s.com/Code/Java/JSP/JspformUsingButtons.htm
            %>
            <nav> <!-- Barra de navegação principal-->
                <ul>
                    <li><a href="Administracao.jsp">Administracao</a></li>
                    <li><a href="conta.jsp">Conta</a></li>
                    <li><a href="logout.jsp">LogOut</a></li>
                </ul>
            </nav> 
            <%
                }
        %>
        
        <article><!--Artigo com conteúdo relacionado ao logout, caso o usuário aperte o botão de logout por engano, ele não será retirado instantaneamente do site.-->
            <h2>Logout</h2>
            <div align="center">
                <p>Obrigado pela visíta, volte sempre</p>
            </div>
            
            <%
                if(request.getParameter("logouts")!=null)
                {
                    session.invalidate();
                    response.sendRedirect("index.html");
                }
            %>
            
            <div>
                <form method="post" name="form1">
                    <input type="hidden" name="logouts">
                    <input type="button" value="btnLogout" onclick="logout()">
                </form>

                <SCRIPT LANGUAGE="JavaScript">

                    function logout()
                    {
                        document.form1.logouts.value = "fezlogout"
                        form1.submit()
                    }

                </SCRIPT>

            </div>
        </article>

        <footer> <!--Rodapé-->
            Rodrigo Mesquita &amp; Emidio Alves&copy;
        </footer>
    </body>
</html>
