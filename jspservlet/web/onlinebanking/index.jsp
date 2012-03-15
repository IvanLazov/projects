<%@ page import="com.clouway.jspservlet.onlinebanking.persistance.DatabaseHelper" %>
<%@ page import="com.clouway.jspservlet.onlinebanking.persistance.DatabaseService" %>
<%@ page import="com.clouway.jspservlet.onlinebanking.persistance.DatabaseServiceImpl" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("userName") == null) {
        response.sendRedirect("login.jsp");
    }
%>

<%!
    DatabaseHelper databaseHelper = new DatabaseHelper();
    DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
%>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>

    <!-- Deposit / Withdraw  Form -->
    <div id="form">
        <p id="centerBold">Bank Account</p>

        <form action="../deposit" method="post">
            <table>
                <tr>
                    <td>Active Users: </td>
                    <td><%= databaseService.getNumberOfLoggedUsers() %></td>
                </tr>
                <tr>
                    <td>User: </td>
                    <td><%= session.getAttribute("userName") %></td>
                </tr>
                <tr>
                    <td>Balance: </td>
                    <td><%= databaseService.getBalance(session.getAttribute("userName").toString()) %></td>
                </tr>
                <tr>
                    <td>Enter sum:</td>
                    <td colspan="2"><input type="text" name="sum" /></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="deposit" value="Deposit" /></td>
                    <td><input type="submit" name="withdraw" value="Withdraw" /></td>
                </tr>
            </table>
        </form>
    </div>

    <!-- Logout Form -->
    <div id="logoutForm">
        <form action="../logout" method="post">
            <td><input type="submit" name="logout" value="Logout"/></td>
        </form>
    </div>

</body>
</html>