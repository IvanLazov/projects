<%@ page import="com.clouway.jspservlet.onlinebanking.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<html>
<head>
    <title>Home Page</title>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/onlinebanking/style.css"/>
</head>
<body>

<!-- Deposit / Withdraw  Form -->
<div id="form">
    <p id="centerBold">Bank Account</p>

    <form action="<%=getPath()%>/deposit" method="post">
        <table>
            <tr>
                <td>User:</td>
                <td><%= ((User) request.getSession().getAttribute("user")).getUserName() %></td>
            </tr>
            <tr>
                <td>Balance:</td>
                <%--<td><%= request.getAttribute("userBalance") %> $</td>--%>
                <td><%= request.getSession().getAttribute("userBalance") %></td>
            </tr>
            <tr>
                <td>Enter amount:</td>
                <td colspan="2"><input type="text" name="amount"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" name="deposit" value="Deposit"/></td>
                <td><input type="submit" name="withdraw" value="Withdraw"/></td>
            </tr>
        </table>
    </form>
</div>

<!-- Logout Form -->
<div id="info">
    <form action="<%=getPath()%>/logout" method="post">
        <input type="submit" name="logout" value="Logout"/>
    </form>
</div>

<%-- Error --%>
<div id="error">
    <%= request.getSession().getAttribute("error") == null ? "" : request.getSession().getAttribute("error") %>
</div>

</body>
</html>