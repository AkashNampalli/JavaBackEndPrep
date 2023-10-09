package com.akashprojects.springbootcore.ex1.dao;

import org.springframework.stereotype.Repository;

@Repository
public class SampleDAO {

    private SampleDAO()
    {
        System.out.println("SampleDAO Object created !!!");
    }

    public void  getDAOInfo()
    {
        System.out.println("SampleDAO: I do database interactions");
    }
}
