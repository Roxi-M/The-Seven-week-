package com.roxi.inter.controller;


import com.roxi.inter.bean.ClassData;
import com.roxi.inter.bean.Shooo;
import com.roxi.inter.bean.Student;
import com.roxi.inter.service.MajorService;
import com.roxi.inter.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Roxi酱
 */
@RestController
public class SearchController {
    @Autowired
    StudentService studentService;
    @Autowired
    MajorService majorService;
    @GetMapping("/search")
    public List<Student> search(String param){
        String json=null;
        if(param==null){
            return null;
        }
        else {
           return studentService.selectAll(param);
        }
    }

    @RequestMapping("/find")
    public ClassData selectStudent(String stuCode){
        if(stuCode==null){
            return null;
        }
        else {
            Date date=new Date();
          List<Shooo> list=studentService.selectMajor(stuCode);
         return majorService.show(stuCode,list, String.valueOf(date.getTime()));
        }
    }
}
