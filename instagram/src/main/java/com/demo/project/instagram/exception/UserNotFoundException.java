package com.demo.project.instagram.exception;


public class UserNotFoundException extends Exception{

    public UserNotFoundException(){

    }

    public UserNotFoundException(String exceptionMsg){
    super(exceptionMsg);
    }
}
