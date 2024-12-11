package com.mycompany.property_management.service.impl;

import com.mycompany.property_management.converter.UserConverter;
import com.mycompany.property_management.dto.UserDTO;
import com.mycompany.property_management.entity.UserEntity;
import com.mycompany.property_management.exception.BusinessException;
import com.mycompany.property_management.exception.ErrorModel;
import com.mycompany.property_management.repository.UserRepository;
import com.mycompany.property_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private UserConverter userConverter;

   @Override
   public UserDTO register(UserDTO userDTO) {
      Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmail(userDTO.getOwnerEmail());
      if (optionalUserEntity.isPresent()){
         List<ErrorModel> errorModelList = new ArrayList<>();
         ErrorModel errorModel = new ErrorModel();
         errorModel.setCode("EMAIL_ALREADY_EXISTS");
         errorModel.setMessage("The Email you are trying to register, already exists");
         errorModelList.add(errorModel);
         throw new BusinessException(errorModelList);
      }

      UserEntity userEntity = userConverter.convertDTOToEntity(userDTO);
      userEntity = userRepository.save(userEntity);
      userDTO = userConverter.convertEntityToDTo(userEntity);
      return userDTO;
   }

   @Override
   public UserDTO login(String email, String password) {
      Optional<UserEntity> optionalUserEntity = userRepository.findByOwnerEmailAndPassword(email, password);

      if (optionalUserEntity.isPresent()) {
         return userConverter.convertEntityToDTo(optionalUserEntity.get());
      } else {
         List<ErrorModel> errorModelList = new ArrayList<>();
         ErrorModel errorModel = new ErrorModel();
         errorModel.setCode("INVALID_LOGIN");
         errorModel.setMessage("Incorrect Email or Password");
         errorModelList.add(errorModel);
         throw new BusinessException(errorModelList);
      }
   }
}
