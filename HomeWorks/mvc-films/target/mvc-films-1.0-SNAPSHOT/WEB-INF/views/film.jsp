<%@ page import="ru.itpark.domain.Film" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.02.2018
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <% Film film = (Film) request.getAttribute("film"); %>

            <h1><%=film.getName()%></h1>
            <ul>
                <img src="<%=film.getFoto()%>"><br>
                <%=film.getInfo()%><br>
                <p>Жанр: <%=film.getGenre()%></p>
                <p> Рейтинг КиноПоиск: <%=film.getRating()%></p>

            </ul>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>
