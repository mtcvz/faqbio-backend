package io.faqb.userinfo.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserInfoRequest {

	@JsonProperty("userId")
	private int userId;

	@JsonProperty("username")
	private String userName;

	@JsonProperty("title")
	private String title;

	@JsonProperty("about")
	private String about;
}

