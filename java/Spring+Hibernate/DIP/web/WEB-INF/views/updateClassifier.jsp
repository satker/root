<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 07.05.2017
  Time: 20:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="classifier" method="POST">
    <table>
        <tr>
            <td><form:label path="name">
                Название классификатора
            </form:label></td>
            <td><form:input path="name" /></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="dateOk">
                Дата утверждения
            </form:label></td>
            <td><form:input path="dateOk" /></td>
            <td><form:errors path="dateOk" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="qualification">
                Квалификация
            </form:label></td>
            <td><form:input path="qualification" /></td>
            <td><form:errors path="qualification" cssClass="error"/></td>
        </tr>

        <tr>
            <td><form:label path="direction">
                Направление
            </form:label></td>
            <td><form:input path="direction" /></td>
            <td><form:errors path="direction" cssClass="error"/></td>
        </tr>
        <tr>
            <td colspan="2"><input name="edit" type="submit" value="Обновить"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
