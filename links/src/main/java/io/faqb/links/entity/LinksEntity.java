package io.faqb.links.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="links", schema = "faqbiodb")
public class LinksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LINK_ID")
	private int linkId;

	@Column(name = "LINK_NAME")
	private String linkName;

	@Column(name = "URL")
	private String url;

	@Column(name = "USER_ID")
	private int userId;
}
