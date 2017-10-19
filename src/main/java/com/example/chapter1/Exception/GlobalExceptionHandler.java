package com.example.chapter1.Exception;

import com.example.chapter1.Entry.ErrorEntry;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {


    public static final String DEFAULT_ERROR_PAGE = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {

        ModelAndView mav = new ModelAndView();

        mav.addObject("exception", e);

        mav.addObject("url", req.getRequestURL());

        mav.setViewName(DEFAULT_ERROR_PAGE);

        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Object myExceptionHandler(Exception e, HttpServletRequest req) {

        ErrorEntry error = new ErrorEntry();

        error.setCode(ErrorEntry.ERROR);
        error.setMessage(e.getMessage());
        error.setUrl(req.getRequestURL().toString());
        error.setData("some data");

        return error;
    }

}
