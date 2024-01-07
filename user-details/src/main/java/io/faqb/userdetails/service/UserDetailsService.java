package io.faqb.userdetails.service;

import io.faqb.userdetails.entity.UserDetailsEntity;
import io.faqb.userdetails.entity.UserEntity;
import io.faqb.userdetails.model.UserDetails;
import io.faqb.userdetails.model.request.UserDetailsRequest;
import io.faqb.userdetails.model.response.UserDetailsResponse;
import io.faqb.userdetails.repository.UserDetailsRepository;
import io.faqb.userdetails.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserDetailsService {

	private final UserDetailsRepository userDetailsRepository;
	private final UserRepository userRepository;

	public UserDetailsResponse getUserDetails(UserDetailsRequest request){
		int userId = request.getUserId();
		Optional<UserEntity> entity;
		entity = userRepository.findById(userId);
		UserDetailsResponse response = new UserDetailsResponse();
		if (!entity.isPresent()){
			response.setMessage("UserDetails not found. userId: " + userId);
			response.setStatus(true);
			return response;
		}
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);
		userDetails.setUsername(entity.get().getUserName());
		userDetails.setMail(entity.get().getMail());
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(userDetails);
		return response;
	}

	public UserDetailsResponse isUsernameExist(UserDetailsRequest request){
		String username = request.getUsername();
		Optional<UserEntity> entity;
		entity = userRepository.findByUserName(username);
		UserDetailsResponse response = new UserDetailsResponse();
		if (entity.isPresent()){
			response.setMessage("This username is already in use.");
			response.setStatus(false);
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

	public UserDetailsResponse isMailExist(UserDetailsRequest request){
		String mail = request.getMail();
		Optional<UserEntity> entity;
		entity = userRepository.findByMail(mail);
		UserDetailsResponse response = new UserDetailsResponse();
		if (entity.isPresent()){
			response.setMessage("This mail is already in use.");
			response.setStatus(false);
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

	public UserDetailsResponse saveUserDetails(UserDetailsRequest request){
		UserDetailsEntity entity = new UserDetailsEntity();
		entity.setUserId(request.getUserId());
		entity.setUsername(request.getUsername());
		entity.setMail(request.getMail());
		UserDetailsResponse response = new UserDetailsResponse();

		try{
			userDetailsRepository.save(entity);
		} catch (Exception e){
			log.error("There is an error while saving user details.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(request.getUserId());
		userDetails.setUsername(request.getUsername());
		userDetails.setMail(request.getMail());
		response.setData(userDetails);
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}
}
