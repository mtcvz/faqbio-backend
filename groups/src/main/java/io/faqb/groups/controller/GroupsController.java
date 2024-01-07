package io.faqb.groups.controller;

import io.faqb.groups.model.request.GroupsRequest;
import io.faqb.groups.model.response.GroupsResponse;
import io.faqb.groups.service.GroupsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class GroupsController {

	private final GroupsService groupsService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getGroups")
	public GroupsResponse getGroups(@RequestBody GroupsRequest request){
		return groupsService.getGroups(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setGroups")
	public GroupsResponse setGroups(@RequestBody GroupsRequest request){
		return groupsService.setGroups(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateGroups")
	public GroupsResponse updateGroups(@RequestBody GroupsRequest request){
		return groupsService.updateGroups(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteGroups/{id}")
	public GroupsResponse deleteGroups(@PathVariable int id){
		return groupsService.deleteGroups(id);
	}

}
