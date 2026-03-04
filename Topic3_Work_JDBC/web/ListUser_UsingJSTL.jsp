<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>List of Users</h1>
<a href="CreateUser.html">Create new User</a>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Gender</th>
        <th>Address</th>
        <th>City</th>
        <th>Favorites</th>
        <th colspan="2">Actions</th>
    </tr>
    <c:forEach var="u" items="${result}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.gender}</td>
            <td>${u.address}</td>
            <td>${u.city}</td>
            <td>${u.favorites}</td>
            <td>
                <a href="edit?id=${u.id}">Edit</a>
            </td>
            <td>
                <a href="delete?id=${u.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>