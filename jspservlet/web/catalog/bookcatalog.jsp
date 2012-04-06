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
            <test:for books="${books}" book="book" currentPage="${currentPage}" range="${range}" lastPage="${lastPage}">
                <li>${book.title} .::. Author:${book.author} .::. ${book.released}</li>
            </test:for>
        </ul>
        
        <div id="paging">
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=1&lastPage=${lastPage}&range=${range}"> << </a>
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=${currentPage - 1}&lastPage=${lastPage}&range=${range}"> < </a>
            <span><b>${currentPage}</b></span>
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=${currentPage + 1}&lastPage=${lastPage}&range=${range}"> > </a>
            <a href="<%=getPath()%>/pageChangerServlet?currentPage=${lastPage}&lastPage=${lastPage}&range=${range}"> >> </a>
        </div>
    </div>

</body>
</html>