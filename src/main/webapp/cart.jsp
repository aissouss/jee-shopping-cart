<%--
  Created by IntelliJ IDEA.
  User: saiss
  Date: 12/16/2025
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Panier</title>

    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Votre panier</h2>


<nav>
    <a href="index.jsp">Accueil</a> |
    <a href="products">Liste des produits</a> |
    <a href="add-product.jsp">Ajouter un produit</a>
</nav>

<hr>


<c:if test="${empty items}">
    <p>Votre panier est vide.</p>
</c:if>


<c:if test="${not empty items}">
    <table border="1" cellpadding="8">
        <tr>
            <th>Produit</th>
            <th>Prix</th>
            <th>Quantité</th>
            <th>Sous-total</th>
            <th>Action</th>
        </tr>


        <c:forEach var="item" items="${items}">
            <tr>
                <td>${item.product.name}</td>
                <td>${item.product.price}</td>
                <td>${item.quantity}</td>
                <td>${item.subTotal}</td>
                <td>
                    <a href="remove-from-cart?id=${item.product.id}">
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <br>


    <strong>Total : ${total}</strong>
</c:if>

</body>
</html>

