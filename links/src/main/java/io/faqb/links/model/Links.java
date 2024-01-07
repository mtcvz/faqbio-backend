package io.faqb.links.model;

import lombok.Data;

@Data
public class Links {

	private int linkId;

	private String linkName;

	private String url;

	private int userId;
}
