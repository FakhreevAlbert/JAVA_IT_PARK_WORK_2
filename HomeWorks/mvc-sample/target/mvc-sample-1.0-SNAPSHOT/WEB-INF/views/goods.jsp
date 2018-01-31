<%@ page import="ru.itpark.domain.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: albert
  Date: 31.01.18
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp" %>

<div class="container">
    <div class="row">
        <div class="col">
            <h1>Goods List</h1>
            <form class="form-inline">
                <label for="search" class="sr-only">Name</label>
                <input type="search" id="search" name="name" class="form-control mb-2 mr-sm-2"
                       placeholder="Product name">
                <button type="submit" class="btn btn-primary mb-2">Search</button>
            </form>

            <% List<Product> goods = (List<Product>) request.getAttribute("goods"); %>
            <% if (goods != null && goods.size() > 0) {%>
            <ul class="list-group">
                <% for (Product product : goods) { %>
                <li class="list-group-item">
                    <a href="<%=request.getContextPath()%>/goods/<%=product.getId()%>">
                        <%=product.getName() %>
                        <%=product.getPrice()%>
                        <%=product.getAmount()%>
                    </a>
                </li>
                <% } %>
            </ul>
            <% } else { %>
            <p>No goods</p>
            <% } %>
            <ul class="list-group">
                <li class="list-group-item">
                    <a href="/managers">Manager list</a>

                </li>
                <li class="list-group-item">
                    <a href="/sales">Sales list</a>
                </li>
            </ul>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>