package com.demo.project.instagram.exception;

import lombok.NoArgsConstructor;


public class PostNotExistException extends Exception{

    public PostNotExistException(){

    }

    public PostNotExistException(String exceptionMsg){
    super(exceptionMsg);
    }
}
