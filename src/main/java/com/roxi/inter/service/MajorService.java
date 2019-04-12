package com.roxi.inter.service;

import com.roxi.inter.bean.*;
import com.roxi.inter.mapper.ElectiveMapper;
import com.roxi.inter.mapper.StuMajorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roxi酱
 */
@Service
public class MajorService {
    @Autowired
    StuMajorMapper stuMajorMapper;
    @Autowired
    ElectiveMapper electiveMapper;
    static final String DAY="[星期]+([1-7])";
    static final String LESSON="第[\\s\\S]*节";
    static final String DANSHUANG="[单，双]周";
    static final String BEGIN="[0-9]+";
    Pattern pattern1=Pattern.compile(DAY);
    Pattern pattern2=Pattern.compile(LESSON);
    Pattern pattern3=Pattern.compile(DANSHUANG);
    Pattern pattern4=Pattern.compile(BEGIN);
    public ClassData show(String stuCode, List<Shooo> shooos,String begin){
        ClassData classData=new ClassData();
        classData.setStatus("200");
        classData.setVersion("1.0.0");
        classData.setStuNum(stuCode);
        Date date=new Date();
        classData.setCachedTimestamp(begin);
        List<Major> majorList=new LinkedList<>();
        for(Shooo shooo:shooos){
            Major major=new Major();
            major.setClassroom(shooo.getClassRoom());
            major.setType(shooo.getType());
            major.setCourse(shooo.getName());
            major.setTeacher(shooo.getTeacherName());
            major.setId(shooo.getNameId());
            String string=shooo.getTime();
            Matcher matcher=pattern1.matcher(string);
            if(matcher.find()){
                major.setDay(matcher.group());
            }
            matcher=pattern2.matcher(string);
            if(matcher.find()){
                major.setLesson(matcher.group());
            }
            String [] strings=string.split(LESSON);
            //把后面的周分出来了
            major.setRawWeek(strings[1]);
            matcher=pattern3.matcher(strings[1]);
            if(matcher.find()){
                if("单周".equals(matcher.group())){
                    major.setWeekModel("single");
                }else {
                    major.setWeekModel("double");
                }
            }else {
                major.setWeekModel("all");
            }
            matcher = pattern4.matcher(strings[1]);
            List<String> list=new LinkedList<>();
            while (matcher.find()){
                list.add(matcher.group());
            }
            major.setWeekBegin(list.get(0));
            major.setWeekEnd(list.get(list.size()-1));
            majorList.add(major);
        }
        List<String> list=stuMajorMapper.select(stuCode);
        for(String id:list){
           Major major=electiveMapper.selectElective(id);
            majorList.add(major);
        }
        classData.setMajors(majorList);
        classData.setOutOfDateTimestamp(String.valueOf(date.getTime()));
        return classData;
    }
}
