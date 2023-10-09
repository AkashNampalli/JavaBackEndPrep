package com.akashprojects.springbootcore.ex1.service;

import com.akashprojects.springbootcore.ex1.dao.SampleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private SampleDAO sampleDAO;

     // Setter Injection
    @Autowired
    public void setSampleDAO(SampleDAO sampleDAO)
    {
        this.sampleDAO = sampleDAO;
    }
    private SampleService()
    {
        System.out.println("SampleService Object created !!!");
    }

    public void getServiceInfo()
    {
        System.out.println("SampleService: I do Business logics");
        sampleDAO.getDAOInfo();
    }
}
