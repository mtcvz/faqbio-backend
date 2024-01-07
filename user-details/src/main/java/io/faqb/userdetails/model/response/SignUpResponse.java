package io.faqb.userdetails.model.response;

import lombok.Data;

@Data
public class SignUpResponse {

	private boolean status;

	private String message;

	private int userId;
}
