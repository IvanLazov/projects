<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    Map<String, String> errors = null;
%>

<%
    if (request.getAttribute("error") != null) {
        errors = (Map<String, String>) request.getAttribute("error");
    }
%>


<html>
<head>    
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

    <div id="registrationForm">
        <form action="../registration" method="post">
            <p id="centerBold">Registration Form</p>
            <table>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" /></td>
                    <td><%= errors.get("firstName") %></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" /></td>
                    <td><%= errors.get("lastName") %></td>
                </tr>
                <tr>
                    <td>EGN: </td>
                    <td><input type="text" name="egn" /></td>
                    <td><%= errors.get("egn") %></td>
                </tr>
                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" /></td>
                    <td><%= errors.get("age") %></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" /></td>
                    <td><%= errors.get("address") %></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" /></td>
                    <td><%= errors.get("password") %></td>
                </tr>
                <tr>
                    <td>Confirm Password: </td>
                    <td><input type="password" name="confirmPassword" /></td>
                    <td><%= errors.get("confirmPassword") %></td>
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