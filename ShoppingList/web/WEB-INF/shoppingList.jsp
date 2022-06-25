<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="" action="logout">Logout</a></p>
        
        <h2>List</h2>
        <form action="ShoppingList" method="post">
            <label>Add item :</label>
            <input type="text" name="item" value="">
            <input type="submit" name= "action" value="add">
        </form>
        
        
            <form action="ShoppingList" method="post">
            <c:forEach items="${items}" var="item">
                <p>
                    <input type="radio" name="item" value="${item}">
                    ${item}
                </p>       
            </c:forEach>
            <c:if test="${items.size()>0}">
            <input type="submit" name="action" value="delete">
            </c:if>
        </form>
        
    </body>
</html>
