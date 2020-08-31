package com.itybh.utils;

/**
 * 记录日志的工具类。他里面提供了公工代码
 */
public class Logger {
    /**
     * 用于打印日志，计划让其切入点方法执行之前执行（切入点方法就是业务层方法）
     */
    public void printLog(){
        System.out.println("Logger中的printLog方法开始记录日志了");
    }

}
