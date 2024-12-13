package com.mycompany.property_management.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {

   private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv) {
      List<ErrorModel> errorModelList = new ArrayList<>();
      List<FieldError>  fieldErrorList = manv.getBindingResult().getFieldErrors();
      ErrorModel errorModel;

      for(FieldError fe: fieldErrorList) {
         logger.error("Inside field validation: {} - {}", fe.getField(), fe.getDefaultMessage());
         errorModel = new ErrorModel();
         errorModel.setCode(fe.getField());
         errorModel.setMessage(fe.getDefaultMessage());
         errorModelList.add(errorModel);
      }
      return new ResponseEntity<List<ErrorModel>>(errorModelList, HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(BusinessException.class)
   public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException) {
      System.out.println("BusinessException is thrown");
      return new ResponseEntity<List<ErrorModel>>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
   }
}
