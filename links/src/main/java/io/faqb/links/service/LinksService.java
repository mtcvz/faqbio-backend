package io.faqb.links.service;

import io.faqb.links.entity.LinksEntity;
import io.faqb.links.model.Links;
import io.faqb.links.model.request.LinksRequest;
import io.faqb.links.model.response.LinksResponse;
import io.faqb.links.repository.LinksRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class LinksService {

	private final LinksRepository linksRepository;

	public LinksResponse getLinks(LinksRequest request){
		int userId = request.getUserId();
		List<LinksEntity> linksEntityList;
		List<Links> linksList = new ArrayList<>();
		LinksResponse response = new LinksResponse();

		linksEntityList = linksRepository.findByUserId(userId);
		if (linksEntityList.isEmpty()){
			response.setStatus(true);
			response.setMessage("NO LINKS");
			return response;
		}

		for (LinksEntity entity: linksEntityList) {
			Links links = new Links();
			links.setLinkId(entity.getLinkId());
			links.setLinkName(entity.getLinkName());
			links.setUrl(entity.getUrl());
			links.setUserId(userId);
			linksList.add(links);
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(linksList);
		return response;
	}

	public LinksResponse setLinks(LinksRequest request){
		int userId = request.getUserId();
		LinksEntity linksEntity = new LinksEntity();
		linksEntity.setUserId(userId);
		linksEntity.setLinkName(request.getLinkName());
		linksEntity.setUrl(request.getUrl());
		LinksResponse response = new LinksResponse();

		try{
			linksRepository.save(linksEntity);
		} catch (Exception e){
			log.error("There is an error while saving links to Links table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}

		response.setStatus(true);
		response.setMessage("SUCCESS");
		Links links = new Links();
		links.setUserId(userId);
		links.setUrl(request.getUrl());
		links.setLinkName(request.getLinkName());
		links.setLinkId(linksEntity.getLinkId());
		List<Links> linksList = new ArrayList<>();
		linksList.add(links);
		response.setData(linksList);
		return response;
	}

	public LinksResponse updateLinks(LinksRequest request){
		int userId = request.getUserId();
		int linkId = request.getLinkId();
		LinksEntity linksEntity = new LinksEntity();
		linksEntity.setLinkId(linkId);
		linksEntity.setUserId(userId);
		linksEntity.setLinkName(request.getLinkName());
		linksEntity.setUrl(request.getUrl());
		LinksResponse response = new LinksResponse();
		try{
			linksRepository.save(linksEntity);
		} catch (Exception e){
			log.error("There is an error while updating link " + linkId + " to Links table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		Links links = new Links();
		links.setLinkId(linkId);
		links.setLinkName(request.getLinkName());
		links.setUrl(request.getUrl());
		links.setUserId(request.getUserId());
		List<Links> linksList = new ArrayList<>();
		linksList.add(links);
		response.setData(linksList);
		return response;
	}

	public LinksResponse deleteLinks(int id){
		LinksEntity linksEntity = new LinksEntity();
		linksEntity.setLinkId(id);
		LinksResponse response = new LinksResponse();
		try{
			linksRepository.delete(linksEntity);
		} catch (Exception e){
			log.error("There is an error while deleting link + " + id + " from Links table.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}

}
