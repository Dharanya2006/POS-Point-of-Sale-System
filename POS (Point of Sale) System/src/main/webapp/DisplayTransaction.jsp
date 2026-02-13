<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Transaction Details</title></head>
<body>
<h2>Transaction Details</h2>
<c:if test="${not empty message}">
    <h3 style="color:red;">${message}</h3>
</c:if>
<c:if test="${not empty posBean}">
    <table border="1" cellpadding="5">
        <tr><th>Transaction ID</th><td>${posBean.transId}</td></tr>
        <tr><th>Customer Name</th><td>${posBean.customerName}</td></tr>
        <tr><th>Item Name</th><td>${posBean.itemName}</td></tr>
        <tr><th>Date</th><td>${posBean.transDate}</td></tr>
        <tr><th>Quantity</th><td>${posBean.quantity}</td></tr>
        <tr><th>Price</th><td>${posBean.price}</td></tr>
        <tr><th>Total Amount</th><td>${posBean.totalAmount}</td></tr>
        <tr><th>Remarks</th><td>${posBean.remarks}</td></tr>
    </table>
</c:if><br>
<a href="Menu.html">Back to Menu</a>
</body>
</html>