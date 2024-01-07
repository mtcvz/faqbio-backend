package io.faqb.userdetails.service;

import io.faqb.userdetails.entity.UserEntity;
import io.faqb.userdetails.model.request.SignUpRequest;
import io.faqb.userdetails.model.response.SignUpResponse;
import io.faqb.userdetails.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	public SignUpResponse saveUser(SignUpRequest request){
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(request.getUserName());
		//userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
		userEntity.setActive(true);
		userEntity.setRoles("USER");
		SignUpResponse response = new SignUpResponse();
		try{
			userRepository.save(userEntity);
		} catch (Exception e){
			log.error("There is an error while saving user.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setUserId(userEntity.getUserId());
		return response;
	}

}
