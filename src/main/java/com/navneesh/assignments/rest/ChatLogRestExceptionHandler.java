package com.navneesh.assignments.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ChatLogRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ChatLogErrorResponse> handleException(MessageNotFoundException exc){
        ChatLogErrorResponse error = new ChatLogErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ChatLogErrorResponse> handleException(UserNotFoundException exc){
        ChatLogErrorResponse error = new ChatLogErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ChatLogErrorResponse> handleException(Exception exc){
        ChatLogErrorResponse error = new ChatLogErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


}
