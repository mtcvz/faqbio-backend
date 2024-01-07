package io.faqb.userdetails.controller;

import io.faqb.userdetails.model.request.SignUpRequest;
import io.faqb.userdetails.model.request.UserDetailsRequest;
import io.faqb.userdetails.model.response.SignUpResponse;
import io.faqb.userdetails.model.response.UserDetailsResponse;
import io.faqb.userdetails.service.UserDetailsService;
import io.faqb.userdetails.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class UserDetailsController {

	private final UserDetailsService userDetailsService;
	private final UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getUserDetails")
	public UserDetailsResponse getUserDetails(@RequestBody UserDetailsRequest request){
		return userDetailsService.getUserDetails(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/isUsernameExist")
	public UserDetailsResponse isUsernameExist(@RequestBody UserDetailsRequest request){
		return userDetailsService.isUsernameExist(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/isMailExist")
	public UserDetailsResponse isMailExist(@RequestBody UserDetailsRequest request){
		return userDetailsService.isMailExist(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signUp")
	public UserDetailsResponse signUp(@RequestBody SignUpRequest request){
		SignUpResponse signUpResponse = userService.saveUser(request);
		if (!signUpResponse.isStatus()){
			UserDetailsResponse response = new UserDetailsResponse();
			response.setStatus(false);
			response.setMessage("There is an error while saving user.");
			return response;
		}
		UserDetailsRequest userDetailsRequest = new UserDetailsRequest();
		userDetailsRequest.setUserId(signUpResponse.getUserId());
		userDetailsRequest.setUsername(request.getUserName());
		userDetailsRequest.setMail(request.getMail());
		return userDetailsService.saveUserDetails(userDetailsRequest);
	}

}


