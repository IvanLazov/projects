<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageThree</title>
</head>
<body>

    <h2>pageThree.jsp</h2>

    <%
        if ((Boolean)session.getAttribute("option") == false) {
            out.println("<p>This is your first visit.</p>");
        }
    %>

</body>
</html>