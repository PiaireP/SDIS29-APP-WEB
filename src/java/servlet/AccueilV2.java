package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bdd.PompierMysql;
import bean.Pompier;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author frederic.duhin
 */
public class AccueilV2 extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccueilV2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccueilV2 at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
       HttpSession maSession = request.getSession();
       maSession.removeAttribute("leConnecter");
       maSession.removeAttribute("lesPompiers");
       maSession.removeAttribute("lesDates");
       maSession.removeAttribute("lesDatesEnString");
       maSession.removeAttribute("lesPeriodes");
       maSession.removeAttribute("lesVentilInit");
       maSession.removeAttribute("lesCouleurs");
       getServletContext().getRequestDispatcher("/WEB-INF/accueilJSP.jsp").forward(request, response);
       
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
                // Création de l'objet leControle de type AuthentifForm
                HttpSession maSession = request.getSession();
       maSession.removeAttribute("leConnecter");
       maSession.removeAttribute("lesPompiers");
       maSession.removeAttribute("lesDates");
       maSession.removeAttribute("lesDatesEnString");
       maSession.removeAttribute("lesPeriodes");
       maSession.removeAttribute("lesVentilInit");
       maSession.removeAttribute("lesCouleurs");
         Pompier lePompier = new Pompier();
         PompierMysql pm = new PompierMysql();
         lePompier = pm.controlerPompier(request.getParameter("ztPseudo"), request.getParameter("ztMDP"));
         System.out.println(lePompier);
        if(lePompier != null) {
        if (lePompier.getStatut() == 1) {   
            maSession.setAttribute("lePompierCo", lePompier);
            getServletContext().getRequestDispatcher("/WEB-INF/profilPompierJSP.jsp").forward(request, response);            
        } else if (lePompier.getStatut() == 2){
            System.out.println(lePompier);
            maSession.setAttribute("lePompierCo", lePompier);
            maSession.setAttribute("lesPompiers", pm.readAll(lePompier.getIdCaserne()));
            getServletContext().getRequestDispatcher("/WEB-INF/listePompierJSP.jsp").forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/accueilJSP.jsp").forward(request, response);
        }} else {
            getServletContext().getRequestDispatcher("/WEB-INF/accueilJSP.jsp").forward(request, response);
         }
        
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
