<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("userName") != null) {
        response.sendRedirect("home.jsp");
        return;
    }
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Login Page</title>
</head>
<body>

    <!-- Login Form -->
    <div class="form">
        <p id="centerBold">Login Form</p>
        <form action="../login" method="post">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="userName" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><a href="register.jsp">Create a new account</a></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>