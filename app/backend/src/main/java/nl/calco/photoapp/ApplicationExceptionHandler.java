package nl.calco.photoapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import nl.calco.photoapp.exception.ErrorResponse;
import nl.calco.photoapp.exception.EntityNotFoundException;

@ControllerAdvice
public class ApplicationExceptionHandler {
    
    // Exception override for requesting (get) a non excisting entity (get request for non existing id) 
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse(Arrays.asList(ex.getMessage()));  
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Exception override for custom validation errors in the request body (all jakarta.validation errors like @Size(max = 30, message = "first name is too long"))
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (ObjectError err : ex.getBindingResult().getAllErrors()) {
            errors.add(err.getDefaultMessage());
        } 
        ErrorResponse error = new ErrorResponse(errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Exception override for deleting a non excisting entity did not trigger a global error. 
    // Should give a EmptyResultDataAccessException. 
    // I have these exceptions handled inside the controller classes in the delete methods.
    // If someone can explain me why EmptyResultDataAccessException is not triggered I'd love to know.
}
