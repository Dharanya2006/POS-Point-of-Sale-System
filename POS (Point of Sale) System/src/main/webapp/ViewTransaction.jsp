<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>View Transaction</title></head>
<body>
<h2>View Transaction</h2><br>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="viewRecord">
<label>Customer Name:</label>
<input type="text" name="customerName"><br><br>
<label>Transaction Date:</label>
<input type="date" name="transDate"><br><br>
<input type="submit" value="View Record">
</form>
</body>
</html>