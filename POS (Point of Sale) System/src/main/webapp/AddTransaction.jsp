<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><meta charset="UTF-8"><title>Add Transaction</title></head>
<body>
<h2>Add Transaction</h2><br>
<form action="MainServlet" method="post">
<input type="hidden" name="operation" value="newRecord">
<label>Customer Name:</label>
<input type="text" name="customerName"><br><br>
<label>Item Name:</label>
<input type="text" name="itemName"><br><br>
<label>Transaction Date:</label>
<input type="date" name="transDate"><br><br>
<label>Quantity:</label>
<input type="number" name="quantity"><br><br>
<label>Price:</label>
<input type="number" name="price" step="0.01"><br><br>
<label>Remarks:</label>
<input type="text" name="remarks"><br><br>
<input type="submit" value="Add Record">
</form>
</body>
</html>