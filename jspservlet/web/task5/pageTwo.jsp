<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageTwo</title>
</head>
<body>

    <%
        if ((Boolean)session.getAttribute("option") == false)
        {
            out.println("<h3>This is your first visit!</h3>");
        } else {
            out.println("<h3>This page has already been visited!</h3>");
        }
    %>

</body>
</html>