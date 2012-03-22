<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%!
    private Map<String, String> errors;
    private Map<String, String> fieldToValues;

    private String getPath() {
        return getServletConfig().getServletContext().getContextPath();
    }
    
    private String getValue(String fieldName, Map<String, String> map) {
        
        if (map.get(fieldName) != null) {
            return map.get(fieldName);
        } else {
            return "";
        }
    }
%>

<%
    if (request.getAttribute("errors") != null) {
        errors = (Map<String, String>) request.getAttribute("errors");
        fieldToValues = (Map<String, String>) request.getAttribute("fieldToValues");
    } else {
        errors = new HashMap<String, String>();
        fieldToValues = new HashMap<String, String>();
    }
%>

<html>
<head>    
    <title>Registration Form</title>
    <link rel="stylesheet" type="text/css" href="<%=getPath()%>/registrationform/style.css" />
</head>
<body>

    <div id="registrationForm">
        <form action="<%=getPath()%>/validate" method="post">
            <table>

                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" value="<%=getValue("firstName", fieldToValues)%>"/></td>
                    <td class="error"><%=getValue("firstName", errors)%></td>
                </tr>

                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" value="<%=getValue("lastName", fieldToValues)%>"/></td>
                    <td class="error"><%=getValue("lastName", errors)%></td>
                </tr>

                <tr>
                    <td>EGN: </td>
                    <td><input type="text" name="egn" value="<%=getValue("egn", fieldToValues)%>"/></td>
                    <td class="error"><%=getValue("egn", errors)%></td>
                </tr>

                <tr>
                    <td>Age: </td>
                    <td><input type="text" name="age" value="<%=getValue("age", fieldToValues)%>"/></td>
                    <td class="error"><%=getValue("age", errors)%></td>
                </tr>

                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address" value="<%=getValue("address", fieldToValues)%>"/></td>
                    <td class="error"><%=getValue("address", errors)%></td>
                </tr>

                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="password" /></td>
                    <td class="error"><%=getValue("password", errors)%></td>
                </tr>

                <tr>
                    <td>Confirm Password: </td>
                    <td><input type="password" name="confirmPassword" /></td>
                    <td class="error"><%=getValue("confirmPassword", errors)%></td>
                </tr>

                <tr>
                    <td></td>
                    <td><input type="submit" value="Register" /></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>