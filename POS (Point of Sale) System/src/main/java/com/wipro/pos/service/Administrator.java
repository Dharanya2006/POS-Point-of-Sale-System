package com.wipro.pos.service;

import java.sql.Date;
import java.util.List;

import com.wipro.pos.bean.PosBean;
import com.wipro.pos.dao.PosDAO;
import com.wipro.pos.util.InvalidInputException;
public class Administrator {
    public String addRecord(PosBean bean) {
        try {
            if (bean == null ||
                bean.getCustomerName() == null || bean.getCustomerName().trim().isEmpty() ||
                bean.getItemName() == null || bean.getItemName().trim().isEmpty() ||
                bean.getTransDate() == null) {
                throw new InvalidInputException();
            }
            if (bean.getCustomerName().length() < 2) 
            	{
            	return "INVALID CUSTOMER NAME";
            	}
            if (bean.getItemName().length() < 2) 
            	{
            	return "INVALID ITEM NAME";
            	}
            if (bean.getQuantity() <= 0 || bean.getPrice() <= 0) {
            	return "INVALID TRANSACTION DETAILS";
            }
            PosDAO dao = new PosDAO();
            if (dao.recordExists(bean.getCustomerName(), bean.getTransDate())) {
            	return "ALREADY EXISTS";
            }
            String id = dao.generateTransID(bean.getCustomerName(), bean.getTransDate());
            bean.setTransId(id);
            bean.setTotalAmount(bean.getQuantity() * bean.getPrice());
            return dao.createRecord(bean);
        } catch (InvalidInputException e) {
            return "INVALID INPUT";
        } catch (Exception e) {
            e.printStackTrace();
            return "FAILURE";
        }
    }
    public PosBean viewRecord(String customerName, Date transDate) {
        if (customerName == null || customerName.trim().isEmpty() || transDate == null) 
        	{
        	return null;
        	}
        return new PosDAO().fetchRecord(customerName, transDate);
    }
    public List<PosBean> viewAllRecords() {
        return new PosDAO().fetchAllRecords();
    }
}