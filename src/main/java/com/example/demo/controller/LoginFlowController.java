package com.example.demo.controller;

import com.example.demo.dao.UserDaoImpl;
import com.example.demo.dao.resetPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.example.demo.dao.resetPassword;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Console;

@Controller
@RequestMapping(value = "/user")
public class LoginFlowController {

    @Autowired
    UserDaoImpl userDao;

    @Autowired
    resetPassword resetPassword;


    @ResponseBody
    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Object log_in(HttpServletRequest request)
    {
        return userDao.isValidate(request);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(HttpServletRequest request){
        Object registerResult = userDao.register(request);
        return registerResult;
    }

    @ResponseBody
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String resetPass(@RequestParam String email,
                            @RequestParam String code,
                            @RequestParam String newPass) {

        return resetPassword.resetPassword(email,code,newPass);

    }

    @ResponseBody
    @RequestMapping(value = "/sendCode", method = RequestMethod.POST)
    public String sendCode(@RequestParam String email) {
        String result = resetPassword.sendCode(email);
        return result;
    }






}
