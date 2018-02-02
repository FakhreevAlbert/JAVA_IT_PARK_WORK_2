<%@ page import="ru.itpark.domain.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.02.2018
  Time: 20:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col">
            <h1>Films List</h1>
            <form class="form-inline">
                <label for="search" class="sr-only">Name</label>
                <input type="search" id="search" name="name" class="form-control mb-2 mr-sm-2" placeholder="Film name">
                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </form>

            <% List<Film> films = (List<Film>) request.getAttribute("films"); %>
            <% if (films != null && films.size() > 0){%>
            <table class="list-group">
                <% for (Film film : films) { %>
                <tr>
                <td class="list-group-item">

                    <a href="<%=request.getContextPath()%>/films/<%=film.getId()%>">
                        <%=film.getName() %><br>

                        <img width="150" height="200" src="<%=film.getFoto()%>">


                    </a>
                </td>
                </tr>
                <% } %>

                <% } else { %>
                <p>No films</p>
                <% } %>
            </table>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
