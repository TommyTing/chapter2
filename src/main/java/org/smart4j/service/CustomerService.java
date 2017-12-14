package org.smart4j.service;

import org.slf4j.Logger;
import org.smart4j.model.Customer;
import org.smart4j.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by admin on 2017/12/13.
 * 提供客户数据服务
 */
public class CustomerService {

    private static final String DRIVER;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties conf= PropsUtil.loadProps("config.properties");
        DRIVER=conf.getProperty("jdbc.driver");
        URL=conf.getProperty("jdbc.url");
        USERNAME=conf.getProperty("jdbc.username");
        PASSWORD=conf.getProperty("jdbc.password");

        try {
            Class.forName(DRIVER);
        }catch (ClassNotFoundException e){
            PropsUtil.LOGGER.error("can not load jdbc driver",e);
        }
    }

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        Connection conn=null;
            List<Customer> customerList=new ArrayList<Customer>();
            String sql="SELECT * FROM customer";
        try {
            conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
            PreparedStatement stmt=conn.prepareStatement(sql);
            ResultSet rs=stmt.executeQuery();
            while (rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return  customerList;
        }catch (SQLException e){
            PropsUtil.LOGGER.error("excute sql failure",e);
        }finally {
            if (conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    PropsUtil.LOGGER.error("close connection failure",e);
                }
            }
        }
       return  customerList;
    }

    /**
     * 获取客户
     */
    public Customer getCustomer(long id){
        //TODO
        return  null;
    }

    /**
     * 创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
        //TODO
        return  false;
    }

    /**
     * 更新客户
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
        //TODO
        return  false;
    }

    /**
     * 删除客户
     */
    public boolean deleteCustomer(long id){
        //TODO
        return  false;
    }
}
