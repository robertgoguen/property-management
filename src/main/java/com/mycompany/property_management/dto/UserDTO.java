package com.mycompany.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class UserDTO {
   private long id;
   private String ownerName;
   private String phone;
   private String ownerEmail;
   private String password;

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
