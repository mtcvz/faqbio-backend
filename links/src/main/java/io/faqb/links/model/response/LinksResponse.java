package io.faqb.links.model.response;

import io.faqb.links.model.Links;
import lombok.Data;

import java.util.List;

@Data
public class LinksResponse {
	private boolean status;

	private String message;

	private List<Links> data;
}
