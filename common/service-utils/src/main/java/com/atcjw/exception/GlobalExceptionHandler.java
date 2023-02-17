package com.atcjw.exception;

import com.atcjw.result.RetJson;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     */
    @ExceptionHandler(Exception.class)
    public RetJson error(Exception e) {
        e.printStackTrace();
        return RetJson.fail("出现了异常");
    }

    /**
     * 特定异常处理
     */
    @ExceptionHandler(ArithmeticException.class)
    public RetJson arithmeticException(ArithmeticException e) {
        e.printStackTrace();
        return RetJson.fail("出现了 ArithmeticException 异常");
    }

    /**
     * 自定义异常处理
     */
    @ExceptionHandler(GrainClassesException.class)
    public RetJson grainClassesException(GrainClassesException e) {
        e.printStackTrace();
        return RetJson.fail(e.getCode(), e.getMessage());
    }
}
