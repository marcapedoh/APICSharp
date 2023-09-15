package com.example.APICSharp.Handlers;

import com.example.APICSharp.Exceptions.EntityNotFoundException;
import com.example.APICSharp.Exceptions.InvalidEntityException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDAO> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notfound=HttpStatus.NOT_FOUND;
        final ErrorDAO errorDAO = ErrorDAO.builder()
                .codes(exception.getErrorcodes())
                .httpcode(notfound.value())
                .message(exception.getMessage())
                .build();

        return new ResponseEntity<>(errorDAO,notfound);

    }
    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDAO> handleException(InvalidEntityException exception,WebRequest webRequest){
        final HttpStatus badRequest=HttpStatus.BAD_REQUEST;

        final ErrorDAO errorDAO = ErrorDAO.builder()
                .codes(exception.getErrorCodes())
                .httpcode(badRequest.value())
                .message(exception.getMessage())
                .error(exception.getError())
                .build();

        return new ResponseEntity<>(errorDAO,badRequest);
    }
}
