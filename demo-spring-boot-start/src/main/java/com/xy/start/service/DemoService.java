package com.xy.start.service;

/**
 * @Author: xy
 * @Date: 2025-05-27 16:56
 * @Description:
 */
public class DemoService {
    public String sayWhat;
    public String toWho;
    public DemoService(String sayWhat, String toWho){
        this.sayWhat = sayWhat;
        this.toWho = toWho;
    }
    public String say(){
        return this.sayWhat + "!  " + toWho;
    }
}
