package io.faqb.questions.model.response;

import io.faqb.questions.model.Questions;
import lombok.Data;

import java.util.List;

@Data
public class QuestionsResponse {
	private boolean status;

	private String message;

	private List<Questions> data;
}
