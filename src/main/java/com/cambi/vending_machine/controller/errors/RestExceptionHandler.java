package com.cambi.vending_machine.controller.errors;

import com.cambi.vending_machine.dao.exceptions.CreateException;
import com.cambi.vending_machine.dao.exceptions.DeleteException;
import com.cambi.vending_machine.dao.exceptions.GetException;
import com.cambi.vending_machine.dao.exceptions.UpdateException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice()
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CreateException.class)
    public ResponseEntity<Object> handleCreateException(HttpServletRequest req, CreateException e) {
        String error = e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(GetException.class)
    public ResponseEntity<Object> handleGetException(HttpServletRequest req, GetException e) {
        String error = e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(UpdateException.class)
    public ResponseEntity<Object> handleUpdateException(HttpServletRequest req, UpdateException e) {
        String error = e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

    @ExceptionHandler(DeleteException.class)
    public ResponseEntity<Object> handleDeleteException(HttpServletRequest req, DeleteException e) {
        String error = e.getMessage();
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<Object> handleNoSuchElementException(HttpServletRequest req,NoSuchElementException ex){
//        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND);
//        response.setMessage("The row for address is not existent: " + req.getRequestURI());
//        return buildResponseEntity(response);
//    }

//        @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
//    public ResponseEntity<Object> handleSqlIntegrityException(HttpServletRequest req,SQLIntegrityConstraintViolationException ex){
//
//        String error = "Unable to submit post: " + ex.getMessage();
//        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
//    }

//    @ExceptionHandler(DataAccessException.class)
//    public ResponseEntity<Object> handleDataAccessException(HttpServletRequest req, DataAccessException e) {
//        String error = "An error occurred adding this to the database";
//        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, error));
//    }

    private ResponseEntity<Object> buildResponseEntity(ErrorResponse errorResponse){
        return new ResponseEntity<Object>(errorResponse, errorResponse.getStatus());
    }

}
