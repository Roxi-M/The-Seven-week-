package com.roxi.inter.bean;

import lombok.Data;

import java.util.List;

/**
 * @author Roxi酱
 */
@Data
public class ClassData {
    private String status;
    private String version;
    private String stuNum;
    private String cachedTimestamp;
    private String outOfDateTimestamp;
    private List<Major> majors;
}
