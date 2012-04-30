<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/onlinebanking/style.css"/>
    <title>Register Page</title>
</head>
<body>

<!-- Register Form -->
<div id="form">
    <p id="centerBold">Register Form</p>

    <form action="<%=getPath()%>/register" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td></td>
                <td></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Register"/></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="<%=getPath()%>/onlinebanking/login.jsp">Go to login page</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="info">
<%
    if (request.getAttribute("login") != null) {
        out.println("<a href='onlinebanking/login.jsp'>Account created!<br />You can now login with your account</a>");
    }
%>
</div>

<div id="error">
    <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
</div>

</body>
</html>