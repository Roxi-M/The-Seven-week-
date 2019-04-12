package com.roxi.inter.mapper;

import com.roxi.inter.bean.Shooo;
import com.roxi.inter.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Roxi酱
 */
@Mapper
public interface MajorMapper {
    /**
     *  find Major
     * @param stuCode
     * @return
     */
    @Select("select name,nameId,type,teacherName,time,classRoom from major where stuCode=#{stuCode}")
     List<Shooo> selectMajor(String stuCode);

    /**
     * 找学号
     * @param name
     * @return
     */
    @Select("select * from student where stuName=#{name}")
     List<Student> selectCode(String name);

    /**
     * 找学生
     * @param code
     * @return
     */
    @Select("select * from student where stuCode=#{code}")
     List<Student> selectName(String code);
}
