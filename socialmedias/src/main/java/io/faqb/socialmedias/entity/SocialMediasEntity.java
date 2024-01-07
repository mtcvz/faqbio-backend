package io.faqb.socialmedias.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="social_medias", schema = "faqbiodb")
public class SocialMediasEntity {

	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "WHATSAPP")
	private String whatsapp;

	@Column(name = "FACEBOOK")
	private String facebook;

	@Column(name = "TWITTER")
	private String twitter;

	@Column(name = "INSTAGRAM")
	private String instagram;

	@Column(name = "YOUTUBE")
	private String youtube;

	@Column(name = "TIKTOK")
	private String tiktok;

	@Column(name = "WEBSITE")
	private String website;
}
