package io.faqb.socialmedias.service;

import io.faqb.socialmedias.entity.SocialMediasEntity;
import io.faqb.socialmedias.model.SocialMedias;
import io.faqb.socialmedias.model.request.SocialMediasRequest;
import io.faqb.socialmedias.model.response.SocialMediasResponse;
import io.faqb.socialmedias.repository.SocialMediasRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class SocialMediasService {

	private final SocialMediasRepository socialMediasRepository;

	public SocialMediasResponse getSocialMedias(SocialMediasRequest request){
		int userId = request.getUserId();
		Optional<SocialMediasEntity> socialMediasEntity;
		SocialMediasResponse response = new SocialMediasResponse();

		socialMediasEntity = socialMediasRepository.findById(userId);
		if (!socialMediasEntity.isPresent()){
			response.setStatus(true);
			response.setMessage("NO SOCIAL MEDIAS");
			return response;
		}

		SocialMedias socialMedias = new SocialMedias();
		socialMedias.setUserId(userId);
		socialMedias.setFacebook(socialMediasEntity.get().getFacebook());
		socialMedias.setInstagram(socialMediasEntity.get().getInstagram());
		socialMedias.setWhatsapp(socialMediasEntity.get().getWhatsapp());
		socialMedias.setTwitter(socialMediasEntity.get().getTwitter());
		socialMedias.setTiktok(socialMediasEntity.get().getTiktok());
		socialMedias.setYoutube(socialMediasEntity.get().getYoutube());
		socialMedias.setWebsite(socialMediasEntity.get().getWebsite());

		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(socialMedias);
		return response;
	}

	public SocialMediasResponse setSocialMedias(SocialMediasRequest request){
		int userId = request.getUserId();
		Optional<SocialMediasEntity> entity;
		entity = socialMediasRepository.findById(userId);
		SocialMediasEntity socialMediasEntity;
		if( entity.isPresent()){
			socialMediasEntity = entity.get();
		} else
			socialMediasEntity = new SocialMediasEntity();

		socialMediasEntity.setUserId(userId);

		if(request.getFacebook() != null)
			socialMediasEntity.setFacebook(request.getFacebook());
		if(request.getInstagram() != null)
			socialMediasEntity.setInstagram(request.getInstagram());
		if(request.getTiktok() != null)
			socialMediasEntity.setTiktok(request.getTiktok());
		if(request.getTwitter() != null)
			socialMediasEntity.setTwitter(request.getTwitter());
		if(request.getWebsite() != null)
			socialMediasEntity.setWebsite(request.getWebsite());
		if(request.getYoutube() != null)
			socialMediasEntity.setYoutube(request.getYoutube());
		if(request.getWhatsapp() != null)
			socialMediasEntity.setWhatsapp(request.getWhatsapp());

		if(Objects.equals(request.getFacebook(), " "))
			socialMediasEntity.setFacebook(null);
		if(Objects.equals(request.getInstagram(), " "))
			socialMediasEntity.setInstagram(null);
		if(Objects.equals(request.getTiktok(), " "))
			socialMediasEntity.setTiktok(null);
		if(Objects.equals(request.getTwitter(), " "))
			socialMediasEntity.setTwitter(null);
		if(Objects.equals(request.getWebsite(), " "))
			socialMediasEntity.setWebsite(null);
		if(Objects.equals(request.getYoutube(), " "))
			socialMediasEntity.setYoutube(null);
		if(Objects.equals(request.getWhatsapp(), " "))
			socialMediasEntity.setWhatsapp(null);


		SocialMediasResponse response = new SocialMediasResponse();

		try{
			socialMediasRepository.save(socialMediasEntity);
		} catch (Exception e){
			log.error("There is an error while saving social medias to SocialMedias table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}

		response.setStatus(true);
		response.setMessage("SUCCESS");
		SocialMedias socialMedias = new SocialMedias();
		socialMedias.setUserId(userId);
		socialMedias.setFacebook(socialMediasEntity.getFacebook());
		socialMedias.setInstagram(socialMediasEntity.getInstagram());
		socialMedias.setWhatsapp(socialMediasEntity.getWhatsapp());
		socialMedias.setTwitter(socialMediasEntity.getTwitter());
		socialMedias.setTiktok(socialMediasEntity.getTiktok());
		socialMedias.setYoutube(socialMediasEntity.getYoutube());
		socialMedias.setWebsite(socialMediasEntity.getWebsite());
		response.setData(socialMedias);
		return response;
	}

}
