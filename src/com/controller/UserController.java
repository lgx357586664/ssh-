package com.controller;

import com.entity.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author: LiGX
 * @Date: 2019-04-22 下午 1:15
 */
//@RestController//返回josn串（与@Controller 加@ResponseBody）
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/add")
    public String addUser(User user){
        if(user.getId()==null){
            userService.add(user);
        }
        userService.update(user);
        return "redirect:/user/queryPage";
    }
    @RequestMapping("/findAll")
    public String query(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "user/list";
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "/user/update";
    }
    @RequestMapping("/queryOne/{id}")
    public ModelAndView queryOne(@PathVariable(name = "id")Integer id){
        User user = userService.findOne(id);
        ModelAndView modelAndView=new ModelAndView("/user/update");
        modelAndView.addObject("user",user);
        return modelAndView;
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id")Integer id){
        User user = userService.findOne(id);
        userService.delete(user);
        return "redirect:/user/queryPage";
    }
    @RequestMapping("/queryPage")
    public String queryPage(Model model,Integer pageIndex){
        if(pageIndex==null){
            pageIndex=1;
        }
        Integer count = userService.findAll().size();
        Integer pageCount=10;
        Integer index=(pageIndex-1)*pageCount;
        Integer pages=(count+pageCount-1)/pageCount;
        List<User> list = userService.queryPage(index,pageCount);
        model.addAttribute("list",list);
        model.addAttribute("pageIndex",pageIndex);
        model.addAttribute("pages",pages);
        model.addAttribute("pageCount",pageCount);
        return "user/list";
    }
}
