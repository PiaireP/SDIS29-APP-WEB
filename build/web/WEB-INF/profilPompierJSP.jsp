<%-- 
    Document   : profilPompierJSP
    Created on : 18 oct. 2021, 11:22:32
    Author     : frederic.duhin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Feuille de style bootstrap -->
                
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
                <link rel="stylesheet" href="CSS/CSSPompier.css">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>ProfilPompier</title>
    </head>
    <body>
        

		<div class="navbar navbar-expand-sm fixed-top" id="navbar"><!-- Permet au contenue de navbar d'être en block et que celle-ci soit fixe -->
  			<a href="AccueilV2">Accueil</a>
                        <a href="ProfilPompier"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>Mon Profil</a>
                        
                        <a href="affectation"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calendar" viewBox="0 0 16 16">
                        <path d="M3.5 0a.5.5 0 0 1 .5.5V1h8V.5a.5.5 0 0 1 1 0V1h1a2 2 0 0 1 2 2v11a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V3a2 2 0 0 1 2-2h1V.5a.5.5 0 0 1 .5-.5zM1 4v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V4H1z"/>
                        </svg> Emploi du temps</a>
		</div>
            
            <!-- Fin navbar -->
            
            
    <div class="container">
        
            <section class="profil text-center">

                <div id="divPhotoProfil" class="text-left">
                <p id="photoProfil" class="text-center">Photo</p>
                </div>
                
                <div id="divLogo" >
                    <img src="Image/logo-sdis.png" alt="Logo SDIS"/>
                </div>

                <div id="profilGlobal" style="display:block">
                    <h4 id="caserneProfil">Caserne : <input type="text" id="inputCaserne" value="${sessionScope.lePompierCo.getIdCaserne()}" disabled></h4> 
                <h4 id="nomProfil">Nom: <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getNom()}" disabled></h4>
                <h4 id="prenomProfil">Prenom : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getPrenom()}" disabled></h4>
                <h4 id="statutProfil">Statut : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getStatut()}" disabled></h4>
                <h4 id="mailProfil">Mail : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getMail()}" disabled></h4>
                <h4 id="adresseProfil">Adresse : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getAdresse()}" disabled></h4>
                <h4 id="villeProfil">Ville : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getVille()}" disabled></h4>
                <h4 id="gradeProfil">Grade : <input id="inputGrade" type="text" value="${sessionScope.lePompierCo.getGrade()}" disabled></h4>
                <button id="btModifProfil" onclick="maFunction(), functionModifProfil()" style="display: ">Modifier</button> <button type="submit" id="btValidModifProfil" onclick="maFunction(), functionValiderProfil()" style="display:none;">Valider</button>
                </div>
            </section>
    </div>
           <script src="JS/JSPompier.js" language="javascript"></script> 
         
       
    </body>
</html>
