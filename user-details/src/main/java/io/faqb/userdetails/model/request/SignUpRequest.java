package io.faqb.userdetails.model.request;

import lombok.Data;

@Data
public class SignUpRequest {

	private String userName;
	private String mail;
	private String password;
}

