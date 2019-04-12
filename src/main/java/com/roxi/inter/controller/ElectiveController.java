package com.roxi.inter.controller;

import com.roxi.inter.bean.Elective;
import com.roxi.inter.bean.Major;
import com.roxi.inter.service.ElectiveService;
import com.roxi.inter.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Roxi酱
 */
@RestController
public class ElectiveController {
    private final String STUDENT="student";
    @Autowired
    private ElectiveService electiveService;
    @GetMapping("/login")
    public String login(String stuCode, HttpSession session){
        if(stuCode==null){
            return "请输入:您的学号";
        }else if(session.getAttribute(STUDENT)!=null){
            String code= (String) session.getAttribute(STUDENT);
            return "已登陆:"+code;
        }
        boolean lg =electiveService.isLogin(stuCode);
        if(lg){
            session.setAttribute(STUDENT,stuCode);
            return "success";
        }
       return "false";
    }
    @GetMapping("/elective")
    public List<Major> elective(){
        return electiveService.see();
    }

    /**
      * 这里开始选课 不过还没有开始
     */
    @GetMapping("/class")
    public String electiveClass(String id,HttpSession session){
        if(id==null){
            return null;
        }else {
            String code= (String) session.getAttribute(STUDENT);
            if(electiveService.can(id,code)){
                return "选课成功";
            }else {
                return "有课，不能选";
            }
        }
    }
}
