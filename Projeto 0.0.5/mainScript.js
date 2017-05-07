var isLogged = true;
if(isLogged)
{
    document.write("<aside>");
    document.write("<ul>");
    document.write("<li><a>Administracao</a></li>");
    document.write("<li><a>Logout</a></li>");
    document.write("<li><a>Minha Conta</a></li>");
    document.write("<ul>");
    document.write("</aside>");
}

function mSenha()
{
    document.getElementById("configCont").innerHTML += "<form> <table> <tr> <td>Antiga Senha</td> <td><input type=\"password\" name=\"antSenha\"></td> </tr> <tr> <td>Nova Senha   </td> <td><input type=\"password\" name=\"nvSenha\"></td></tr> <tr> <td>Redigite a Nova Senha</td> <td><input type=\"password\" name=\"nvSenha\"></td> </tr> <tr> <td colspan=\"2\"><button type=\"onsubmit\" name=\"mudar\">Mudar</button> <button type=\"reset\" name=\"limpar\">Limpar</button></td></tr> </table> </form>";
    return false;
}

function dConta()
{
    document.getElementById("configCont").innerHTML = "";
    return false;
}
