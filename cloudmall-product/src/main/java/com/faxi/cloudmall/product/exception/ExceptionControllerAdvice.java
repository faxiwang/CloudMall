package com.faxi.cloudmall.product.exception;

import com.faxi.common.utis.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/** 统一处理异常
 * @date 2021-07-26 21:33
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.faxi.cloudmall.product.controller")
public class ExceptionControllerAdvice {

    /**
     * 处理校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleVaildException(MethodArgumentNotValidException e){
        log.error("数据校验异常{}",e.getMessage());
        Map<String,String> errMap = new HashMap<>();
        BindingResult result = e.getBindingResult();
        result.getFieldErrors().forEach(err ->{
            errMap.put(err.getField(),err.getDefaultMessage());
        });

        return R.failed(errMap, HttpStatus.SC_BAD_REQUEST,"数据校验出现错误！");
    }

    /**
     * 处理全部异常 在上面异常未精确捕获的情况下执行
     */
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable){
        log.error(throwable.getMessage(),throwable);
        return R.failed("服务器出现错误！");
    }
}
