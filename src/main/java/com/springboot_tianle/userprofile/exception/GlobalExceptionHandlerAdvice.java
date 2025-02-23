package com.springboot_tianle.userprofile.exception;

import com.springboot_tianle.userprofile.pojo.ResponseMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice //统一处理
public class GlobalExceptionHandlerAdvice {
    //*@RestControllerAdvice 是 Spring Boot 全局异常处理（Global Exception Handling）的一部分，
    //*它的作用是 拦截所有 @RestController 抛出的异常，并返回自定义的 JSON 响应。
    //*触发时机: 当 Spring 处理请求时，如果 Controller 或 Service 层发生 Exception，这个方法会被触发。
    Logger log = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);

    @ExceptionHandler({Exception.class}) //?进行什么异常的统一处理，在这里是Exception
    public ResponseMessage handlerException(Exception e, HttpServletRequest request, HttpServletResponse response){
        //记录日志
        log.error("统一异常： ", e);
        return new ResponseMessage(500, e.getMessage(), null );
    }

    // 2️⃣ 处理参数校验失败
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseMessage<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseMessage<>(400, "参数校验失败", errors);
    }

    // 3️⃣ 处理非法参数
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseMessage handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseMessage(400, e.getMessage(), null);
    }

    // 4️⃣ 处理数据库唯一键冲突
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseMessage handleDatabaseException(SQLIntegrityConstraintViolationException e) {
        return new ResponseMessage(409, "数据库唯一键冲突：" + e.getMessage(), null);
    }
}
