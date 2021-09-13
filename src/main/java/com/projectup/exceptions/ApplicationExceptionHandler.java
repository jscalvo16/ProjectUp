package com.projectup.exceptions;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler {
    //es totalmente global sim importar en que archivo se encuentre
    @ExceptionHandler(ApplicatioException.class)
    public String handleException(){
        System.out.println("En la gobal exception handler del controlador LoginCotroller ");
        return "error";
    }
}

