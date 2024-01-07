package io.faqb.socialmedias.controller;

import io.faqb.socialmedias.model.request.SocialMediasRequest;
import io.faqb.socialmedias.model.response.SocialMediasResponse;
import io.faqb.socialmedias.service.SocialMediasService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/faqbio")
@AllArgsConstructor
public class SocialMediasController {

	private final SocialMediasService socialMediasService;

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/getSocialMedias")
	public SocialMediasResponse getSocialMedias(@RequestBody SocialMediasRequest request){
		return socialMediasService.getSocialMedias(request);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/setSocialMedias")
	public SocialMediasResponse setSocialMedias(@RequestBody SocialMediasRequest request){
		return socialMediasService.setSocialMedias(request);
	}
}
