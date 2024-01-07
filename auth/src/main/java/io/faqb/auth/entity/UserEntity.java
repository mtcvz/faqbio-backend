package io.faqb.auth.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "users", schema = "faqbiodb")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACTIVE")
	private boolean active;

	@Column(name = "ROLES")
	private String roles;

	@Column(name = "MAIL")
	private String mail;

}
