package io.faqb.questions.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="questions", schema = "faqbiodb")
public class QuestionsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private int questionId;

	@Column(name = "QUESTION")
	private String question;

	@Column(name = "ANSWER")
	private String answer;

	@Column(name = "GROUP_ID")
	private Integer groupId;

	@Column(name = "GROUP_NAME")
	private String groupName;

	@Column(name = "USER_ID")
	private int userId;
}
