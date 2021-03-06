package com.example.demo.controller;


import com.example.demo.dao.MemberDaoImpl;
import com.example.demo.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/in")
public class UserInController {

    @Autowired
    MemberDaoImpl memberDao;

    @ResponseBody
    @RequestMapping(value="/Space",method = RequestMethod.POST)
    public String[] member_in(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(60 * 60);
        MemberEntity memberEntity = (MemberEntity) memberDao.findByMemberId(request);

        // 是会员
//        session.setAttribute("memberId", memberEntity.getMemberId());
//        session.setAttribute("memberName", memberEntity.getMemberName());
//        session.setAttribute("memberEmail", memberEntity.getMemberEmail());
//        session.setAttribute("registerTime", memberEntity.getRegisterTime());
//        session.setAttribute("dueTime", memberEntity.getDueTime());
//        session.setAttribute("isDue", memberEntity.getDue());

        String memberId = memberEntity.getMemberId();
        String memberName = memberEntity.getMemberName();
        String memberEmail = memberEntity.getMemberEmail();
        String registerTime = memberEntity.getRegisterTime();
        String dueTime = memberEntity.getDueTime();
        String isDue = memberEntity.getDue().toString();
        String[] memberInfo = {memberId, memberName, memberEmail, registerTime, dueTime, isDue};
        // System.out.println(memberEntity.getMemberId());
        return memberInfo;
        // System.out.println(request.getParameter("userName"));
        // session.setMaxInactiveInterval(60*60);
        // session.setAttribute("userName",request.getParameter("userName"));
        // session.setAttribute("userEmail",request.getParameter("userEmail"));

        // session.setAttribute("registerTime",request.getParameter("registerTime"));
        // session.setAttribute("isMember",request.getParameter("isMember"));
        // session.setAttribute("overDate",request.getParameter("overDate"));
        // session.setAttribute("isoverDate",request.getParameter("isoverDate"));

    }


    @ResponseBody
    @RequestMapping(value = "/getsession",method = RequestMethod.GET)
    public String getsession(HttpServletRequest request)
    {
        String name= (String) request.getSession().getAttribute("userName");
        String id= (String) request.getSession().getAttribute("memberId");
        System.out.println("id"+id);
        if(!id.isEmpty())
        {
            //是会员
            return "member";
        }
        else if(!name.isEmpty()){
            return "user";
        }
        return "login";
    }

}
