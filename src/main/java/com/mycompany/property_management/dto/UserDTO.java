package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserDTO {
   private long id;
   private String ownerName;
   @NotNull(message = "OwnerEmail is mandatory")
   @Size(min = 8, max = 50, message = "Owner Email is between 8 and 50 charactors")
   private String ownerEmail;
   @NotNull(message = "password cannot be null")
   @NotBlank(message = "password cannot be empty")
   private String password;
   private String phone;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getOwnerName() {
      return ownerName;
   }

   public void setOwnerName(String ownerName) {
      this.ownerName = ownerName;
   }

   public String getOwnerEmail() {
      return ownerEmail;
   }

   public void setOwnerEmail(String ownerEmail) {
      this.ownerEmail = ownerEmail;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}
