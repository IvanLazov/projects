<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    session.setAttribute("sessionName", session.getId());
%>

<html>
<head>
    <title>Links</title>
</head>
<body>

    <a href="../counterServlet?link=link1" name="link">Click</a> : <%= session.getAttribute("link1") == null ? 0 : session.getAttribute("link1") %> <br/>
    <a href="../counterServlet?link=link2" name="link">Click</a> : <%= session.getAttribute("link2") == null ? 0 : session.getAttribute("link2") %> <br/>
    <a href="../counterServlet?link=link3" name="link">Click</a> : <%= session.getAttribute("link3") == null ? 0 : session.getAttribute("link3") %> <br/>

</body>
</html>