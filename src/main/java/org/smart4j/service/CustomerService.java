package org.smart4j.service;

import org.slf4j.Logger;
import org.smart4j.helper.DatabaseHelper;
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

    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        Connection conn=DatabaseHelper.getConnection();
        try {
            String sql="SELECT * FROM customer";
            return DatabaseHelper.queryEntityList(Customer.class,conn,sql);
        }catch (SQLException e){
            PropsUtil.LOGGER.error("excute sql failure",e);
        }finally {
           DatabaseHelper.closeConnection(conn);
        }
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
