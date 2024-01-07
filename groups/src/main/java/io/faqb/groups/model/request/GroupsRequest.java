package io.faqb.groups.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GroupsRequest {

	@JsonProperty("groupId")
	private int groupId;

	@JsonProperty("groupName")
	private String groupName;

	@JsonProperty("groupIcon")
	private String groupIcon;

	@JsonProperty("userId")
	private int userId;
}
