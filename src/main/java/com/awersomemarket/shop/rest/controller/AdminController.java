package com.awersomemarket.shop.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping(value = "")
    public String getStart(Model model) {
        return "admin/spa";
    }

    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:http://localhost:9090/auth/realms/ShopAdmins/protocol/openid-connect/logout?redirect_uri=http://localhost:8080/admin";
    }
}
