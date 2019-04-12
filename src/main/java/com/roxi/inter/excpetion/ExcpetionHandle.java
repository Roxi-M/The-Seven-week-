package com.roxi.inter.excpetion;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Roxi酱
 */
@ControllerAdvice
@ResponseBody
public class ExcpetionHandle {
    @ExceptionHandler(RuntimeException.class)
    public MyExcpetion excpetionHandle(RuntimeException e){
        e.printStackTrace();
        return new MyExcpetion(400,"发生了未知错误哟");
    }
}
