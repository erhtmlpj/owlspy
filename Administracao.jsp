<%-- 
    Document   : Administracao
    Created on : Jul 24, 2017, 8:06:43 AM
    Author     : Aparicio
--%>

<%@page import="Servlets.DAOComputador"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Servlets.Computador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><html lang="pt-br">
    <head> <!--Aqui são colocados os elementos do head tal como os icones e a descrição do site, também são colocados os links para as folhas de estilo externas e os
    scripts em javascript-->
        <meta charset="utf-8">
        <title>Administração - Monitoramento</title>
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
        <article> <!--Este artigo possui elementos que auxiliarão o usuário à monitorar as máquinas com o software.-->
            <%=nome%>
            <h2>Administração</h2>

            <section>
                <div>
                    <h2>Conectar sem salvar</h2>
                    <form method="get" action="Connectar">
                        IP <input name="host" type="text"> <button value="submit" name="connectar" >Conectar</button><!--Es6te botão serve para se conectar ao computador que será monitorado-->
                    </form>
                    <h2>Salvar</h2>
                    <form method="get" action="SalvarPC">
                        IP <input name="host" type="text"> 
                        Nome <input name="name" type="text"> 
                        <button type="submit" name = "salvar">Salvar</button>
                    </form>
                    <h2>Salvos</h2>

                    <form method="get" action="conSalvo">
                        <select name="host2">
                            <%
                                List<Computador> list = new ArrayList();
                                Computador computador = new Computador();
                                DAOComputador daocomputador = new DAOComputador();

                                if (nome != null) {
                                    list = daocomputador.Lista(nome);
                                    out.println("<option value=\"segundo\">Meus Computadores</option>");
                                } else {
                                    out.println("<option value=\"segundo\">Por favor, Faça login primeiro</option>");
                                }
                                int n = list.size();
                                for (int i = 0; i < n; i++) {
                                    out.println("<option value=" + list.get(i).getIp() + ">" + list.get(i).getNome() + "-" + list.get(i).getIp() + "</option>");
                                }
                                /*
                                for (Computador obj : list) {
                                    computador = obj;
                                    out.println("" + obj.getIp());
                                    out.println("<option value=\"" + obj.getIp() + "\">" + obj.getNome() + "-" + obj.getIp() + "</option>");
                                }
                                 */

                            %>
                        </select>
                        <button type="submit">Conectar</button>
                    </form>
                </div>
                <div>

                </div>
            </section>
        </article><!--Este article não está 100% completo, por que o software de monitoramento ainda não está pronto, e não há banco de dados para guardar registro 
    das máquinas.-->

        <footer> <!--Rodapé-->
            Rodrigo Mesquita &amp; Emidio Alves&copy;
        </footer>
    </body>
</html>
