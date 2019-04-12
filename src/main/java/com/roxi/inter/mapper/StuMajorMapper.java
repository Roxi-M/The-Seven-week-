package com.roxi.inter.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Roxi酱
 */
@Mapper
public interface StuMajorMapper {
    /**
     * 查找 学生 选了 哪些选修课 id
     * @param stuCode
     * @return
     */
    @Select("select classId from stuMajor where stuCode=#{stuCode}")
    List<String> select(String stuCode);
}
