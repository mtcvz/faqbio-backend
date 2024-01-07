package io.faqb.userinfo.controller;

import io.faqb.userinfo.model.request.UserInfoRequest;
import io.faqb.userinfo.model.response.UserInfoResponse;
import io.faqb.userinfo.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class UserInfoController {

	private final UserInfoService userInfoService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getUserInfo")
	public UserInfoResponse getUserInfo(@RequestBody UserInfoRequest request){
		return userInfoService.getUserInfo(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setUserInfo")
	public UserInfoResponse setUserInfo(@RequestBody UserInfoRequest request){
		return userInfoService.setUserInfo(request);
	}

}
