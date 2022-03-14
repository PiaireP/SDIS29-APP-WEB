<%--
    Document   : nouveauClientJSP
    Created on : 16 sept. 2021, 16:34:53
    Author     : frederic.duhin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/CSSNouveau.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'un nouveau pompier</title>
    </head>
    <body>
        <div class="navbar navbar-expand-sm fixed-top" id="navbar"><!-- Permet au contenue de navbar d'être en block et que celle-ci soit fixe -->
              <a href="AccueilV2">Accueil</a>
                        
                        <a href="ProfilChefDeCaserne"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>Mon Profil</a>
                        
                        <a href="ListeServlet"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-list" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z"/>
                        </svg>Liste des pompiers</a>
              
                        <a href="affectation"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard" viewBox="0 0 16 16">
                        <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                        <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                        </svg>Affectation</a>
                        
        </div>
        
        <!-- fin navbar -->
        <h2>Création d'un nouveau pompier</h2>
        <form method="post" action="NouveauServlet" >
            <span id="nom">Nom:</span>
                    <input type="text" name="newNom"/>
                    <br><br>
            <span id="prenom">Prenom:</span>
                    <input type="text" name="newPrenom" />
                    <br><br>
            <span id="statut">Statut</span>
            <select name="newStatut">
                <option value="1">Pompier</option>
                <option value="2">Chef</option>
                <option value="3">Alerte</option>
            </select>
                    <br><br>
            <select name="newTypePers">
                <option value="1">Pompier Pro</option>
                <option value="2">Pompier Volontaire</option>
            </select>
            <span id="grade">Grade:</span>
            <select name="newGrade">
                <option value="0">1</option>
                <option value="1">2</option>
                <option value="2">3</option>
                <option value="3">4</option>
                <option value="4">5</option>
                <option value="5">6</option>
                <option value="6">7</option>
                <option value="7">8</option>
                <option value="8">9</option>
                <option value="9">10</option>
                <option value="10">11</option>
                <option value="11">11</option>
            </select>
                    <br><br>
            
            <span id="mail">Mail:</span>
                    <input name="newMail" type="text"/>
                    <br><br>
            <span id="login">Login:</span>
                    <input name="newLogin" type="text"/>
                    <br><br>
            <span id="mdp">Mdp:</span>
                    <input name="password" type="password"/>
                    <br><br>
            <span id="adresse">Adresse:</span>
                    <input name="newAdresse" type="text"/>
                    <br><br>
            <span id="cp">Code Postal:</span>
                    <input name="newCP" type="text"/>
                    <br><br>
            <span id="ville">Ville:</span>
                    <input name="newVille" type="text"/>
                    <br><br>
            <span id="bip">Bip:</span>
                    <input name="newBip" type="text"/>
                    <br><br>
            
            <button type="submit" id="newSubmit">Enregistrer</button>          
        </form>
        
    </body>
</html>





