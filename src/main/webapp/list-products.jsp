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
    <title>Liste des produits</title>

    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<h2>Liste des produits</h2>

<nav>
    <a href="index.jsp">Accueil</a> |
    <a href="add-product.jsp">Ajouter un produit</a> |
    <a href="cart">Panier</a>
</nav>

<hr>

<c:if test="${empty products}">
    <p>Aucun produit disponible.</p>
</c:if>


<c:if test="${not empty products}">
    <table border="1" cellpadding="8">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prix</th>
            <th>Actions</th>
        </tr>


        <c:forEach var="p" items="${products}">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td>

                    <a href="cart?action=add&id=${p.id}">
                        Ajouter au panier
                    </a>
                    |

                    <a href="products?action=delete&id=${p.id}">
                        Supprimer
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
