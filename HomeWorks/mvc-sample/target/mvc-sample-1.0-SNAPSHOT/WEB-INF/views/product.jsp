<%@ page import="ru.itpark.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: albert
  Date: 31.01.18
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <% Product product = (Product) request.getAttribute("product"); %>
            <h1><%=product.getName()%>
            </h1>
            <p>Price: <%=product.getPrice()%>
            </p>
            <p>Amount: <%=product.getAmount()%>
            </p>
            <a href="/goods">Goods list</a>

        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
