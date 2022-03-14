<%--
    Document   : accueilJSP
    Created on : 16 sept. 2021, 16:42:48
    Author     : frederic.duhin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="CSS/Authentif.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <img src="Image/logo-sdis.png" alt="Logo SDIS"/>
        <fieldset>
            <legend>Authentification</legend>
            <form method="POST" action="AccueilV2">
                <input type="text" name="ztPseudo" placeholder="Pseudo" /><br />
                <input type="password" name="ztMDP" placeholder="Mot de passe" /><br /><br />
                <input type="submit" value="Valider" id="submit" />
            </form>
        </fieldset>
</html>

