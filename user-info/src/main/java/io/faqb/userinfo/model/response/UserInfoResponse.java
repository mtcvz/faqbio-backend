package io.faqb.userinfo.model.response;

import lombok.Data;

@Data
public class UserInfoResponse {

	private boolean status;

	private String message;

	private Object data;
}
