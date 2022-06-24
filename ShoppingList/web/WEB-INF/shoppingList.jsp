<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="login?logout">Logout</a></p>
        
        <h2>List</h2>
        <form>
            <label>Add item </label>
            <input type="text" name="item" value="">
            <input type="submit" value="Add">
        </form>
    </body>
</html>
