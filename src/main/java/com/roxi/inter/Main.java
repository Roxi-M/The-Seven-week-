package com.roxi.inter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Roxi酱
 */
public class Main {
    public static void main(String[] args) {
        String string="星期4 第9-10节1周,10周,13周 ";
        String day="第[\\s\\S]*节";
       String [] strings=string.split(day);
        String www="[0-9]+";
        Pattern pattern=Pattern.compile(www);
        Matcher matcher=pattern.matcher(strings[1]);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }
}
