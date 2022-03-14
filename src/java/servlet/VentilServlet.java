/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import util.TrmtDate;
import bean.Pompier;
import bdd.VentilMySQL;
import bean.Ventil;
import bdd.VentilMySQL;
import form.VentilForm;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author sio
 */
public class VentilServlet extends HttpServlet {

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
            out.println("<title>Servlet VentilServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet VentilServlet at " + request.getContextPath() + "</h1>");
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
        Pompier lePompier = null;
        HttpSession maSession = request.getSession();
        
        
        if (maSession.getAttribute("lesVentilInit") == null) {
                
            
        
        /* Initialisations des dates de la semaine */
        Calendar [] lesDates = new Calendar[7];
        String [] lesDatesEnString = new String[7];
        lesDates[0] = TrmtDate.getDateDebutSemaine();
        lesDatesEnString[0] = TrmtDate.getDateAAfficher(lesDates[0]);
        for (int i = 1; i< lesDates.length; i++) {
            lesDates[i] = TrmtDate.addDays(lesDates[0], i);
            lesDatesEnString[i] = TrmtDate.getDateAAfficher(lesDates[i]);
        }
        request.getSession();
        maSession.setAttribute("lesDates", lesDates);
        maSession.setAttribute("lesDatesEnString", lesDatesEnString);
        //System.out.println("lesDates "+ lesDates[4].getTime());
            System.out.println(lesDatesEnString[1]);
        
        /* Initialisation des périodes */
        String [] lesPeriodes = {"Nuit", "Matin", "Après-midi", "Soirée"};
        maSession.setAttribute("lesPeriodes", lesPeriodes);
        
        /* Recherche des ventilations */
        VentilMySQL vm = new VentilMySQL();
        lePompier = (Pompier) maSession.getAttribute("lePompierCo");
        ArrayList <Ventil> lesVentilInit = vm.getLesVentil(lesDates, lesPeriodes, lePompier.getIdCaserne(), lePompier.getStatut(), lePompier.getId());
        //System.out.println("lesVentilInit : " + lesVentilInit);
        ArrayList <Integer> lesChecks = vm.getLesChecks();
        maSession.setAttribute("lesVentilInit", lesVentilInit);
        
        /* Initialisation des couleurs */
        String [] lesCouleurs = {"gris", "jaune", "vert"};
        maSession.setAttribute("lesCouleurs", lesCouleurs);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/ventilJSP.jsp").forward(request, response);
        /* Affichage de la page de ventilation */
    
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
        // a. créer un objet de type VentilForm
        HttpSession maSession = request.getSession();
        VentilForm vf = new VentilForm();     

        // c. afficher le menu 
        Pompier lePompier = (Pompier) maSession.getAttribute("lePompierCo");
        if (lePompier.getStatut() == 2) {
            vf.verifVentil(request);
            System.out.println("chef");
            getServletContext().getRequestDispatcher("/WEB-INF/profilChefDeCaserneJSP.jsp").forward(request, response);
        } else { 
            vf.verifVentil(request);
            System.out.println("pompier");
            getServletContext().getRequestDispatcher("/WEB-INF/profilPompierJSP.jsp").forward(request, response);
            // b. Appeler verifVentil
           
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