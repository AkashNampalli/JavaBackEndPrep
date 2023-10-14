package com.demo.project.instagram.exception;


public class AuthorizationException extends Exception{

    public AuthorizationException(){

    }

    public AuthorizationException(String exceptionMsg){
    super(exceptionMsg);
    }
}
