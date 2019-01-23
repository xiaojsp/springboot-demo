package com.imooc.exception;

import com.imooc.pojo.IMoocJSONResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ImoocExceptionHandler {
    public static final String ERROR_VIEW="error";

   /* @ExceptionHandler(value= Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response,Exception e) throws Exception{
        e.printStackTrace();
        ModelAndView mav= new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",request.getRequestURL());
        mav.setViewName(ERROR_VIEW);
        return mav;
    }*/
    @ExceptionHandler(value= Exception.class)
    public Object errorHandler(HttpServletRequest request, HttpServletResponse response, Exception e) throws Exception{
        e.printStackTrace();
        if(isAjax(request)){
            return IMoocJSONResult.errorException(e.getMessage());
        }else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", request.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     *
     * @Title: IMoocExceptionHandler.java
     * @Package com.imooc.exception
     * @Description: 判断是否是ajax请求
     *
     */
    private static boolean isAjax(HttpServletRequest HttpRequest) {
        return (HttpRequest.getHeader("X-Requested-With") != null) && "XMLHttpRequest".equals(HttpRequest.getHeader("X-Requested-With").toString());
    }
}
