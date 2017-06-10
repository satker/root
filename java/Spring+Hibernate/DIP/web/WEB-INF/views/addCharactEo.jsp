<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="select" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artem
  Date: 08.05.2017
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table width="1250"
       align="center" cellspacing="0" cellpadding="10">
    <tr bgcolor="teal">
        <td><button><a href="<c:url value="/index" />">
            В начало
        </a></button>
            <button><a href="<c:url value="/indexR" />">
                Центр управления пользователями
            </a></button></td>
        <td><button><a href="<c:url value="/addClassifier" />">
            Добавление классификатора
        </a></button>
            <button><a href="<c:url value="/addClassifier" />">
                Добавление ОО
            </a></button>
            <button><a href="<c:url value="/addClassifier" />">
                Добавление характеристики классификатора
            </a></button>
            <button><a href="<c:url value="/addClassifier" />">
                Добавление характеристики ОО
            </a></button></td>
    </tr>

    <tr bgcolor="white">
        <td>Добавить характеристики ОО:</td>
        <td>
            <form:form method="post" action="addCharactEo" commandName="addCharactEo">
                <table>
                    <tr>

                    </tr>
                    <tr>
                        <td><form:label path="name">
                            Образовательный объект:
                        </form:label></td>
                        <td><select>
                            <option value="0">--Выберите образовательный объект--</option>
                            <c:forEach items="${EOAll}" var="EducObjectEntity">
                                <option value="${EducObjectEntity.id}">${EducObjectEntity.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td><form:label path="idClassifier">
                            Родительский класс:
                        </form:label></td>
                        <td><select>
                            <option value="0">--Выберите классификатор-родитель--</option>
                            <c:forEach items="${classifierAllList}" var="ClassiferEntity">
                                <option value="${ClassiferEntity.id}">${ClassiferEntity.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td><form>
                            ФИО разработчика:
                        </form></td>
                        <td><select>
                            <option value="0">--Выберите ФИО разработчика--</option>
                            <c:forEach items="${PersEOAll}" var="PersonEntity">
                                <option value="${PersonEntity.id}">${PersonEntity.name} ${PersonEntity.patronymic} ${PersonEntity.surname}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td><form>
                            Должность разработчика:
                        </form></td>
                        <td><select>
                            <option value="0">--Выберите должность разработчика--</option>
                            <c:forEach items="${PosPerEOAll}" var="PositionEntity">
                                <option value="${PositionEntity.id}">${PositionEntity.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td><form>
                            Подразделение разработчика:
                        </form></td>
                        <td><select>
                            <option value="0">--Выберите подразделение разработчика--</option>
                            <c:forEach items="${SubPerEOAll}" var="SubdivisionEntity">
                                <option value="${SubdivisionEntity.id}">${SubdivisionEntity.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td><form>
                            Название характеристики:
                        </form></td>
                        <td><select>
                            <option value="0">--Выберите подразделение разработчика--</option>
                            <c:forEach items="${charactAll}" var="CharactEntity">
                                <option value="${CharactEntity.id}">${CharactEntity.name}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr><td><form>
                        Значение характеристики:
                    </form></td>
                        <td><form:input path="name" /></td></tr>

                    <tr>
                        <td colspan="2"><input type="submit"
                                               value="Добавить характеристики образовательного объекта"/></td>
                    </tr>
                </table>
            </form:form>
        </td>
    </tr>

    <tr bgcolor="#5f9ea0">
        <td colspan="3" height="30"><a href="<c:url value="/logout" />">
            Выйти из учетной записи
        </a></td>
    </tr>

</table>

</body>
</html>

