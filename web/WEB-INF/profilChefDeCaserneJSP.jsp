<%-- 
    Document   : profilChefDeCaserneJSP
    Created on : 19 oct. 2021, 09:29:00
    Author     : frederic.duhin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- Feuille de style bootstrap -->
                
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
                <link rel="stylesheet" href="CSS/CSSChefDeCaserne.css">
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <title>ProfilChefDeCaserne</title>
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
                        
                        <a href="NouveauServlet"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                        <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                        </svg> Création d'un nouveau pompier</a>
                        
                        <a href="affectation"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-clipboard" viewBox="0 0 16 16">
                        <path d="M4 1.5H3a2 2 0 0 0-2 2V14a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V3.5a2 2 0 0 0-2-2h-1v1h1a1 1 0 0 1 1 1V14a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1V3.5a1 1 0 0 1 1-1h1v-1z"/>
                        <path d="M9.5 1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-3a.5.5 0 0 1-.5-.5v-1a.5.5 0 0 1 .5-.5h3zm-3-1A1.5 1.5 0 0 0 5 1.5v1A1.5 1.5 0 0 0 6.5 4h3A1.5 1.5 0 0 0 11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3z"/>
                        </svg> Affectation</a>
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
                <h4 id="caserneProfil">Caserne : <input type="text" id="inputCaserne" value="${sessionScope.lePompierCo.getIdCaserne()}" disabled ></h4> 
                <h4 id="nomProfil">Nom: <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getNom()}" disabled ></h4>
                <h4 id="prenomProfil">Prenom : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getPrenom()}" disabled></h4>
                <h4 id="statutProfil">Statut : <input class="modifInput" type="text" disabled value="${sessionScope.lePompierCo.getStatut()}"></h4>
                <h4 id="mailProfil">Mail : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getMail()}" disabled></h4>
                <h4 id="adresseProfil">Adresse : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getAdresse()}" disabled></h4>
                <h4 id="villeProfil">Ville : <input class="modifInput" type="text" value="${sessionScope.lePompierCo.getVille()}" disabled ></h4>
                <h4 id="gradeProfil">Grade : <input id="inputGrade" type="text" value="${sessionScope.lePompierCo.getGrade()}" disabled></h4>
                <button id="btModifProfil" onclick="maFunction(), functionModifProfil()" style="display: ">Modifier</button> <button type="submit" id="btValidModifProfil" onclick="maFunction(), functionValiderProfil()" style="display:none;">Valider</button>
                </div>
            </section>
    </div>
           <script src="JS/JSPompier.js" language="javascript"></script> 
         
        
    </body>
</html>
