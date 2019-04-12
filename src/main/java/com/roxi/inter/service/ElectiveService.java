package com.roxi.inter.service;

import com.roxi.inter.bean.ClassData;
import com.roxi.inter.bean.Elective;
import com.roxi.inter.bean.Major;
import com.roxi.inter.bean.Shooo;
import com.roxi.inter.mapper.ElectiveMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Roxi酱
 */
@Service
public class ElectiveService {
    @Autowired
    private ElectiveMapper electiveMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private MajorService majorService;
    public boolean isLogin(String stuCode){
        String code=electiveMapper.select(stuCode);
        if(code!=null){
            return true;
        }else {
            return false;
        }
    }
    public List<Major> see(){
       return electiveMapper.selectAllElective();
    }
    public boolean can(String id,String code){
        Major elective=electiveMapper.selectElective(id);
        return compare(elective,code);
    }
   private boolean compare(Major elective,String code){
        List<Shooo> list=studentService.selectMajor(code);
        ClassData classData=majorService.show(code,list,"");
        List<Major> majors=classData.getMajors();
        for (Major major:majors){
            if(major.getDay().equals(elective.getDay()) && major.getLesson().equals(elective.getLesson())){
                return false;
            }
        }
        electiveMapper.insert(code,elective.getId());
        return true;
    }
}
