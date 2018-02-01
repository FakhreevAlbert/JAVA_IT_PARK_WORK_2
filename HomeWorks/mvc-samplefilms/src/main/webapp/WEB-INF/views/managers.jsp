<%@ page import="ru.itpark.domain.Manager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.01.2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<div class="container">
    <div class="row">
        <div class="col">
            <h1>Managers List</h1>
            <form class="form-inline">
            <label for="search" class="sr-only">Name</label>
                <input type="search" id="search" name="name" class="form-control mb-2 mr-sm-2" placeholder="Manager name">
                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </form>

            <% List<Manager> managers = (List<Manager>) request.getAttribute("managers"); %>
       <% if (managers != null && managers.size() > 0){%>
            <ul class="list-group">
                <% for (Manager manager : managers) { %>
                  <li class="list-group-item">
                      <a href="<%=request.getContextPath()%>/managers/<%=manager.getId()%>">
                          <%=manager.getName() %>
                      </a>
                  </li>
                <% } %>
            </ul>
            <% } else { %>
            <p>No managers</p>
            <% } %>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>