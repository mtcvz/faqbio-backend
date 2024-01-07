package io.faqb.links.controller;

import io.faqb.links.model.request.LinksRequest;
import io.faqb.links.model.response.LinksResponse;
import io.faqb.links.service.LinksService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class LinksController {

	private final LinksService linksService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getLinks")
	public LinksResponse getLinks(@RequestBody LinksRequest request){
		return linksService.getLinks(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setLinks")
	public LinksResponse setLinks(@RequestBody LinksRequest request){
		return linksService.setLinks(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateLinks")
	public LinksResponse updateLinks(@RequestBody LinksRequest request){
		return linksService.updateLinks(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteLinks/{id}")
	public LinksResponse deleteLinks(@PathVariable int id){
		return linksService.deleteLinks(id);
	}
}
