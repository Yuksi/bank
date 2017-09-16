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
<h1>New client</h1>
<f:form method="POST" commandName="client" action="clients">
    <table>
        <tr>
            <td>
                <i>Name:</i>
            </td>
            <td>
                <f:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Address:</i>
            </td>
            <td>
                <f:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <i>Age:</i>
            </td>
            <td>
                <f:input path="age"/>
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="Save Changes"/></td>
        </tr>
    </table>
</f:form>
</body>
</html>
