package com.awersomemarket.shop.rest.controller;

import com.awersomemarket.shop.rest.dto.Customer;
import com.awersomemarket.shop.rest.dto.Order;
import com.awersomemarket.shop.rest.dto.position.Positions;
import com.awersomemarket.shop.rest.dto.status.Status;
import com.awersomemarket.shop.rest.dto.status.StatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PublicController {

    @GetMapping(value = "")
    public String getStart(Model model) {
        return "catalog";
    }

    @GetMapping(value = "logout")
    public String logout(HttpServletRequest request) throws ServletException {
        request.logout();
        return "redirect:http://localhost:9090/auth/realms/ShopAdmins/protocol/openid-connect/logout?redirect_uri=http://localhost:8080/admin";
    }

//    @PostMapping(value = "order", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Status order(@RequestBody Order order)
//    {
//        System.out.println(12);
//        Status st = new Status();
//        st.setCode(StatusCode.OK);
//
//        return st;
//    }

//    @PostMapping(value = "order")
//    public

}
