package com.bit.lib.system.controller;

import com.bit.lib.member.model.MemberVO;
import com.bit.lib.system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MemberBorrowController {

    @Autowired
    private BorrowService service;

    //유저 검색 폼.jsp
    @RequestMapping(value = "/admin/borrow/membersearch",method = RequestMethod.GET)
    public String getSearchForm(){
        return "admin/borrow/search";
    }

    //memberid 검색 id 값을 re
    @RequestMapping(value = "/admin/borrow/membersearch",method = RequestMethod.POST)
    public ModelAndView memberSelectList(@RequestParam("member_id") String member_id){
        List<MemberVO> list= service.searchMember(member_id);
        ModelAndView view = new ModelAndView();
        view.setViewName("admin/borrow/search");
        view.addObject("memberList",list);
        return view;
    }


}
