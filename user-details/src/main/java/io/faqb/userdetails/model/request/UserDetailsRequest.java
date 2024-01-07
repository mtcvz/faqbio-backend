package io.faqb.userdetails.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDetailsRequest {

	@JsonProperty("userId")
	private int userId;

	@JsonProperty("username")
	private String username;

	@JsonProperty("mail")
	private String mail;

}
