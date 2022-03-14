<%-- 
    Document   : affectationJSP
    Created on : 8 nov. 2021, 10:02:18
    Author     : domin
--%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="CSS/mycss.css" rel="stylesheet" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<section id="contenuAffiche">
    
    	<div class="navbar navbar-expand-sm fixed-top" id="navbar"><!-- Permet au contenue de navbar d'être en block et que celle-ci soit fixe -->
  		<a href="AccueilV2">Accueil</a>
                        
                        
                        <c:choose>
                            <c:when test="${sessionScope.lePompierCo.getStatut() == 1}">
                                
                            <a href="ProfilPompier"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
                            <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
                            </svg>Mon Profil</a>
                                
                            </c:when>
                            
                            <c:when test="${sessionScope.lePompierCo.getStatut() == 2}">
                                
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
                                
                            </c:when>
                            
                            <c:when test="${sessionScope.lePompierCo.getStatut() == 3}">
                            </c:when>
                        </c:choose>
                        
                        
	</div>
    <br>
    <br>
    <br>
            
            <!-- Fin navbar -->

    <form action="affectation" method="POST">
        
        <table class="table" id="table">
               <thead>
                   
                   <tr>
                       <div>
                            <th rowspan="2">No</th>
                            <th rowspan="2">Nom prénom</th>
                       </div>    
                        <c:forEach items="${sessionScope.lesDatesEnString}"
                                    var= "uneDate" varStatus="status">
                        
                        <th colspan="4" class="text-center" id="date">${uneDate}</th>
                        </c:forEach>
                        
                   </tr>
                   
                   <tr>
                       
                       <c:forEach var="i" begin="0" end="6" step="1">
                           <c:forEach items="${sessionScope.lesPeriodes}"
                                    var="unePeriode" varStatus="status">
                               
                        <th class="text-center cellulePeriode" id="periode">${unePeriode}</th>
                        
                           </c:forEach>          
                       </c:forEach>
                        
                   </tr>


               </thead>   

               <tbody>
                  <c:set var="oldId" value="-1" scope="page"/>
                  
                  <c:forEach items="${sessionScope.lesVentilInit}"
                                    var= "uneVentil" varStatus="status">
                  <c:set var="newId" value="${uneVentil.getPompier().getId()}" scope="page"/>
                  <c:if test="${oldId != newId}" var="test" scope="page">
                  <tr></tr><tr id="body">
                       <td>${uneVentil.getPompier().getId()}</td>
                       <td>${uneVentil.getPompier().getNom()}
                       ${uneVentil.getPompier().getPrenom()}</td>
                    
                    
                   <c:set var="oldId" value="${newId}" scope="page"/>
                   </c:if>
                   <c:set var="activite" value="${uneVentil.getActivite()}" scope="page"/>
                   <c:set var="check" value="" scope="page"/>
                                            <c:if test="${uneVentil.getGarde() == 1}" var="test" scope="page">
                                                <c:set var="check" value="checked" scope="page" />

                                            </c:if>
                         <c:choose>
                            <c:when test="${sessionScope.lePompierCo.getStatut() == 1}">
                            <td class="text-center"  id="celluleActivite">
                            <input type="text" value="${activite}" name="lesActivites" class="ztVentil ${sessionScope.lesCouleurs[activite]} id="cellule" readonly />
                            <input type="checkbox" ${check} name="zCheck" value="${ status.count }"/>
                            </td>
                            </c:when>
                            
                            <c:when test="${sessionScope.lePompierCo.getStatut() == 2}">
                                <td class="text-center" id="celluleActivite">
                            <input type="text" value="${activite}" name="lesActivites" class="ztVentil ${sessionScope.lesCouleurs[activite]}" id="activite" />
                            <input type="checkbox" ${check} id="checkbox" name="zCheck" value="${ status.count }"/>
                            </td>
                            </c:when>
                         </c:choose>    
                        
                        
                   </c:forEach>
                   </tr>
                    
               </tbody>
               
        </table>      <br>
                  <button type="submit" id="newSubmit">Valider</button> <br> <br>
                
        <span id="legendDisponible">Disponible</span>  <span id="legendTravail">Au travail</span>  <span id="legendIndisponible">Indisponible</span>
    </form>
 
                  
</section> <!-- /section id contenuAffiche -->     
<!-- Script pour emploiDuTempsPerso -->
<script src="JS/ventilJS.js"></script>

