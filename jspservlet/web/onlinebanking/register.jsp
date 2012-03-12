<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css" />
    <title>Register Page</title>

    <%
        if (session.getAttribute("userName") != null) {
            response.sendRedirect("home.jsp");
        }
    %>

</head>
<body>
    <!-- Register Form -->
    <div class="form">
        <p id="centerBold">Register Form</p>
        <form action="../register" method="post">
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
                    <td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>