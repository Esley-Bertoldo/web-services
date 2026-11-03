package com.esley.web_services_springboot.resources.exceptions;

import com.esley.web_services_springboot.services.exceptions.DatabaseException;
import com.esley.web_services_springboot.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice // vai indentificar as exceções que acontecerem para que esse objeto possa executar um possivel tratamento
public class ResourceExceptionHandler extends RuntimeException {

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        String error = "Resouce not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError SE =  new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(SE);
    }

    @ExceptionHandler(DatabaseException.class)
    ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError SE =  new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(SE);
    }
}
