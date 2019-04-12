package com.roxi.inter.service;

import com.google.gson.Gson;
import com.roxi.inter.bean.Major;
import com.roxi.inter.bean.Shooo;
import com.roxi.inter.bean.Student;
import com.roxi.inter.mapper.MajorMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


/**
 * @author Roxi酱
 */
@Service
public class StudentService {
    @SuppressWarnings("AlibabaCommentsMustBeJavadocFormat")
    @Autowired
    private MajorMapper majorMapper;
    public List<Shooo> selectMajor(String stuCode) {
       List<Shooo> majorList=majorMapper.selectMajor(stuCode);
        if(majorList.isEmpty()){
            return null;
        }else {
            return majorList;
        }
    }
    public List<Student> selectAll(String param){
        boolean flag=false;
        List<Student> studentList=new LinkedList<>();
        try{
            int stuNum= Integer.parseInt(param);
        }catch (Exception e){
            flag=true;
            System.out.println("无法转为数字嘛，就不是数字查询");
            studentList=majorMapper.selectCode(param);
        }
        if(!flag){
            studentList=majorMapper.selectName(param);
            System.out.println("这是数字查询嘛");
        }
        return studentList;
    }
}
