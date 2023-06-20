package com.huimu.flowerplant.common.exception;

import com.huimu.flowerplant.common.web.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionControllerAdvice {

    @ExceptionHandler({BusinessException.class})
    public Response<Void> handleBusinessException(BusinessException e) {
        Throwable cause = e.getCause();
        if (cause != null) {
            log.error(e.getMessage(), cause);
        } else {
            log.error("BusinessException: ", e);
        }

        return Response.fail(e.getCode(), e.getMsg(), null);
    }

    @ExceptionHandler({BindException.class})
    public Response<Void> handleBindException(BindException e) {
        log.error("BindException: ", e);

        StringBuilder errorMsg = new StringBuilder();
        for (FieldError error : e.getFieldErrors()) {
            errorMsg.append(error.getField()).append(":").append(error.getDefaultMessage()).append(";");
        }
        String msg = errorMsg.substring(0, errorMsg.length());

        return Response.fail(HmExceptionEnum.SYS_CHECK_ERROR.getCode(), msg, null);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException: ", e);

        StringBuilder errorMsg = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errorMsg.append(error.getField()).append(":").append(error.getDefaultMessage()).append(";");
        }
        String msg = errorMsg.substring(0, errorMsg.length());

        return Response.fail(HmExceptionEnum.SYS_CHECK_ERROR.getCode(), msg, null);
    }

    @ExceptionHandler({Exception.class})
    public Response<Void> handleException(Exception e) {
        Throwable cause = e.getCause();
        if (cause != null) {
            log.error(e.getMessage(), cause);
        } else {
            log.error("", e);
        }

        return Response.fail(HmExceptionEnum.SYS_ERROR.getCode(), HmExceptionEnum.SYS_ERROR.getMsg(), null);
    }

}
