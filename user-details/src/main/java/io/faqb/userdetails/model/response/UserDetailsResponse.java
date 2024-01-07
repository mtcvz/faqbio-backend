package io.faqb.userdetails.model.response;

import io.faqb.userdetails.model.UserDetails;
import lombok.Data;

@Data
public class UserDetailsResponse {
	private boolean status;

	private String message;

	private UserDetails data;
}
