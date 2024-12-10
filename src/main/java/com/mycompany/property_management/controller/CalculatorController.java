package com.mycompany.property_management.controller;

import com.mycompany.property_management.dto.CalculatorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

   @GetMapping("/add")
   public Double add(@RequestParam("num1") Double num1, @RequestParam("num2") Double num2) {
      return num1+num2;
   }

   @GetMapping("/sub/{num1}/{num2}")//map the values of the url to java variable by Path variable method
   public Double subtract(@PathVariable("num1")Double num1, @PathVariable("num2") Double num2) {
      Double result = null;
      if (num1 > num2) {
         result = num1 - num2;
      } else {
         result = num2 - num1;
      }
      return result;
   }

   @PostMapping("/mul")
   static ResponseEntity<Double> multiple(@RequestBody CalculatorDTO calculatorDTO) {
      Double result1 = null;
      Double result2 = null;
      Double result = null;
      result1 = calculatorDTO.getNum1() * calculatorDTO.getNum2();
      result2 = calculatorDTO.getNum3() * calculatorDTO.getNum4();
      result = result1 * result2;

      ResponseEntity<Double> responseEntity = new ResponseEntity<Double>(result, HttpStatus.CREATED);
      return responseEntity;
   }
}
