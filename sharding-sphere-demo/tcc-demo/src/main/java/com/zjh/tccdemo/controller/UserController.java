package com.zjh.tccdemo.controller;

import com.zjh.tccdemo.db129.model.User;
import com.zjh.tccdemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author zhaojh
 * @date 2020/11/10 15:44
 */
@Controller
@RequestMapping("user")
@Slf4j
public class UserController {

    @Autowired
    private CuratorFramework zkClient;
    @Autowired
    private UserService userService;
    Set<String> tokenSet = new HashSet<>();

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
        Map<String, Integer> map = new HashMap<>();
        map.put("status", row);
        return map;
    }

    @RequestMapping("/detail")
    public String userDetail(Integer userId, ModelMap map) {
        User user = userService.userDetail(userId);
        map.addAttribute("user", user);
        return "user/user-detail";
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user, String token) throws Exception {
        Thread.sleep(3000);
        log.info("获取到的token：" + token);
        if (user.getId() != null) {
            log.info("更新用户");
            Integer updateUser = userService.updateUser(user);
        } else {
            if (tokenSet.contains(token)) {
                log.info("添加用户");
                Integer register = userService.registerLockByRedisson(user, token);
                log.info("插入结果：" + register);
                if (register == 1) {
                    log.info(user.getUsername() + " --> 注册成功。");
                }
            }
        }
        return "redirect:/user/userList";
    }

    @RequestMapping("/register")
    public String register(ModelMap map) {
        String token = UUID.randomUUID().toString();
        tokenSet.add(token);
        User user = new User();
        map.addAttribute("user", user);
        map.addAttribute("token", token);
        return "user/user-register";
    }

}
