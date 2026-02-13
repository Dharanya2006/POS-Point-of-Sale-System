<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.wipro.pos.bean.PosBean" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Transaction Records</title>
</head>
<body>
<h2>All Transaction Records</h2>
<%
    List<PosBean> list = (List<PosBean>) request.getAttribute("posList");
%>
<% if (list == null || list.isEmpty()) { %>
    <h3 style="color:red;">No records found</h3>
<% } else { %>
<table border="1" cellpadding="5">
    <tr>
        <th>Transaction ID</th>
        <th>Customer Name</th>
        <th>Item Name</th>
        <th>Date</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Total Amount</th>
        <th>Remarks</th>
    </tr>
    <% for (PosBean p : list) { %>
    <tr>
        <td><%= p.getTransId() %></td>
        <td><%= p.getCustomerName() %></td>
        <td><%= p.getItemName() %></td>
        <td><%= p.getTransDate() %></td>
        <td><%= p.getQuantity() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= p.getTotalAmount() %></td>
        <td><%= p.getRemarks() %></td>
    </tr>
    <% } %>
</table>
<% } %>
<br><br>
<a href="Menu.html">Back to Menu</a>
</body>
</html>