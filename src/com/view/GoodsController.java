package com.view;

import com.entity.Customer;
import com.entity.Goods;
import com.service.GoodsService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by PC on 2017/5/19.
 */
@Controller

public class GoodsController {
    @Resource
    private GoodsService goodsService;
    public GoodsService getGoodsService(){return this.goodsService;}
    public void setGoodsService(GoodsService goodsService){this.goodsService=goodsService;}
    @RequestMapping("listGoods")
    public String listGoods(HttpServletRequest req,@RequestParam(value = "customer", required = false)String customer,@RequestParam(value = "name", required = false)String name){
        Goods goods = new Goods();
        goods.setCustomer(customer);
        goods.setName(name);
        req.setAttribute("goods",goodsService.getAllGoods(goods));
        return "listGoods";
    }
    @RequestMapping("myGoods")
    public String myGoods(HttpServletRequest req){
        String username = (String)req.getSession().getAttribute("username");
        req.setAttribute("goods",goodsService.getMyGoods(username));
        return "myGoods";
    }
    @RequestMapping("deleteGoods")
    public String deleteGoods(HttpServletRequest req,@RequestParam String id){
        String username = (String)req.getSession().getAttribute("username");
        goodsService.deleteGoods(id);
        req.setAttribute("goods",goodsService.getMyGoods(username));
        return "myGoods";
    }
    @RequestMapping("delete")
    public String delete(HttpServletRequest req,@RequestParam String id,@RequestParam String password){
        System.out.println(password);
        if(password.equals("admin")){
            System.out.println("delete-----");
            goodsService.deleteGoods(id);
        }

        req.setAttribute("goods",goodsService.getAllGoods(null));
        return "admin";
    }
    @RequestMapping("admin")
    public String admin(HttpServletRequest req){
        req.setAttribute("goods",goodsService.getAllGoods(null));
        return "admin";
    }
    @RequestMapping("updateGoods")
    public String updateGoods(HttpServletRequest req){
        return "updateGoods";
    }
    @RequestMapping("comment")
    public String comment(HttpServletRequest req,@RequestParam String id){
        Goods goods = goodsService.getGoods(id);
        req.setAttribute("item",goods);
        System.out.println(goods.getComment());
        JSONArray array=JSONArray.fromObject(goods.getComment());
        req.setAttribute("comment",array);
        return "comment";
    }
    @RequestMapping("addComment")
    public String addComment(HttpServletRequest req,@RequestParam String comment,@RequestParam String id){
        String username = (String)req.getSession().getAttribute("username");
        Goods goods=goodsService.getGoods(id);
        JSONArray array=JSONArray.fromObject(goods.getComment());
        JSONObject object = new JSONObject();
        object.accumulate("customer",username);
        object.accumulate("comment",comment);
        array.add(object);
        goods.setComment(array.toString());
        goodsService.updateGoods(goods);
        req.setAttribute("item",goods);
        req.setAttribute("comment",array);
        return "comment";
    }


    @RequestMapping(value="addGoods", method= RequestMethod.POST)
    public String addGoods(HttpServletRequest req, @RequestParam(value = "img", required = false) MultipartFile file){
        String name = req.getParameter("name");
        String type= req.getParameter("type");
        String introduce = req.getParameter("introduce");
//        if(req.getParameter("price").matches())
        String prepare = req.getParameter("price");
        if(!prepare.matches("[1-9][0-9]{0,8}")){
            req.setAttribute("msg","价钱请输入一个1-999999999之间的整数");
            return "updateGoods";
        }
        int price= Integer.parseInt(prepare);
        Goods goods = new Goods("",(String)req.getSession().getAttribute("username"),name,type,introduce,"[]",price);
        goodsService.insertGoods(goods);
        String fileName = goods.getId()+".png";
        String path=req.getSession().getServletContext().getRealPath("images/goods");
        if(file==null)System.out.println("------文件为空");
        upFile(file,path,fileName);
        req.setAttribute("goods",goodsService.getAllGoods(null));
        System.out.println(goods.getId()+"---"+price);
        return "listGoods";
    }
    @RequestMapping("listUser")
    public String listUser(HttpServletRequest req){
        return "listUser";
    }

    public void upFile(MultipartFile file,String path,String fileName){

        File targetFile = new File(path, fileName);
        System.out.println("---2");
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        } try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
