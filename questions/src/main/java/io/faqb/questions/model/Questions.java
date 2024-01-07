package io.faqb.questions.model;

import lombok.Data;

@Data
public class Questions {

	private int questionId;

	private String question;

	private String answer;

	private Integer groupId;

	private String groupName;

	private int userId;
}
