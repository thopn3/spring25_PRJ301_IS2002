<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h1>Edit user page</h1>
<form action="edit" method="post">
    UserId 
    <input type="text" name="id" value="${user.id}"/> <br/>
    Username 
    <input type="text" name="username" value="${user.username}"/><br/>
    Password
    <input type="password" name="password" value="${user.password}"/><br/>
    Gender
    <input type="radio" name="gender" value="male"
           <c:if test="${user.gender.trim() == 'male'}">checked</c:if>> Male

           <input type="radio" name="gender" value="female"
           <c:if test="${user.gender.trim() == 'female'}">checked</c:if>> Female

           <input type="radio" name="gender" value="other"
           <c:if test="${user.gender.trim() == 'other'}">checked</c:if>> Other <br/>

           Address
           <textarea rows="3" name="address">${user.address}</textarea><br/>

    City
    <input type="text" name="city" value="${user.city}"/><br/>

    Favorites <br/>
    <c:set var="favList" value="${fn:split(user.favorites,';')}"/>
    <input type="checkbox" name="fav" value="football" 
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='football'}">checked</c:if>
           </c:forEach>
           /> Football<br/>
    <input type="checkbox" name="fav" value="sing"
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='sing'}">checked</c:if>
           </c:forEach>
           /> Sing<br/>
    <input type="checkbox" name="fav" value="dance sport"
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='dance sport'}">checked</c:if>
           </c:forEach>
           /> Dance Sport<br/>
    <input type="checkbox" name="fav" value="shopping"
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='shopping'}">checked</c:if>
           </c:forEach>
           /> Shopping<br/>
    <input type="checkbox" name="fav" value="table tenis"
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='table tenis'}">checked</c:if>
           </c:forEach>
           /> Table Tenis<br/>
    <input type="checkbox" name="fav" value="picnic"
           <c:forEach var="f" items="${favList}">
               <c:if test="${f=='picnic'}">checked</c:if>
           </c:forEach>
           /> Picnic<br/>

    <input type="submit" value="Save"/>

</form>
