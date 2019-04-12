package com.roxi.inter.mapper;

import com.roxi.inter.bean.Elective;
import com.roxi.inter.bean.Major;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Roxi酱
 */
@Mapper
public interface ElectiveMapper {
    /**
     *  检测 是否 有这个学号已经登陆
     * @param stuCode
     * @return
     */
    @Select("select stuName from student where stuCode=#{stuCode}")
    String select(String stuCode);

    /**
     *  找所有的选修课 ，让你来选
     * @return
     */
    @Select("select * from elective")
    List<Major> selectAllElective();

    /**
     * 找星期几 上课 还有 第几节课 为了 课程不冲突
     * @param id
     * @return
     */
    @Select("select * from elective where id=#{id}")
    Major selectElective(String id);

    /**
     * 建立 学生与选修表的关系
     * @param stuCode
     * @param classId
     */
    @Insert("insert into stuMajor(stuCode,classId) values(#{stuCode},#{classId})")
    void insert(String stuCode,String classId);
}
