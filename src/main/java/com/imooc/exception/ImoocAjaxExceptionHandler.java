package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;

import javax.servlet.http.HttpServletRequest;

//@RestControllerAdvice
public class ImoocAjaxExceptionHandler {
    //@ExceptionHandler(value = Exception.class)
    public IMoocJSONResult defaultErrorHandler(HttpServletRequest req,Exception e) throws Exception{
        e.printStackTrace();
        return IMoocJSONResult.errorException(e.getMessage());
    }
}
