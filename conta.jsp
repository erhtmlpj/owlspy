<!DOCTYPE html>
<html lang="pt-br">
    <head> <!--Aqui s�o colocados os elementos do head tal como os icones e a descri��o do site, tamb�m s�o colocados os links para as folhas de estilo externas e os
    scripts em javascript-->
        <meta charset="utf-8">
        <title>Conta - Monitoramento</title>
        <meta name="description" content="Site que forne�e ferramenta de monitoramento de m�quinas para sua(s) empresa(s) ou sala(s) de aula"> <!-- O elemento description d� uma
    Descri��o da P�gina, isso � util quando navegadors procuram pelo seu site-->
        <link rel="icon" href="Imagem1.png"> <!-- icon indica que o elemento head possui como icone como imagem1.-->
        <link rel="stylesheet" href="style.css" type="text/css"> <!--indica a p�gina de estilos style.css como p�gina a ser usada nesse site. -->
        <script type="text/javascript" src="mainScript.js"></script>
    </head>

    <body>
        <header>
            <h1>Owlspy</h1>
            <img src="Imagem1.png"> 
        </header>

        <nav> <!-- Barra de navega��o principal.-->
            <ul>
                <li><a href="index.html">Home</a></li>
                <li><a href="download.html">Downloads</a></li>
                <li><a href="registro.html">Cadastro</a></li>
                <li><a href="login.html">Login</a></li>
                <li><a href="ferramenta.html">Sobre a Ferramenta</a></li>
                <li><a href="sobre.html">Sobre n�s</a></li>
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
        <nav> <!-- Barra de navega��o principal-->
            <ul>
                <li><a href="Administracao.jsp">Administracao</a></li>
                <li><a href="conta.jsp">Conta</a></li>
                <li><a href="logout.jsp">LogOut</a></li>
            </ul>
        </nav> 
        <%
            }
        %>

        <article> <!--Artigo com conteudo voltado para a configura��o da conta do usu�rio.-->
            <h2>Minha Conta</h2>
            <section>
                <div class="configMenu">
                    <form><!--Form que possui os elementos necess�rios para configura��o da conta, cada elemento executa uma fun��o do javascript.-->
                        <input class="btnBotao" type="button" name="mudaSenha" onclick="mSenha()" value="Mudar Senha"><br><br>
                        <input class="btnBotao" type="button" name="delConta" onclick="dConta()" value="Apagar Conta">
                    </form>
                </div>

                <div id="configCont"><!--Esse div fica vazio at� que uma das op��es de configura��o seja selecionada.-->
                </div>

                <SCRIPT LANGUAGE="JavaScript">


                    function mSenha()
                    {
                        document.getElementById("configCont").innerHTML =
                                "<form method='get' action='Msenha'>" +
                                "<input type='text' name='senha1'><br><br>" +
                                "<input type='text' name='senha2'><br><br>" +
                                "<button type='submit'>Trocar</button>" +
                                "</form>";
                    }

                    function dConta()
                    {
                        document.getElementById("configCont").innerHTML =
                                "Tem certeza? esta a��o n�o pode ser desfeita" +
                                "<form method='get' action='Dconta'>" +
                                "<button type='submit'>Deletar</button>" +
                                "</form>";
                    }
                </SCRIPT>
            </section>

        </article>

        <footer> <!--Rodap�-->
            Rodrigo Mesquita &amp; Emidio Alves&copy;
        </footer>
    </body>
</html>