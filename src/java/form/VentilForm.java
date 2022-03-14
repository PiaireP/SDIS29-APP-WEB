/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import bdd.VentilMySQL;
import bean.Ventil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author frederic.duhin
 */
public class VentilForm {

    public void verifVentil(HttpServletRequest request) {
        // a. Récupérer la collection des ventilations
        HttpSession maSession = request.getSession();
        ArrayList<Ventil> lesVentil
                = (ArrayList<Ventil>) maSession.getAttribute("lesVentilInit");
        System.out.println("Array list des ventil" + lesVentil);
        // b. Créer un objet de type VentilMySQL
        VentilMySQL vm = new VentilMySQL();

        // c. Récupérer les données du formulaire
        Map<String, String[]> map = request.getParameterMap();
        String[] lesNvVentil = map.get("lesActivites");
        String[] lesNvCheck = map.get("zCheck");
        ArrayList<Integer> lesNvCheckN = new ArrayList<>();
        if (lesNvCheck != null) {
            for (String unCheck : lesNvCheck) {
                lesNvCheckN.add(Integer.parseInt(unCheck));
            }
        }

        System.out.println("la map :" + map);
        System.out.println("lesNvVentil : " + lesNvVentil);

        // d. Initialiser le compteur de boucle
        int i = 0;

        // e. Mise à jour des activités des salariés
        for (Ventil uneVentil : lesVentil) {
            int oldAct = uneVentil.getActivite();
            int newAct = Integer.parseInt(lesNvVentil[i]);
            int oldCheck = uneVentil.getGarde();
            int newCheck = lesNvCheckN.contains(i + 1) ? 1 : 0;
            if (oldAct != newAct || oldCheck != newCheck) {
                if (uneVentil.isInBD()) {
                    if (newAct == 0) {
                        vm.delete(uneVentil);
                        uneVentil.setIsInBD(false);
                        uneVentil.setActivite(newAct);
                    } else {
                        uneVentil.setGarde(newCheck);
                        uneVentil.setActivite(newAct);
                        vm.update(uneVentil);
                        System.out.println("New check de update" + newCheck);
                    }
                } else {
                    uneVentil.setGarde(newCheck);
                    uneVentil.setActivite(newAct);
                    uneVentil.setIsInBD(true);
                    vm.create(uneVentil);
                    System.out.println("New check de create" + newCheck);
                    System.out.println(vm.create(uneVentil));
                }
            }


            /*if (oldCheck != newCheck) {
                uneVentil.setGarde(newCheck);
                if (uneVentil.isInBD()) {
                    vm.update(uneVentil);
                    System.out.println(newCheck);
                    System.out.println(vm.update(uneVentil));
                } else {
                    vm.create(uneVentil);
                    uneVentil.setIsInBD(true);
                }
            }*/
            i++;
        }
    }
}
