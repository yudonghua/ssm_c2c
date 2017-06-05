package test;


import com.dao.CustomerDao;
import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.entity.Customer;
import com.entity.Goods;
import com.entity.Order;
import com.service.CustomerService;
import com.util.ApplicationDataBaseInit;
import com.util.DBEnvironmentListener;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class DaoTest {
	private ClassPathXmlApplicationContext context;
	private CustomerDao customerDao;
	private GoodsDao goodsDao;
	private CustomerService customerService;
	
	 @Before
	public void init(){
		context = new ClassPathXmlApplicationContext("spring_config/applicationContext.xml");
		 customerDao = (CustomerDao)context.getBean("customerDao");
		 goodsDao = (GoodsDao)context.getBean("goodsDao");
		 customerService = (CustomerService)context.getBean("customerService");
		 if(goodsDao==null) System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 if(customerDao==null) System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	}
	 
 
	//INSERT INTO USER_INFO VALUES(1,'admin','123','1986-11-24',1,20);
	@Test
	public void testGetOneCustomer(){
//		new ApplicationDataBaseInit().contextInitialized(null);
		 Customer customer = new Customer("aaa","aaa","123","das");
		customerService.updateCustomer(customer);
		 System.out.println(customerService.getAllCustomer());
//		System.out.println(customerDao.getMap());
//		Order order = new Order("id","gid","","customer","address","status","name",20,200);
//		orderDao.insertOrder(order);
//		Goods goods = new Goods();
//		goods.setName("aaa");
//		System.out.println(goodsDao.getAllGoods(null));
//		System.out.println(orderDao.getBOrder("aaa"));
	}
	 
}
