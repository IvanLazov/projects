<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (session.getAttribute("userName") != null) {
        response.sendRedirect("index.jsp");
    }
%>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/onlinebanking/style.css"/>
    <title>Login Page</title>
</head>
<body>

<div id="form">
    <p id="centerBold">Login Form</p>

    <form action="<%=getPath()%>/login" method="post">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="userName"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Login"/></td>
            </tr>
            <tr>
                <td></td>
                <td><a href="<%=getPath()%>/onlinebanking/register.jsp">Create a new account</a></td>
            </tr>
        </table>
    </form>
</div>

<div id="error">
    <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
</div>

</body>
</html>