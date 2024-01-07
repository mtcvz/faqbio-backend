package io.faqb.socialmedias.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

@Data
public class SocialMedias {

	private int userId;

	private String whatsapp;

	private String facebook;

	private String twitter;

	private String instagram;

	private String youtube;

	private String tiktok;

	private String website;
}
