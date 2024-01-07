package io.faqb.links.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LinksRequest {

	@JsonProperty("linkId")
	private int linkId;

	@JsonProperty("linkName")
	private String linkName;

	@JsonProperty("url")
	private String url;

	@JsonProperty("userId")
	private int userId;
}
