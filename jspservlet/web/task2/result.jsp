<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
<body>

    <%
        if (request.getAttribute("pageName") == null) {
            out.println("<h2>No page was selected</h2>");
        } else {
            out.println("<h2>You came from: " + request.getAttribute("pageName").toString() + "</h2>");
        }
    %>

</body>
</html>