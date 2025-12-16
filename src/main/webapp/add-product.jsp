<%--
  Created by IntelliJ IDEA.
  User: saiss
  Date: 12/16/2025
  Time: 9:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un produit</title>

    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Ajouter un produit</h2>


<nav>
    <a href="index.jsp">Accueil</a> |
    <a href="products">Liste des produits</a> |
    <a href="cart">Panier</a>
</nav>

<hr>


<form method="post" action="products">


    <label>Nom du produit :</label><br>
    <input type="text" name="name" required>
    <br><br>


    <label>Prix du produit :</label><br>
    <input type="number" name="price" step="0.01" min="0" required>
    <br><br>


    <button type="submit">Ajouter</button>

</form>

</body>
</html>

