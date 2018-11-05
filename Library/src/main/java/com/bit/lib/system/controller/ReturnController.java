package com.bit.lib.system.controller;

import com.bit.lib.system.model.Borrow;
import com.bit.lib.system.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Map;

@Controller
public class ReturnController {

    @Autowired
    private ReturnService returnService;

    @RequestMapping(value = "/admin/return/home", method = RequestMethod.GET)
    public String getReturnForm(){


        return "admin/borrow/return";
    }

    @RequestMapping(value = "/admin/return/home", method = RequestMethod.POST)
    public ModelAndView getReturn(Borrow borrow) throws ParseException {
       Map<String,String> map = returnService.returnOk(borrow.getBook_code());

        ModelAndView view = new ModelAndView();
        view.addObject("username",map.get("username"));
        view.addObject("msg",map.get("msg"));
        view.setViewName("admin/borrow/return");
        return view;
    }

}
