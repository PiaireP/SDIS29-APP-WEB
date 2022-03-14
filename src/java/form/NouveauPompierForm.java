/*
 * NouveauClientForm.java
 */
package form;


//import com.mysql.cj.util.StringUtils;
import bean.Pompier;
import bdd.PompierMysql;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 *
 * @author domin
 */
public class NouveauPompierForm {
    
    String message="";
    
    
    
    public int verifNouveauPompier(HttpServletRequest request, int caserne) {        
        System.out.println("CONTROLE FAILLE");
        // Contrôle car "<" dans les zones de texte
        //String [] lesSaisies = request.getParameterValues(noRueString); // Valeurs saisies
        Enumeration lesNoms = request.getParameterNames();        
        int erreur = 0;      
        while (erreur ==0 && lesNoms.hasMoreElements()) {
            Object paramObjet=lesNoms.nextElement();
            String param=(String)paramObjet;
            String value=request.getParameter(param);
            if (value.contains("<")) {
                message = "Veullez recommencer votre saisie, une anomalie sur une zone de saisie a été détectée ";
                erreur=1;
            }            
        }     
        if (erreur > 0) return -1;        
        System.out.println("CREATION POMPIER");
        System.out.println(caserne);
//        Creation d'un objet de type Client avec les données transmises
        Pompier NouveauPompier = new Pompier (caserne,
                                        request.getParameter("newNom"),
                                        request.getParameter("newPrenom"),
                                        Integer.parseInt(request.getParameter("newStatut")),
                                        Integer.parseInt(request.getParameter("newTypePers")),
                                        request.getParameter("newMail"),
                                        request.getParameter("newLogin"),
                                        request.getParameter("password"),
                                        request.getParameter("newAdresse"),
                                        request.getParameter("newCP"),
                                        request.getParameter("newVille"),
                                        request.getParameter("newBip"),
                                        Integer.parseInt(request.getParameter("newGrade")));
        System.out.println(NouveauPompier);
        PompierMysql cm = new PompierMysql();
        System.out.println("1");
        int idPompier = cm.createRP(NouveauPompier);   // Requête préparée
        System.out.println("2");
        if (idPompier == -1) {
            message = "Erreur lors de la création du client";
        }
        return idPompier;      
        
    }

    public String getMessage() {
        return message;
    }
}


