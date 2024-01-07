package io.faqb.questions.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuestionsRequest {

	@JsonProperty("questionId")
	private int questionId;

	@JsonProperty("question")
	private String question;

	@JsonProperty("answer")
	private String answer;

	@JsonProperty("groupId")
	private int groupId;

	@JsonProperty("groupName")
	private String groupName;

	@JsonProperty("userId")
	private int userId;
}
