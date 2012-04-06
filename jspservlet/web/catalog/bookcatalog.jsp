<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="test" uri="/WEB-INF/taglibrary.tld" %>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/catalog/style.css">
    <title>Book Catalog</title>    
</head>
<body>

    <div id="catalog">

        <ul>
            <test:for books="${books}" bookName="bookName" currentPage="${currentPage}" range="${range}" lastPage="20">
                <li>${bookName}</li>
            </test:for>
        </ul>
        
        <div id="paging">
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=1&range=${range}"> << </a>
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=${currentPage - 1}&range=${range}"> < </a>
            <span><b>${currentPage}</b></span>
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=${currentPage + 1}&range=${range}"> > </a>
            <a href=""> >> </a>
        </div>
    </div>

</body>
</html>