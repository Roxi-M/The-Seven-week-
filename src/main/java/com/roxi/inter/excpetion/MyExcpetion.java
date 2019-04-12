package com.roxi.inter.excpetion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Roxi酱
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyExcpetion {
    int code;
    String message;
}
