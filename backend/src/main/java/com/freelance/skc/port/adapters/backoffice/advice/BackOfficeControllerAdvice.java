package com.freelance.skc.port.adapters.backoffice.advice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
@CrossOrigin(origins = "*")
public class BackOfficeControllerAdvice extends ResponseEntityExceptionHandler {

    // Handle IllegalStateException and IllegalArgumentException
    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class, UnsupportedOperationException.class})
    public ResponseEntity<Object> handleIllegal(@NotNull Exception ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("details", ex.getMessage());
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        HashMap<String, String> errors = new HashMap<>();
        // Check if the cause is an InvalidFormatException (caused by an invalid enum value)
        if (ex.getCause() instanceof InvalidFormatException invalidFormatException) {
            Class<?> targetType = invalidFormatException.getTargetType();

            // Check if the target type is an enum
            if (targetType.isEnum()) {
                String invalidValue = invalidFormatException.getValue().toString();
                String validValues = Arrays.stream(targetType.getEnumConstants())
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));

                String message = String.format("Invalid value '%s' for enum '%s'. Valid values are: %s.",
                        invalidValue, targetType.getSimpleName(), validValues);

                errors.put("details", message);
                // Return a custom response entity with a detailed error message
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
            }
        }

        // For any other errors, fallback to default handling
        return super.handleHttpMessageNotReadable(ex, headers, status, request);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            @NotNull HttpHeaders headers,
            @NotNull HttpStatusCode status,
            @NotNull WebRequest request
    ) {
        Map<String, HashMap<String, String>> finalResponseMap = new HashMap<>();
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        finalResponseMap.put("errors", errors);
        return new ResponseEntity<>(finalResponseMap, HttpStatus.BAD_REQUEST);
    }
}
