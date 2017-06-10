<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <style>
        .tree span:hover {
            font-weight: bold;
        }

        .tree span {
            cursor: pointer;
        }
    </style>
    <meta charset="utf-8">
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
            <button><a href="<c:url value="/addCharactEo" />">
                Добавление характеристики ОО
            </a></button></td>
    </tr>

    <tr bgcolor="white">
        <td><c:if test="${!empty eoList}">
            Выберите образовательный объект:
            <c:if test="${!empty classifierListONID.name}">
                    <ul class="tree">
                        <li>${classifierListONID.name}</c:if>
                            <ul>
                                <c:forEach items="${eoList}" var="EducObjectEntity">
                                    <li><a href="<c:url value="/eo/${EducObjectEntity.id}" />"> ${EducObjectEntity.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <ul class="tree">
             </c:if>

                <c:if test="${!empty eoListChild}">
                 Выберите образовательный объект:
                    <ul class="tree">
                        <c:if test="${!empty eoListChildONID.name}">
                        <li>${eoListChildONID.name}</c:if>
                            <ul>
                                <c:forEach items="${eoListChild}" var="EducObjectEntity">
                                    <li><a href="<c:url value="/eo/${EducObjectEntity.id}" />"> ${EducObjectEntity.name}</a></li>
                                </c:forEach>
                            </ul>
                        </li>
                    </ul>
                    <ul class="tree">
                    </c:if>
                    <c:if test="${!empty classifierList}">
                        Выберите классификатор:
                            <ul class="tree">
                                <c:if test="${classifierListONID.name != null}">
                                <li>${classifierListONID.name}</c:if>
                                    <ul>
                                        <c:forEach items="${classifierList}" var="ClassifierEntity">
                                            <li><a href="<c:url value="/index/${ClassifierEntity.id}" />"> ${ClassifierEntity.name}</a></li>
                                        </c:forEach>
                                    </ul>
                                </li>
                            <ul class="tree">
                    </c:if></td>
        <td><c:if test="${!empty charactvalueList}">
            <table class="data" width="500">
                <tr><td><c:forEach items="${charactList}" var="CharactEntity">
                    ${CharactEntity.name} : <br>
                </c:forEach></td>
                    <td> <c:forEach items="${charactvalueList}" var="CharactValueEntity">
                        <c:if test="${!empty CharactValueEntity.strValue}">
                            ${CharactValueEntity.strValue}
                        </c:if>
                        <c:if test="${!empty CharactValueEntity.intValue}">
                            ${CharactValueEntity.intValue}
                        </c:if>
                        <c:if test="${!empty CharactValueEntity.transferValue}">
                            ${CharactValueEntity.transferValue}
                        </c:if>
                        <c:if test="${!empty CharactValueEntity.dateValue}">
                            ${CharactValueEntity.dateValue}
                        </c:if><br>
                    </c:forEach></td></tr>
            </table><br>
        <c:if test="${!empty eoListPersonsAll}">
            Разработчики ${eoListONID.name}${eoListChildONID.name}:
            <table class="data" width="900">
                <tr><td>
                    <c:forEach items="${eoPersEO}" var="PersonEntity">
                        ${PersonEntity.name} ${PersonEntity.patronymic} ${PersonEntity.surname}, <br>
                    </c:forEach></td>
                    <td><c:forEach items="${eoPosPerEO}" var="PositionEntity">
                        ${PositionEntity.name}, <br>
                    </c:forEach></td>
                    <td><c:forEach items="${eoSubPerEO}" var="SubdivisionEntity">
                        ${SubdivisionEntity.name}. <br>
                    </c:forEach>
                    </td>
                </tr>
            </table>
        </c:if>
        </c:if>
            <c:if test="${!empty charactclassList}">
                Характеристики классификатора ${classifierListONID.name}:
                <table class="data" width="500">
                    <c:forEach items="${charactclassList}" var="CharactEntity">
                        <tr><td>${CharactEntity.name}</td></tr>
                    </c:forEach>
                </table>
            </c:if>
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