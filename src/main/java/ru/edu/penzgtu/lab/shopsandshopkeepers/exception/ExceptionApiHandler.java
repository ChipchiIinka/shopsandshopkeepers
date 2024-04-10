package ru.edu.penzgtu.lab.shopsandshopkeepers.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.BaseResponseService;
import ru.edu.penzgtu.lab.shopsandshopkeepers.exception.baseresponse.ResponseWrapper;


@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionApiHandler {
    private final BaseResponseService baseResponseService;

    @ExceptionHandler(Throwable.class)
    public ResponseWrapper<?> handleOtherException(Throwable t){
        return baseResponseService.wrapErrorResponse(new LabWorkException(ErrorType.COMMON_ERROR, t));
    }

    @ExceptionHandler(LabWorkException.class)
    public ResponseWrapper<?> handleLabWorkException(LabWorkException exception){
        return baseResponseService.wrapErrorResponse(exception);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class, MethodArgumentNotValidException.class})
    public ResponseWrapper<?> handleValidationException(Exception e){
        return baseResponseService.wrapErrorResponse(new LabWorkException(ErrorType.CLIENT_ERROR, e));
    }
}
