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
    <title>Register Page</title>
</head>
<body>

    <!-- Register Form -->
    <div id="form">
        <p id="centerBold">Register Form</p>
        <form action="../register" method="post">
            <table>
                <tr>
                    <td>Username: </td>
                    <td><input type="text" name="userName" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
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

    <div id="error">
        <%= request.getParameter("error") == null ? "" : request.getParameter("error")%>
    </div>

</body>
</html>