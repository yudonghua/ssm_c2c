package test;


import com.dao.CustomerDao;
import com.dao.GoodsDao;
import com.dao.OrderDao;
import com.entity.Customer;
import com.entity.Goods;
import com.entity.Order;
import com.util.ApplicationDataBaseInit;
import com.util.DBEnvironmentListener;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DaoTest {
	private ClassPathXmlApplicationContext context;
	private CustomerDao customerDao;
	private GoodsDao goodsDao;
	private OrderDao orderDao;
	
	 @Before
	public void init(){
		context = new ClassPathXmlApplicationContext("spring_config/applicationContext.xml");
		 customerDao = (CustomerDao)context.getBean("customerDao");
		 goodsDao = (GoodsDao)context.getBean("goodsDao");
		 orderDao = (OrderDao)context.getBean("orderDao");
		 if(goodsDao==null) System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		 if(customerDao==null) System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	}
	 
 
	//INSERT INTO USER_INFO VALUES(1,'admin','123','1986-11-24',1,20);
	@Test
	public void testGetOneCustomer(){
//		new ApplicationDataBaseInit().contextInitialized(null);
//		 Customer customer = new Customer("a","test","123","das");
//		 customerDao.insertCustomer(customer);
//		Order order = new Order("id","gid","","customer","address","status","name",20,200);
//		orderDao.insertOrder(order);
		Goods goods = new Goods();
		goods.setName("aaa");
		System.out.println(goodsDao.getAllGoods(null));
//		System.out.println(orderDao.getBOrder("aaa"));
	}
	 
}
