<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%! List<String> pageLinks = new ArrayList<String>(); %>

<head>
    <title>PageRedirect</title>
</head>
<body>

    <%
        if (!pageLinks.contains(request.getParameter("option"))) {
            pageLinks.add(request.getParameter("option").toString());
            session.setAttribute("option", false);
        } else {
            session.setAttribute("option", true);
        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(request.getParameter("option").toString());
        requestDispatcher.forward(request, response);
    %>

</body>
</html>