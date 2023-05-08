package com.devsuperior.empdep.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler
{
    /**
     * validation
     *
     * @param e MethodArgumentNotValidException
     * @param request HttpServletRequest
     * @return ResponseEntity<ValidationError>
     */
    @ExceptionHandler( MethodArgumentNotValidException.class )
    public ResponseEntity<ValidationError> validation( MethodArgumentNotValidException e, HttpServletRequest request )
    {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError error = new ValidationError();
        error.setTimestamp( Instant.now() );
        error.setStatus( status.value() );
        error.setError( "Validation exception" );
        error.setMessage( e.getMessage() );

        for( FieldError fieldError : e.getBindingResult().getFieldErrors() )
        {
            error.addError( fieldError.getField(), fieldError.getDefaultMessage() );
        }

        error.setPath( request.getRequestURI() );

        return ResponseEntity.status( status ).body( error );
    }
}
