package com.itybh.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 记录日志的工具类。他里面提供了公工代码
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("前置通知Logger中的beforePrintLog方法开始记录日志了");
    }

    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("后置通知Logger中的afterReturningPrintLog方法开始记录日志了");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("异常通知Logger中的afterThrowingPrintLog方法开始记录日志了");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("最终通知Logger中的afterPrintLog方法开始记录日志了");
    }

    /**
     * 环绕通知
     * 问题：
     *      当我们配置环境通知之后，切入点方法没有执行，而通知方法执行。
     * 分析：
     *      通知对比动态代理中的环绕通知代码，发现动态代理的环绕通知有明确的的切入点调用，而我们的代码没有
     * 解决：
     *      Spring框架为我们提供一个接口：ProceedingJoinPoint。改接口有一个方法proceed().此方法就相当于明确调用切入点方法
     *      改接口可以作为环绕通知的方法参数，在程序执行，Spring框架会为我们提供改接口的实现类供我们使用。
     *
     * spring中的环绕通知：
     *      它是spring框架为我们提供的一种可以在代码中手动控制增强方法何时执行方法。
     * @return
     */
    public Object aroundPrintLog(ProceedingJoinPoint pip){
        Object rtValue = null;
        try {
            Object[] args = pip.getArgs();//得到方法执行所需的参数

            System.out.println("Logger中的aroundPrintLog方法开始记录日志了------前置");
            rtValue = pip.proceed(args);//明确调用业务层方法(切入点方法)

            System.out.println("Logger中的aroundPrintLog方法开始记录日志了------后置");

            return rtValue;
        } catch (Throwable throwable) {
            System.out.println("Logger中的aroundPrintLog方法开始记录日志了------异常");
            throw new RuntimeException(throwable);
        }finally {
            System.out.println("Logger中的aroundPrintLog方法开始记录日志了--------最终");

        }

    }

}
