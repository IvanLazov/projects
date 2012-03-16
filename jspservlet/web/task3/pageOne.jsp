<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PageOne</title>
</head>
<body>

    <form method="post" action="../redirectServletTwo">
        <table cellpadding="0" cellspacing="0" border="0">
            <tr>
                <td><input type="radio" name="option" value="pageTwo.jsp">pageTwo.jsp</td>
            </tr>
            <tr>
                <td><input type="radio" name="option" value="pageThree.jsp">pageThree.jsp</td>
            </tr>
            <tr>
                <td><input type="radio" name="option" value="pageFour.jsp">pageFour.jsp</td>
            </tr>
            <tr>
                <td><input type="submit" name="Submit"></td>
            </tr>
        </table>
    </form>

</body>
</html>