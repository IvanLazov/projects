<%--
  Created by Ivan Lazov (darkpain1989@gmail.com)
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Calculator</title>
    <script type="text/javascript" src="javascript.js"></script>
    <link rel="stylesheet" type="text/css" href="style.css" />

</head>
<body>

    <form id="form" method="post" action="../calculator">

        <input type="text" name="input" id="input" readonly="readonly" value="<%= session.getAttribute("result") == null ? "" : session.getAttribute("result") %>"/><br />

        <button type="button" id="ce" onclick="clearInput()"/>CE</button>
        <button type="button" id="delete" onclick="deleteLastDigit()"/><</button><br />

        <button type="button" id="7" onclick="writeNumber('7')"/>7</button>
        <button type="button" id="8" onclick="writeNumber('8')"/>8</button>
        <button type="button" id="9" onclick="writeNumber('9')"/>9</button>
        <button type="button" id="/" onclick="operation('/')"/>/</button><br />

        <button type="button" id="4" onclick="writeNumber('4')"/>4</button>
        <button type="button" id="5" onclick="writeNumber('5')"/>5</button>
        <button type="button" id="6" onclick="writeNumber('6')"/>6</button>
        <button type="button" id="*" onclick="operation('*')" />*</button><br />

        <button type="button" id="1" onclick="writeNumber('1')"/>1</button>
        <button type="button" id="2" onclick="writeNumber('2')"/>2</button>
        <button type="button" id="3" onclick="writeNumber('3')"/>3</button>
        <button type="button" id="-" onclick="operation('-')" />-</button><br />

        <button type="button" disabled="disabled" />&nbsp;</button>
        <button type="button" id="0" onclick="writeNumber('0')"/>0</button>
        <button type="submit" id="=" />=</button>
        <button type="button" id="+" onclick="operation('+')" />+</button>

    </form>

</body>
</html>