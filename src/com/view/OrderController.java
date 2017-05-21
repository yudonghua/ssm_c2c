package com.view;

import com.entity.Order;
import com.service.CustomerService;
import com.service.GoodsService;
import com.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Dell on 2017/5/21.
 */
@Controller
public class OrderController {
    @Resource
    private CustomerService customerService;
    @Resource
    private OrderService orderService;
    @Resource
    private GoodsService goodsService;

    @RequestMapping("buyGoods")
    public String listGoods(HttpServletRequest req,@RequestParam String gid,@RequestParam int num){
        String username=(String)req.getSession().getAttribute("username");
        String address = customerService.getCustomer(username).getAddress();

        Order order = new Order("id",gid,"",username,address,"已下单" +
                "","",0,num);
        System.out.println(order);
        orderService.insertOrder(order);
        req.setAttribute("order",orderService.getCOrder(username));
        System.out.println(orderService.getCOrder(username));
        return "myOrder";
    }
    @RequestMapping("myOrder")
    public String myOrder(HttpServletRequest req){
        String username=(String)req.getSession().getAttribute("username");
        req.setAttribute("order",orderService.getCOrder(username));
        return "myOrder";
    }
    @RequestMapping("changeStatus")
    public String changeStatus(HttpServletRequest req,@RequestParam String id,@RequestParam String jsp){
        Order order=orderService.getOrder(id);
        String username=(String)req.getSession().getAttribute("username");
        if(jsp.equals("myOrder")){
            order.setStatus("交易完成");
            orderService.updateOrder(order);
            req.setAttribute("order",orderService.getCOrder(username));
            return "myOrder";
        }
        order.setStatus("货在路上");
        orderService.updateOrder(order);
        req.setAttribute("order",orderService.getBOrder(username));
        return "itOrder";
    }

    @RequestMapping("itOrder")
    public String itOrder(HttpServletRequest req){
        String username=(String)req.getSession().getAttribute("username");
        req.setAttribute("order",orderService.getBOrder(username));
        return "itOrder";
    }


    public GoodsService getGoodsService(){return this.goodsService;}
    public void setGoodsService(GoodsService goodsService){this.goodsService=goodsService;}
    public CustomerService getCustomerService(){return customerService;}
    public void setCustomerService(CustomerService customerService){this.customerService=customerService;}
    public OrderService getOrderService(){return this.orderService;}
    public void setOrderService(OrderService orderService){this.orderService=orderService;}
}
