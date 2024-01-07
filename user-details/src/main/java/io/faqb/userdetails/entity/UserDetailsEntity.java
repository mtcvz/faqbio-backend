package io.faqb.userdetails.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="user_details", schema = "faqbiodb")
public class UserDetailsEntity {

	@Id
	@Column(name = "USER_ID")
	private int userId;

	@Column(name = "username")
	private String username;

	@Column(name = "mail")
	private String mail;

}
