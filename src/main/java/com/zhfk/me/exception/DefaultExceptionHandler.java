package com.zhfk.me.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler()
    @ResponseBody
    String handException(Exception e){
        return String.format("DefaultExceptionHandler@handException ===> %s",e.getMessage());
    }

}
