package io.faqb.questions.controller;

import io.faqb.questions.model.request.QuestionsRequest;
import io.faqb.questions.model.response.QuestionsResponse;
import io.faqb.questions.service.QuestionsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class QuestionsController {

	private final QuestionsService questionsService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getQuestions")
	public QuestionsResponse getQuestions(@RequestBody QuestionsRequest request){
		return questionsService.getQuestions(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setQuestions")
	public QuestionsResponse setQuestions(@RequestBody QuestionsRequest request){
		return questionsService.setQuestions(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateQuestions")
	public QuestionsResponse updateQuestions(@RequestBody QuestionsRequest request){
		return questionsService.updateQuestions(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteQuestions/{id}")
	public QuestionsResponse deleteQuestions(@PathVariable int id){
		return questionsService.deleteQuestions(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateGroupOfQuestions")
	public QuestionsResponse updateGroupOfQuestions(@RequestBody QuestionsRequest request){
		return questionsService.updateGroupOfQuestions(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/updateDeletedGroups")
	public QuestionsResponse updateDeletedGroups(@RequestBody QuestionsRequest request){
		return questionsService.updateDeletedGroups(request);
	}
}
