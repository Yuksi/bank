<%--
  Created by IntelliJ IDEA.
  User: Yuksi
  Date: 15.09.2017
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add client</title>
</head>
<body>
<h1>New transaction</h1>
<f:form method="POST" commandName="transaction" action="transactions">
    <table>
        <tr>
            <td>
                <i>ID sender:</i>
            </td>
            <td>
                <f:input path="senderAcc"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>ID getter:</i>
            </td>
            <td>
                <f:input path="getterAcc"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Amount:</i>
            </td>
            <td>
                <f:input path="amount"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>
