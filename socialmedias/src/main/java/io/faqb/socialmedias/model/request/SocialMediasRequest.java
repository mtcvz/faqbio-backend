package io.faqb.socialmedias.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SocialMediasRequest {

	@JsonProperty("userId")
	private int userId;

	@JsonProperty("whatsapp")
	private String whatsapp;

	@JsonProperty("facebook")
	private String facebook;

	@JsonProperty("twitter")
	private String twitter;

	@JsonProperty("instagram")
	private String instagram;

	@JsonProperty("youtube")
	private String youtube;

	@JsonProperty("tiktok")
	private String tiktok;

	@JsonProperty("website")
	private String website;
}
