package io.faqb.socialmedias.model.response;

import io.faqb.socialmedias.model.SocialMedias;
import lombok.Data;


@Data
public class SocialMediasResponse {
	private boolean status;

	private String message;

	private SocialMedias data;
}
