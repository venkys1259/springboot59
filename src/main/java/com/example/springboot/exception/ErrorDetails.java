package com.example.springboot.exception;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ErrorDetails {
    private Integer status;
    private String message;
    //private String stackTrace;
    private List<ValidationError> errors;
    private static class ValidationError {
        private final String field;
        private final String message;
        ValidationError(String field,String message){
            this.field = field;
            this.message = message;
        }
        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }
    }

    public ErrorDetails(Integer status,String message) {
        super();
        this.status = status;
        this.message = message;
      //  this.stackTrace = stackTrace;
    }


    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

   /* public String getStackTrace() {
        return stackTrace;
    }*/

    public void addValidationError(String field, String message){
        if(Objects.isNull(errors)){
            errors = new ArrayList<>();
        }
        errors.add(new ValidationError(field, message));
    }

    public List<ValidationError> getErrors() {
        return errors;
    }
}
