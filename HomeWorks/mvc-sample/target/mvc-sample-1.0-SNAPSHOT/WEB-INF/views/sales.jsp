<%@ page import="ru.itpark.domain.Sale" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: albert
  Date: 31.01.18
  Time: 14:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <h1>Sales List</h1>
            <form class="form-inline">
                <label for="search" class="sr-only">Manager</label>
                <input type="search" id="search" name="manager" class="form-control mb-2 mr-sm-2"
                       placeholder="Manager name">
                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </form>

            <% List<Sale> sales = (List<Sale>) request.getAttribute("sales"); %>
            <% int total = 0;%>
            <% if (sales != null && sales.size() > 0) {%>
            <ul class="list-group">
                <% for (Sale sale : sales) { %>
                <li class="list-group-item">
                    <a href="<%=request.getContextPath()%>/sales/<%=sale.getId()%>">
                        <%=sale.getManager()%>
                        <%=sale.getProduct() %>
                        <%=sale.getSold() %>
                        <%=sale.getPrice() %>

                    </a>
                </li>
                <% total = total + sale.getPrice(); %>
                <% } %>
            </ul>
            <% } else { %>
            <p>No sales</p>
            <% } %>


            <ul class="list-group">
                <li class="list-group-item">
                    <p>Total: <%=total%>
                    </p>
                    <a href="/goods">Goods list</a><br>

                </li>
                <li class="list-group-item">
                    <a href="/managers">Managers list</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>