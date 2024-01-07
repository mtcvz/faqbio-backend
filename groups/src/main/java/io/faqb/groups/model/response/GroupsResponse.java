package io.faqb.groups.model.response;

import io.faqb.groups.model.Groups;
import lombok.Data;

import java.util.List;

@Data
public class GroupsResponse {
	private boolean status;

	private String message;

	private List<Groups> data;
}
