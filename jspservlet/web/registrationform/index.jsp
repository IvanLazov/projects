<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%!
    Map<String, String> errorMessages = null;
    Map<String, String> fieldToValues = null;
%>

<%
    if (session.getAttribute("errors") == null) {
        errorMessages = new HashMap<String, String>();
        fieldToValues = new HashMap<String, String>();
    } else {
        errorMessages = (Map<String, String>) session.getAttribute("errors");
        fieldToValues = (Map<String, String>) session.getAttribute("fieldToValues");
    }
%>

<%!
    private String getValue(String fieldName, Map<String, String> map) {
        if (map.get(fieldName) == null) {
            return "";
        } else {
            return map.get(fieldName);
        }
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
            <table>
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" value="<%= getValue("firstName", fieldToValues) %>" /></td>
                    <td class="error"><%= getValue("firstName", errorMessages) %></td>
                </tr>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" value="<%= getValue("lastName", fieldToValues) %>" /></td>
                    <td class="error"><%= getValue("lastName", errorMessages) %></td>
                <tr>
                    <td>EGN: </td>
                    <td><input type="text" name="egn" value="<%= getValue("egn", fieldToValues) %>" /></td>
                    <td class="error"><%= getValue("egn", errorMessages) %></td>
                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" value="<%= getValue("age", fieldToValues) %>" /></td>
                    <td class="error"><%= getValue("age", errorMessages) %></td>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" value="<%= getValue("address", fieldToValues) %>" /></td>
                    <td class="error"><%= getValue("address", errorMessages) %></td>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" /></td>
                    <td class="error"><%= getValue("password", errorMessages) %></td>
                <tr>
                    <td>Confirm Password: </td>
                    <td><input type="password" name="confirmPassword" /></td>
                    <td class="error"><%= getValue("confirmPassword", errorMessages) %></td>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>