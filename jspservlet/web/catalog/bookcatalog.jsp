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

        <table id="catalogTable">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Released</th>
            </tr>

            <test:for books="${books}" book="book" currentPage="${currentPage}" range="${range}" lastPage="${lastPage}">
                <tr id="innerTr">
                    <td>${book.bookId}.</td>
                    <td>${book.title}</td>
                    <td>${book.author}</td>
                    <td>${book.released}</td>
                </tr>
            </test:for>

        </table>

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