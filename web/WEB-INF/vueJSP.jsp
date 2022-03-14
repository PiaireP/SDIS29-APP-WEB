<%-- 
    Document   : listeClientsJSP
    Created on : 16 sept. 2021, 16:35:04
    Author     : frederic.duhin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="CSS/CSSVue.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des pompiers</title>
    </head>
    
    <body>
       <div class="navbar navbar-expand-sm fixed-top" id="navbar"><!-- Permet au contenue de navbar d'être en block et que celle-ci soit fixe -->
  			<a href="AccueilV2" >Accueil</a>
                        
                        <a href="ProfilChefDeCaserne"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                        <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        </svg>Mon Profil</a>
                        
                        <a href="NouveauServlet"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-plus-fill" viewBox="0 0 16 16">
                        <path d="M1 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                        <path fill-rule="evenodd" d="M13.5 5a.5.5 0 0 1 .5.5V7h1.5a.5.5 0 0 1 0 1H14v1.5a.5.5 0 0 1-1 0V8h-1.5a.5.5 0 0 1 0-1H13V5.5a.5.5 0 0 1 .5-.5z"/>
                        </svg>Création d'un nouveau pompier</a>
        </div>
        
        <h2>Liste des pompiers</h2>   
        <span> Voir Profil :</span>
        <form action="VueServlet" method="POST">
        <select id="selectP" name="selectP">
            <c:forEach items="${lesPompiers}" var="unPompier">
                <option name="viewList" value=<c:out value="${unPompier.getId()}"/> > <c:out value="${unPompier.getNom()}"/> <c:out value="${unPompier.getPrenom()}"/></option>
            </c:forEach>
        </select>
            <button type="submit">Valider</button>
                </form>
        <br>
        <br>
        <label>ID : </label><input value=<c:out value="${sessionScope.pompierSelect.getId()} "/> >
        <label>Nom : </label><input value=<c:out value="${sessionScope.pompierSelect.getNom()} "/> >
        <label>Prenom : </label><input value=<c:out value="${sessionScope.pompierSelect.getPrenom()} "/>>
        <label>Grade : </label><input value=<c:out value="${sessionScope.pompierSelect.getGrade()} "/> >
        <label>Statut : </label><input value=<c:out value="${sessionScope.pompierSelect.getStatut()} "/> >
        <label>Mail : </label><input value=<c:out value="${sessionScope.pompierSelect.getMdp()} "/> >
        <label>Adresse : </label><input value=<c:out value="${sessionScope.pompierSelect.getAdresse()} "/> >
        <label>Ville: </label><input value=<c:out value="${sessionScope.pompierSelect.getVille()} "/> >
        <label>Code Postal : </label><input value=<c:out value="${sessionScope.pompierSelect.getCp()} "/> >
        
        
    </body>
    
</html>
