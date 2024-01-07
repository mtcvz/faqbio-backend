package io.faqb.userinfo.service;

import io.faqb.userinfo.entity.UserInfoEntity;
import io.faqb.userinfo.model.UserInfo;
import io.faqb.userinfo.model.request.UserInfoRequest;
import io.faqb.userinfo.model.response.UserInfoResponse;
import io.faqb.userinfo.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UserInfoService {

	private final UserInfoRepository userInfoRepository;

	public UserInfoResponse getUserInfo(UserInfoRequest userInfoRequest){
		int userId = userInfoRequest.getUserId();
		Optional<UserInfoEntity> userInfoEntity;
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		UserInfoResponse response = new UserInfoResponse();

		userInfoEntity = userInfoRepository.findById(userId);
		if (userInfoEntity.isPresent()){
			userInfo.setUsername(userInfoEntity.get().getUsername());
			userInfo.setTitle(userInfoEntity.get().getTitle());
			userInfo.setAbout(userInfoEntity.get().getAbout());
			response.setStatus(true);
			response.setMessage("SUCCESS");
			response.setData(userInfo);
		} else {
			response.setStatus(true);
			response.setMessage("User info not found.");
		}

		return response;
	}

	public UserInfoResponse setUserInfo(UserInfoRequest request){
		int userId = request.getUserId();
		Optional<UserInfoEntity> entity;
		entity = userInfoRepository.findById(userId);
		UserInfoEntity userInfoEntity;

		if( entity.isPresent()){
			userInfoEntity = entity.get();
		} else
			userInfoEntity = new UserInfoEntity();
		UserInfo userInfo = new UserInfo();
		UserInfoResponse response = new UserInfoResponse();

		userInfoEntity.setUserId(userId);
		if(request.getUserName() != null)
			userInfoEntity.setUsername(request.getUserName());
		if (request.getTitle() != null && !Objects.equals(request.getTitle(), ""))
			userInfoEntity.setTitle(request.getTitle());
		if (request.getAbout() != null && !Objects.equals(request.getAbout(), ""))
			userInfoEntity.setAbout(request.getAbout());

		try{
			userInfoRepository.save(userInfoEntity);
		} catch (Exception e){
			log.error("There is an error while saving userInfo to database. userId: " + userId);
			response.setStatus(false);
			response.setMessage("There is an error while saving userInfo to database. userId: " + userId);
			return response;
		}

		userInfo.setUserId(userId);
		userInfo.setUsername(userInfoEntity.getUsername());
		userInfo.setTitle(userInfoEntity.getTitle());
		userInfo.setAbout(userInfoEntity.getAbout());
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(userInfo);
		return response;
	}
}
