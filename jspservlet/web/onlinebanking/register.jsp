<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<%
    if (session.getAttribute("userName") != null) {
        response.sendRedirect("index.jsp");
        return;
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
        </table>
    </form>
</div>

<div id="error">
    <%= request.getAttribute("error") == null ? "" : request.getAttribute("error") %>
</div>

</body>
</html>