package org.smart.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.smart4j.model.Customer;
import org.smart4j.service.CustomerService;

/**
 * Created by admin on 2017/11/22.
 * CustomerService单元测试
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest() {
        customerService=new CustomerService();
    }

    @Before
    public void init(){
        //初始化数据库
    }

    @Test
    public void getCustomerListTest()throws Exception{
        List<Customer> customerList=customerService.getCustomerList();
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomerTest()throws Exception{
        long id=1;
        Customer customer=customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest()throws  Exception{
        Map<String,Object> fieldMap=new HashMap<String, Object>();
        fieldMap.put("name","customer100");
        fieldMap.put("contact","John");
        fieldMap.put("telephone","13512345678");
        boolean result=customerService.createCustomer(fieldMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomerTest()throws  Exception{
        long id=1;
        Map<String,Object> filedMap=new HashMap<String, Object>();
        filedMap.put("contact","Eric");
        boolean result=customerService.updateCustomer(id,filedMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomerTest()throws  Exception{
        long id=1;
        boolean result=customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }

    public static  void main(String[] args) {

    }
}
