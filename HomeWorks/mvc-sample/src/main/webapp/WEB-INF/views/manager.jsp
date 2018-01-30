<%@ page import="ru.itpark.domain.Manager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.01.2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <% Manager manager = (Manager) request.getAttribute("manager"); %>

            <h1><%=manager.getName()%>
            </h1>
            <p>Salary: <%=manager.getSalary()%>
            </p>
        </div>
    </div>
</div>

<%@include file="footer.jsp"%>