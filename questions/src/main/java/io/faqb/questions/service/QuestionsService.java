package io.faqb.questions.service;

import io.faqb.questions.entity.QuestionsEntity;
import io.faqb.questions.model.Questions;
import io.faqb.questions.model.request.QuestionsRequest;
import io.faqb.questions.model.response.QuestionsResponse;
import io.faqb.questions.repository.QuestionsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class QuestionsService {

	private final QuestionsRepository questionsRepository;

	public QuestionsResponse getQuestions(QuestionsRequest request){
		int userId = request.getUserId();
		List<QuestionsEntity> questionsEntityList;
		List<Questions> questionsList = new ArrayList<>();
		QuestionsResponse response = new QuestionsResponse();

		questionsEntityList = questionsRepository.findByUserId(userId);
		if (questionsEntityList.isEmpty()){
			response.setStatus(true);
			response.setMessage("NO QUESTIONS");
			return response;
		}

		for (QuestionsEntity entity: questionsEntityList) {
			Questions questions = new Questions();
			questions.setQuestionId(entity.getQuestionId());
			questions.setQuestion(entity.getQuestion());
			questions.setAnswer(entity.getAnswer());
			questions.setGroupId(entity.getGroupId());
			questions.setGroupName(entity.getGroupName());
			questions.setUserId(userId);
			questionsList.add(questions);
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(questionsList);
		return response;
	}

	public QuestionsResponse setQuestions(QuestionsRequest request){
		int userId = request.getUserId();
		QuestionsEntity questionsEntity = new QuestionsEntity();
		questionsEntity.setUserId(userId);
		questionsEntity.setGroupId(request.getGroupId());
		questionsEntity.setGroupName(request.getGroupName());
		questionsEntity.setQuestion(request.getQuestion());
		questionsEntity.setAnswer(request.getAnswer());
		QuestionsResponse response = new QuestionsResponse();

		try{
			questionsRepository.save(questionsEntity);
		} catch (Exception e){
			log.error("There is an error while saving questions to Questions table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;

		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		Questions questions = new Questions();
		questions.setUserId(userId);
		questions.setGroupId(request.getGroupId());
		questions.setGroupName(request.getGroupName());
		questions.setQuestion(request.getQuestion());
		questions.setAnswer(request.getAnswer());
		questions.setQuestionId(questionsEntity.getQuestionId());
		List<Questions> questionsList = new ArrayList<>();
		questionsList.add(questions);
		response.setData(questionsList);
		return response;
	}

	public QuestionsResponse updateQuestions(QuestionsRequest request){
		int userId = request.getUserId();
		int questionId = request.getQuestionId();
		QuestionsEntity questionsEntity = new QuestionsEntity();
		questionsEntity.setQuestionId(questionId);
		questionsEntity.setUserId(userId);
		questionsEntity.setQuestion(request.getQuestion());
		questionsEntity.setAnswer(request.getAnswer());
		questionsEntity.setGroupId(request.getGroupId());
		questionsEntity.setGroupName(request.getGroupName());
		QuestionsResponse response = new QuestionsResponse();
		try{
			questionsRepository.save(questionsEntity);
		} catch (Exception e){
			log.error("There is an error while updating question " + questionId + " to Questions table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		Questions questions = new Questions();
		questions.setQuestionId(questionId);
		questions.setQuestion(request.getQuestion());
		questions.setAnswer(request.getAnswer());
		questions.setGroupId(request.getGroupId());
		questions.setGroupName(request.getGroupName());
		questions.setUserId(request.getUserId());
		List<Questions> questionsList = new ArrayList<>();
		questionsList.add(questions);
		response.setData(questionsList);
		return response;
	}

	public QuestionsResponse deleteQuestions(int id){
		QuestionsEntity questionsEntity = new QuestionsEntity();
		questionsEntity.setQuestionId(id);
		QuestionsResponse response = new QuestionsResponse();
		try{
			questionsRepository.delete(questionsEntity);
		} catch (Exception e){
			log.error("There is an error while deleting question + " + id + " from Questions table.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

	public QuestionsResponse updateGroupOfQuestions(QuestionsRequest request){
		int userId = request.getUserId();
		int groupId = request.getGroupId();
		String groupName = request.getGroupName();
		QuestionsResponse response = new QuestionsResponse();
		try{
			questionsRepository.updateGroupNames(userId,groupId,groupName);
		} catch (Exception e){
			log.error("There is an error while updating group names of questions in Questions table.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

	public QuestionsResponse updateDeletedGroups(QuestionsRequest request){
		int userıd = request.getUserId();
		int groupId = request.getGroupId();
		QuestionsResponse response = new QuestionsResponse();
		try {
			questionsRepository.updateDeletedGroups(userıd,groupId);
		} catch (Exception e){
			log.error("There is an error while updating deleted group of questions in Questions table.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

}
