package com.akashprojects.springbootcore;

import org.springframework.stereotype.Component;

@Component
public class SampleBean {

    private SampleBean()
    {
        System.out.println("SampleBean Initialised");
    }

    public void getInfo()
    {
        System.out.println("SampleBean Giving service from getInfo()");
    }
}
