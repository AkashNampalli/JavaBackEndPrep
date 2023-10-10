package com.akashprojects.springbootcore.ex2.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAO {

    private BufferedReader reader;

    private String fileName;

    private UserDAO() {
        System.out.println(" Instantiation Phase: \n UserDAO Object Created");
    }

    @Value("${file.name}")
    public void setFileName( String fileName)
    {
        System.out.println("Dependency Injection completed");
        this.fileName = fileName;
    }


    @PostConstruct
    public void  init() throws FileNotFoundException
    {
        System.out.println(" \n Initialisation Phase :init() method invoked: Initialisation logic executed --> fileName = "+fileName);
        reader = new BufferedReader(new FileReader("src/main/resources/"+fileName));
    }

    public List<String> getUserInfo() throws IOException
    {
        System.out.println(" \n Servicing Phase: DAO Bean serving request");
        List<String> users = new ArrayList<>();
        String currentLine;
        while( (currentLine = reader.readLine()) != null)
        {
            users.add(currentLine);
        }

        return users;
    }

    @PreDestroy
    public void destroy() throws IOException
    {
        System.out.println(" \n Destruction Phase: reader object is closed");

        if(reader != null)
              reader.close();
    }


}
