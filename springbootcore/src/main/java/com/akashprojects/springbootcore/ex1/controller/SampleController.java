package com.akashprojects.springbootcore.ex1.controller;

import com.akashprojects.springbootcore.ex1.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SampleController {

    private SampleService sampleService;

    @Autowired
    public SampleController(SampleService sampleService)
    {
        this.sampleService = sampleService;
    }

    public void  getControllerInfo()
    {
        System.out.println("SampleController: I do Front End Interaction");
        sampleService.getServiceInfo();
    }
}
