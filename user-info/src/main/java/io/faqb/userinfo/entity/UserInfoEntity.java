package io.faqb.userinfo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user_info")
public class UserInfoEntity {
	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "ABOUT")
	private String about;
}