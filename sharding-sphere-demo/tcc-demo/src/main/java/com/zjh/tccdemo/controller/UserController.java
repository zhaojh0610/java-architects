package com.zjh.tccdemo.controller;

import com.zjh.tccdemo.db129.model.User;
import com.zjh.tccdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhaojh
 * @date 2020/11/10 15:44
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userList")
    public String allUser(ModelMap map) {
        List<User> allUser = userService.getAllUser();
        map.addAttribute("users", allUser);
        return "user/user-list";
    }

    @RequestMapping("/del")
    @ResponseBody
    public Map<String, Integer> del(@RequestParam int userId) {
        int row = userService.del(userId);
        Map<String,Integer> map = new HashMap<>();
        map.put("status", row);
        return map;
    }

}
