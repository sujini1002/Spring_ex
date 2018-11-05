package com.bit.lib.system.controller;

import com.bit.lib.system.model.MybookList;
import com.bit.lib.system.service.ExtensionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExtensionController {

    @Autowired
    private ExtensionService service;

    @RequestMapping(value="/member/memberAccount/extension", method = RequestMethod.GET)
    public String getOk(@RequestParam("book_id") String book_id, Model model){

        MybookList mybookList = new MybookList();

        mybookList.setBook_code(book_id);
        model.addAttribute("check",service.extension(mybookList));

        return "redirect:/member/memberAccount/myBook";
    }

@RequestMapping(value = "admin/borrow/extension", method=RequestMethod.GET)
    public String approved(Model model){

       List<MybookList> list = service.getList();
       model.addAttribute("list",list);
        return "admin/borrow/extensionlist";
    }


    @RequestMapping(value = "admin/borrow/extension", method=RequestMethod.POST)
    public String updateapproved(@RequestParam("book_code") String code,@RequestParam("ok") boolean ok){
       if(ok) {
           service.extensionOk(code);
       }else{
           service.extensionNo(code);
       }
        return "redirect:/admin/borrow/extension";
    }
}
