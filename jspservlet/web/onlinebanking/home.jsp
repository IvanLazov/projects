<%@ page import="com.clouway.jspservlet.onlinebanking.DatabaseHelper" %>
<%@ page import="com.clouway.jspservlet.onlinebanking.DatabaseService" %>
<%@ page import="com.clouway.jspservlet.onlinebanking.DatabaseServiceImpl" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="style.css" />

    <%
        if (session.getAttribute("userName") == null) {
            response.sendRedirect("login.jsp");
        }
    %>

    <%!
        DatabaseHelper databaseHelper = new DatabaseHelper();
        DatabaseService databaseService = new DatabaseServiceImpl(databaseHelper);
    %>

</head>
<body>

    <!-- Deposit / Withdraw  Form -->
    <div class="form">
        <p id="centerBold">Bank Account</p>

        <form action="../deposit" method="post">
            <table>
                <tr class="bottomMargin">
                    <td>Active Users:</td>
                    <td><%= databaseService.numberOfLoggedUsers() %></td>
                </tr>
                <tr class="bottomMargin">
                    <td>User: </td>
                    <td><%= session.getAttribute("userName").toString() %></td>
                </tr>
                <tr class="bottomMargin">
                    <td>Balance: </td>
                    <td><%= databaseService.getBalance(session.getAttribute("userName").toString()) %></td>
                </tr>
                <tr class="bottomMargin">
                    <td>Enter sum:</td>
                    <td colspan="2"><input type="text" name="sum" /></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
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