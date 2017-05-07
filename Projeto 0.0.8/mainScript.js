var isLogged = true;
if(isLogged)
{
    document.write("<aside>");
    document.write("<ul>");
    document.write("<li><a href=\"administracao.html\">Administracao</a></li>");
    document.write("<li><a href=\"logout.html\">Logout</a></li>");
    document.write("<li><a href=\"conta.html\">Minha Conta</a></li>");
    document.write("<ul>");
    document.write("</aside>");
}

function mSenha()
{
    document.getElementById("configCont").innerHTML = "<form> <table> <tr> <td>Antiga Senha</td> <td><input type=\"password\" name=\"antSenha\"></td> </tr> <tr> <td>Nova Senha   </td> <td><input type=\"password\" name=\"nvSenha\"></td></tr> <tr> <td>Redigite a Nova Senha</td> <td><input type=\"password\" name=\"nvSenha\"></td> </tr> <tr> <td colspan=\"2\"><button type=\"onsubmit\" name=\"mudar\">Mudar</button> <button type=\"reset\" name=\"limpar\">Limpar</button></td></tr> </table> </form>";
    return false;
}

function dConta()
{
    document.getElementById("configCont").innerHTML = "Deseja realmente apagar sua conta?<br><form><button name=\"simaConta\">Sim</button>  <button name=\"naoaConta\">Não</button></form>";
    return false;
}

function fPass()
{
    var email = prompt("Digite o seu e-mail");
    var pos = email.indexOf("@");
    if(!email==""&&pos!=-1){
    alert("um email com as instruções de recuperação de conta foi enviado para a sua caixa de mensagens")
    }
    else
    {
    alert("Você precisa digitar um email valido");
    }
}
