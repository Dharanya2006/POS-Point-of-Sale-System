package com.wipro.pos.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import com.wipro.pos.bean.PosBean;
import com.wipro.pos.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public String addRecord(HttpServletRequest request) {
        try {
            String customerName = request.getParameter("customerName");
            String itemName = request.getParameter("itemName");
            String dateStr = request.getParameter("transDate");
            String quantityStr = request.getParameter("quantity");
            String priceStr = request.getParameter("price");
            String remarks = request.getParameter("remarks");
            if (customerName == null || customerName.trim().isEmpty() ||itemName == null || itemName.trim().isEmpty() ||dateStr == null || dateStr.trim().isEmpty() ||quantityStr == null || quantityStr.trim().isEmpty() || priceStr == null || priceStr.trim().isEmpty()) {
                return "FAIL";
            }
            Date transDate = Date.valueOf(dateStr);
            int quantity = Integer.parseInt(quantityStr);
            double price = Double.parseDouble(priceStr);
            if (quantity <= 0 || price <= 0) return "FAIL";
            PosBean p = new PosBean();
            p.setCustomerName(customerName);
            p.setItemName(itemName);
            p.setTransDate(transDate);
            p.setQuantity(quantity);
            p.setPrice(price);
            p.setRemarks(remarks);
            return new Administrator().addRecord(p);
        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
    public PosBean viewRecord(HttpServletRequest request) {
        try {
            String customerName = request.getParameter("customerName");
            String dateStr = request.getParameter("transDate");
            if (customerName == null || customerName.trim().isEmpty() ||dateStr == null || dateStr.trim().isEmpty()) {
            	return null;
            }
            Date transDate = Date.valueOf(dateStr);
            return new Administrator().viewRecord(customerName, transDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public List<PosBean> viewAllRecords(HttpServletRequest request){
    	return new Administrator().viewAllRecords();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        try {
            if ("newRecord".equals(operation)) {
                String result = addRecord(request);
                if ("FAIL".equals(result) || "FAILURE".equals(result)) {
                    response.sendRedirect("Error.html");
                } else {
                    response.sendRedirect("Success.html");
                }
                return;
            }
            if ("viewRecord".equals(operation)) {
                PosBean b = viewRecord(request);
                if (b == null) {
                    request.setAttribute("message", "No matching records exists! Please try again!");
                } else {
                    request.setAttribute("posBean", b);
                }
                request.getRequestDispatcher("DisplayTransaction.jsp").forward(request, response);
                return;
            }
            if ("viewAllRecords".equals(operation)) {
                Administrator admin = new Administrator();
                List<PosBean> list = admin.viewAllRecords();
                request.setAttribute("posList", list);
                request.getRequestDispatcher("DisplayAllTransactions.jsp").forward(request, response);
                return;
            }
            response.sendRedirect("Error.html");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Error.html");
        }
    }
}