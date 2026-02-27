<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
           <c:if test="${user.gender.trim() == 'other'}">checked</c:if>> Other
</form>
