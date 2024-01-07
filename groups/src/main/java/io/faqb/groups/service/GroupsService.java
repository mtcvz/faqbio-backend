package io.faqb.groups.service;

import io.faqb.groups.entity.GroupsEntity;
import io.faqb.groups.model.Groups;
import io.faqb.groups.model.request.GroupsRequest;
import io.faqb.groups.model.response.GroupsResponse;
import io.faqb.groups.repository.GroupsRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class GroupsService {

	private final GroupsRepository groupsRepository;

	public GroupsResponse getGroups(GroupsRequest request){
		int userId = request.getUserId();
		List<GroupsEntity> groupsEntityList;
		List<Groups> groupsList = new ArrayList<>();
		GroupsResponse response = new GroupsResponse();

		groupsEntityList = groupsRepository.findByUserId(userId);
		if (groupsEntityList.isEmpty()){
			response.setStatus(true);
			response.setMessage("NO GROUPS");
			return response;
		}

		for (GroupsEntity entity: groupsEntityList) {
			Groups groups = new Groups();
			groups.setGroupId(entity.getGroupId());
			groups.setGroupIcon(entity.getGroupIcon());
			groups.setGroupName(entity.getGroupName());
			groups.setUserId(userId);
			groupsList.add(groups);
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		response.setData(groupsList);
		return response;
	}

	public GroupsResponse setGroups(GroupsRequest request){
		int userId = request.getUserId();
		GroupsEntity groupsEntity = new GroupsEntity();
		groupsEntity.setUserId(userId);
		groupsEntity.setGroupIcon(request.getGroupIcon());
		groupsEntity.setGroupName(request.getGroupName());
		GroupsResponse response = new GroupsResponse();
		try{
			groupsRepository.save(groupsEntity);
		} catch (Exception e){
			log.error("There is an error while saving groups to Groups table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;

		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		Groups group = new Groups();
		group.setGroupId(groupsEntity.getGroupId());
		group.setGroupIcon(request.getGroupIcon());
		group.setGroupName(request.getGroupName());
		group.setUserId(userId);
		List<Groups> groupsList = new ArrayList<>();
		groupsList.add(group);
		response.setData(groupsList);
		return response;
	}

	public GroupsResponse updateGroups(GroupsRequest request){
		int userId = request.getUserId();
		int groupId = request.getGroupId();
		GroupsEntity groupsEntity = new GroupsEntity();
		groupsEntity.setUserId(userId);
		groupsEntity.setGroupIcon(request.getGroupIcon());
		groupsEntity.setGroupName(request.getGroupName());
		groupsEntity.setGroupId(groupId);
		GroupsResponse response = new GroupsResponse();
		try{
			groupsRepository.save(groupsEntity);
		} catch (Exception e){
			log.error("There is an error while updating group " + groupId + " to Groups table. userId: " + userId);
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;

		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		Groups group = new Groups();
		group.setGroupId(groupsEntity.getGroupId());
		group.setGroupIcon(request.getGroupIcon());
		group.setGroupName(request.getGroupName());
		group.setUserId(userId);
		List<Groups> groupsList = new ArrayList<>();
		groupsList.add(group);
		response.setData(groupsList);
		return response;
	}

	public GroupsResponse deleteGroups(int id){
		GroupsEntity groupsEntity = new GroupsEntity();
		groupsEntity.setGroupId(id);
		GroupsResponse response = new GroupsResponse();
		try{
			groupsRepository.delete(groupsEntity);
		} catch (Exception e){
			log.error("There is an error while deleting group + " + id + " from Groups table.");
			response.setStatus(false);
			response.setMessage(e.getMessage());
			return response;
		}
		response.setStatus(true);
		response.setMessage("SUCCESS");
		return response;
	}
}
