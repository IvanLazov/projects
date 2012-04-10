<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="tag" uri="/WEB-INF/taglibrary.tld" %>

<%!
    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
%>

<html>
<head>
    <title>Book Catalog - Comments</title>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/catalog/css/styleTwo.css"/>
</head>
<body>

    <div id="book">
        <table>
            <tr>
                <td>Book:</td>
                <td>${book.title}</td>
            </tr>
            <tr>
                <td>Description:</td>
                <td>${book.description}</td>
            </tr>
        </table>
    </div>

    <div id="commentList">
        <table>
            <tag:commentsRenderer comments="${comments}" comment="comment">
                <div id="comment">
                    <br/><span>${comment.comment}</span><br/>
                    <span id="userName">${comment.userName}</span>
                </div>
            </tag:commentsRenderer>
        </table>
    </div>

    <div id="commentForm">
        <form action="<%=getPath()%>/addCommentServlet?bookId=${book.bookId}" method="post">

            Username:<br/>
            <input type="text" name="username" /><br/>

            Comment:<br/>
            <textarea rows="5" cols="50" name="comment">Leave comment for this book...</textarea>

            <input type="submit" value="Comment"/>
        </form>
    </div>

    <div id="goBack">
        <a href="<%=getPath()%>/catalog/bookcatalog.jsp"> << </a>
    </div>

</body>
</html>