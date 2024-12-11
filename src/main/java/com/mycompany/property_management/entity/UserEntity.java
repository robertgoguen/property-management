package com.mycompany.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USER_TABLE")

@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
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

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getOwnerEmail() {
      return ownerEmail;
   }

   public void setOwnerEmail(String ownerEmail) {
      this.ownerEmail = ownerEmail;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }
}

