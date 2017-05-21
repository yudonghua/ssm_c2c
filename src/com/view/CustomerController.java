package com.view;

import com.entity.Customer;
import com.service.CustomerService;
import com.service.GoodsService;
import com.service.impl.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dell on 2017/5/19.
 */
@Controller
public class CustomerController {
    @Resource
    private CustomerService customerService;
    @Resource
    private GoodsService goodsService;
    public CustomerService getCustomerService(){return customerService;}
    public void setCustomerService(CustomerService customerService){this.customerService=customerService;}
    public GoodsService getGoodsService(){return this.goodsService;}
    public void setGoodsService(GoodsService goodsService){this.goodsService=goodsService;}
    @RequestMapping("lista")
    public String listUser(HttpServletRequest req){
        return "listUser";
    }
    @RequestMapping("VerifyCodeServlet")
    public void VerifyCodeServlet(HttpServletRequest req,HttpServletResponse response) throws IOException {
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage(85,23);//设置验证码图片大小
        req.getSession().setAttribute("sessionverify", vc.getText());//将验证码文本保存到session域
        VerifyCode.output(image, response.getOutputStream());
    }
    @RequestMapping(value="Login", method= RequestMethod.GET)
    public String Login(){
        return "Login";
    }
    @RequestMapping(value="loginServlet", method= RequestMethod.POST)
    public String loginServlet(HttpServletRequest req,@RequestParam String username,@RequestParam String password,@RequestParam String verifycode){
//        System.out.println(verifycode+sessionverify);
        String sessionverify=(String)req.getSession().getAttribute("sessionverify");
        Customer customer = customerService.getCustomer(username);
        System.out.println(customer+"----"+username+"-----"+verifycode+"---"+sessionverify);
        if(!sessionverify.equalsIgnoreCase(verifycode)){
            req.setAttribute("msg","验证码错误");
            return "Login";
        }
        if(customer.getPassword().equals(password)){
            req.getSession().setAttribute("username",username);
            req.setAttribute("goods",goodsService.getAllGoods());
            return "listGoods";
        }

        req.setAttribute("msg","密码错误");
        return "Login";
    }
    @RequestMapping(value="Regist", method= RequestMethod.GET)
    public String Regist(){
        return "Regist";
    }
    @RequestMapping(value="registServlet", method= RequestMethod.POST)
    public String registServlet(HttpServletRequest req,@RequestParam String username,@RequestParam String password,@RequestParam String rpsw,@RequestParam String phone,@RequestParam String address){
        if(!username.equals("")&&!password.equals("")&&!rpsw.equals("")){
            req.setAttribute("meg","密码不一致");

            if(password.equals(rpsw)){
                req.getSession().setAttribute("username",username);
                req.setAttribute("goods",goodsService.getAllGoods());
                customerService.insertCustomer(new Customer(username,password,address,phone));
                return "listGoods";
            }
            return "Regist";
        }
        req.setAttribute("meg","请正确填写");
        return "Regist";
    }

}
