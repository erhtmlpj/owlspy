/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Aparicio
 */
public class NewServlet extends HttpServlet {

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
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewServlet at " + request.getContextPath() + "</h1>");
            
            
            Socket s = null;
            ObjectInputStream ois = null;
            JLabel l = new JLabel();
            JWindow win = new JWindow();
            ImageIcon icon = new ImageIcon();

            s = new Socket("127.0.0.1", 2020);
            s.getOutputStream();
            ois = new ObjectInputStream(s.getInputStream());
            l.setIcon(icon);
            BufferedImage i = null;
        try {
            icon = (ImageIcon) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

                icon.setImage(icon.getImage().getScaledInstance(900, 800, i.SCALE_FAST));

                BufferedImage bi = new BufferedImage(
                        icon.getIconWidth(),
                        icon.getIconHeight(),
                        BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.createGraphics();
                // paint the Icon to the BufferedImage.
                icon.paintIcon(null, g, 0, 0);
                g.dispose();

                BufferedImage bImage = bi;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "jpg", baos);
                baos.flush();
                byte[] imageInByteArray = baos.toByteArray();
                baos.close();
                String b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
            
            out.println("<img src='data:image/jpg;base64, "+b64+"' alt='Visruth.jpg not found' />");
            
            out.println("</body>");
            out.println("</html>");
            while(true)
            {
                try {
            icon = (ImageIcon) ois.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

                icon.setImage(icon.getImage().getScaledInstance(900, 800, i.SCALE_FAST));

                bi = new BufferedImage(
                        icon.getIconWidth(),
                        icon.getIconHeight(),
                        BufferedImage.TYPE_INT_RGB);
                g = bi.createGraphics();
                // paint the Icon to the BufferedImage.
                icon.paintIcon(null, g, 0, 0);
                g.dispose();

                bImage = bi;
                 baos = new ByteArrayOutputStream();
                ImageIO.write(bImage, "jpg", baos);
                baos.flush();
                imageInByteArray = baos.toByteArray();
                baos.close();
                b64 = javax.xml.bind.DatatypeConverter.printBase64Binary(imageInByteArray);
            
            }
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
        processRequest(request, response);
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
