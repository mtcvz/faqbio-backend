package io.faqb.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.faqb.auth.entity.UserEntity;
import io.faqb.auth.model.User;
import io.faqb.auth.model.UserRequest;
import io.faqb.auth.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class HomeController {

	private final UserService userService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/")
	public String home(){
		return ("<h1>Welcome</h1>");
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/auth")
	public User user(){
		Object myUserDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		int id = 0; 
		String username = "";
		String mail = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(myUserDetails);
			JsonNode jsonNode = mapper.readTree(json);
			JsonNode idNode = jsonNode.get("userId");
			id = idNode.asInt();
			JsonNode usernameNode = jsonNode.get("username");
			username = usernameNode.asText();
			JsonNode mailNode = jsonNode.get("mail");
			mail = mailNode.asText();
		}
		catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return new User(id,username,mail);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/admin")
	public String admin(){
		return ("<h1>Welcome admin</h1>");
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/signUp")
	public User signUp(@RequestBody UserRequest request){
		UserEntity entity = userService.saveUser(request);
		return new User(entity.getUserId(),entity.getUserName());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/getUser")
	public User getUser(@RequestBody UserRequest request){
		UserEntity entity = userService.getUser(request);
		if (entity == null)
			return null;
		return new User(entity.getUserId(),entity.getUserName());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/updateUsername")
	public User updateUsername(@RequestBody UserRequest request){
		UserEntity entity = userService.updateUsername(request);
		return new User(entity.getUserId(),entity.getUserName());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/updateMail")
	public User updateMail(@RequestBody UserRequest request){
		UserEntity entity = userService.updateMail(request);
		return new User(entity.getUserId(),entity.getUserName());
	}

	@CrossOrigin(origins = "*")
	@PostMapping("/updatePassword")
	public User updatePassword(@RequestBody UserRequest request){
		UserEntity entity = userService.updatePassword(request);
		return new User(entity.getUserId(),entity.getUserName());
	}
}

