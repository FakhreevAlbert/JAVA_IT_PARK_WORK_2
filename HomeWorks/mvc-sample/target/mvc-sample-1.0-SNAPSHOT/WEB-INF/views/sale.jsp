<%@ page import="ru.itpark.domain.Sale" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: albert
  Date: 31.01.18
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">


            <% Sale sale = (Sale) request.getAttribute("sale"); %>
            <h1><%=sale.getManager()%>
            </h1>
            <p>Product: <%=sale.getProduct()%>
            </p>
            <p>Sold amount: <%=sale.getSold()%>
            </p>
            <p>Price: <%=sale.getPrice()%>
            </p>
            <a href="/sales">Sales list</a>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
