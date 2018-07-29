package com.zhfk.me.controller;

import com.zhfk.me.entity.UserEntity;
import com.zhfk.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller()
public class HtmlController {

    @Autowired
    private UserService userService;

    //主页
    @GetMapping("/index")
    public String index(@AuthenticationPrincipal Principal principal, Model model) {
        Iterable<UserEntity> users = userService.findAllUser();
        model.addAttribute("users", users);
        model.addAttribute("currentuser", principal.getName());
        return "/index";
    }

    //登录
    @GetMapping({"/","/login"})
    public String login() {
        return "login";
    }

    //注册
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    //注册
    @PostMapping("/register")
    public String DoRegister(UserEntity userEntity) {
        String pwd = userEntity.getPassword();
        userEntity.setPassword(new BCryptPasswordEncoder().encode(pwd));
        userService.saveUser(userEntity);
        return "login";
    }

}
