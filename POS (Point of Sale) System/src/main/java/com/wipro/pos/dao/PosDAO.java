package com.wipro.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.wipro.pos.bean.PosBean;
import com.wipro.pos.util.DBUtil;
public class PosDAO {
    public String createRecord(PosBean bean) {
        String sql = "INSERT INTO POS_TB (TRANSID, CUSTOMERNAME, ITEMNAME, TRANS_DATE, QUANTITY, PRICE, TOTALAMOUNT, REMARKS) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, bean.getTransId());
            ps.setString(2, bean.getCustomerName());
            ps.setString(3, bean.getItemName());
            ps.setDate(4, new java.sql.Date(bean.getTransDate().getTime()));
            ps.setInt(5, bean.getQuantity());
            ps.setDouble(6, bean.getPrice());
            ps.setDouble(7, bean.getTotalAmount());
            ps.setString(8, bean.getRemarks());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                con.commit();
                return bean.getTransId();
            } else {
                con.rollback();
                return "FAIL";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "FAIL";
        }
    }
    public PosBean fetchRecord(String customerName, Date transDate) {
        String sql = "SELECT * FROM POS_TB WHERE CUSTOMERNAME=? AND TRUNC(TRANS_DATE)=TRUNC(?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(transDate.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    PosBean p = new PosBean();
                    p.setTransId(rs.getString("TRANSID"));
                    p.setCustomerName(rs.getString("CUSTOMERNAME"));
                    p.setItemName(rs.getString("ITEMNAME"));
                    p.setTransDate(rs.getDate("TRANS_DATE"));
                    p.setQuantity(rs.getInt("QUANTITY"));
                    p.setPrice(rs.getDouble("PRICE"));
                    p.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                    p.setRemarks(rs.getString("REMARKS"));
                    return p;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public boolean recordExists(String customerName, Date transDate) {
        String sql = "SELECT 1 FROM POS_TB WHERE CUSTOMERNAME=? AND TRUNC(TRANS_DATE)=TRUNC(?)";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, customerName);
            ps.setDate(2, new java.sql.Date(transDate.getTime()));
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<PosBean> fetchAllRecords() {
        List<PosBean> list = new ArrayList<>();
        String sql = "SELECT * FROM POS_TB ORDER BY TRANS_DATE DESC";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                PosBean p = new PosBean();
                p.setTransId(rs.getString("TRANSID"));
                p.setCustomerName(rs.getString("CUSTOMERNAME"));
                p.setItemName(rs.getString("ITEMNAME"));
                p.setTransDate(rs.getDate("TRANS_DATE"));
                p.setQuantity(rs.getInt("QUANTITY"));
                p.setPrice(rs.getDouble("PRICE"));
                p.setTotalAmount(rs.getDouble("TOTALAMOUNT"));
                p.setRemarks(rs.getString("REMARKS"));
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public String generateTransID(String customerName, Date transDate) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String datePart = format.format(transDate);
        if (customerName == null || customerName.length() < 2)
        	{
        	return null;
        	}
        String namePart = customerName.substring(0, 2).toUpperCase();
        String sql = "SELECT POS_SEQ.NEXTVAL FROM DUAL";
        try (Connection con = DBUtil.getDBConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            int seqVal = 0;
            if (rs.next()) 
            	seqVal = rs.getInt(1);
            String seqPart = String.format("%02d", seqVal);
            return datePart + namePart + seqPart;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}