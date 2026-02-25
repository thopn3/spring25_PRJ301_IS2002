<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="Models.User" %>

<%
    // Nhúng mã java tại đây
    List<User> users = (List<User>)request.getAttribute("result");
%>

<h1>List of Users</h1>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Username</th>
        <th>Gender</th>
        <th>Address</th>
        <th>City</th>
        <th>Favorites</th>
    </tr>
    <% for(User u: users){ %>
    <tr>
        <td><%= u.getId()%></td>
        <td><%= u.getUsername()%></td>
        <td><%= u.getGender()%></td>
        <td><%= u.getAddress()%></td>
        <td><%= u.getCity()%></td>
        <td><%= u.getFavorites()%></td>
    </tr>
    <%}%>
</table>
