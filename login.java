/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aparicio
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        request.getRequestDispatcher("Administracao.jsp").include(request, response);

        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        
        DAOConta daoconta = new DAOConta();
        DAOUsuario daousuario = new DAOUsuario();

        Conta conta = new Conta();
        Conta conta2 = new Conta();
        Usuario usuario = new Usuario();
        Usuario usuario2 = new Usuario();

        conta.setLogin(login);
        conta2 = daoconta.pesquisa(conta);

        usuario.setEmail(conta2.getEmail());
        usuario2 = daousuario.pesquisa(usuario);
                
        RequestDispatcher disp;
        
        String lane = "Administracao.jsp";
        Boolean cLog = false;
        
        if(conta2.getLogin().equals("null"))
        {
            lane = "login.html";
            cLog = false;
        }

        if (senha.equals(usuario2.getSenha())) {
            HttpSession session = request.getSession();
            session.setAttribute("name", login);
            //getServletContext().setAttribute("nome", login);
            request.setAttribute("name",login);
            
            lane = "Administracao.jsp";
            cLog = true;
        } else {
            lane = "login.html";
            cLog = false;
        }
        if(cLog){
        disp = request.getRequestDispatcher(lane);
        disp.forward(request, response);
        }
        else
        {
            response.sendRedirect(lane);
        }
        out.close();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
