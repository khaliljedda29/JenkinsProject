package com.esprit.examen.controllers;

import java.util.List;

import com.esprit.examen.entities.SecteurActiviteDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.services.ISecteurActiviteService;

import io.swagger.annotations.Api;

@RestController
@Api(tags = "Gestion des secteurs activites")
@RequestMapping("/secteurActivite")
@CrossOrigin("*")
public class SecteurActiviteController {

	@Autowired
	ISecteurActiviteService secteurActiviteService;
	@Autowired
	private ModelMapper modelMapper;
	
	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-all-secteurActivite
	@GetMapping("/retrieve-all-secteurActivite")
	@ResponseBody
	public List<SecteurActivite> getSecteurActivite() {
		return secteurActiviteService.retrieveAllSecteurActivite();
	}

	// http://localhost:8089/SpringMVC/secteurActivite/retrieve-secteurActivite/8
	@GetMapping("/retrieve-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public SecteurActivite retrieveSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		return secteurActiviteService.retrieveSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/add-secteurActivite
	@PostMapping("/add-secteurActivite")
	@ResponseBody
	public ResponseEntity<SecteurActiviteDto> addSecteurActivite(@RequestBody  SecteurActiviteDto secteurActiviteDto) {
		SecteurActivite secteurActiviteRequest = modelMapper.map(secteurActiviteDto, SecteurActivite.class);

		SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(secteurActiviteRequest);

		// convert entity to DTO
		SecteurActiviteDto postResponse = modelMapper.map(secteurActivite, SecteurActiviteDto.class);

		return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/remove-secteurActivite/{secteurActivite-id}
	@DeleteMapping("/remove-secteurActivite/{secteurActivite-id}")
	@ResponseBody
	public void removeSecteurActivite(@PathVariable("secteurActivite-id") Long secteurActiviteId) {
		secteurActiviteService.deleteSecteurActivite(secteurActiviteId);
	}

	// http://localhost:8089/SpringMVC/secteurActivite/modify-secteurActivite
	@PutMapping("/modify-secteurActivite")
	@ResponseBody
	public ResponseEntity<SecteurActiviteDto> updateSecteurActivite(@RequestBody SecteurActiviteDto secteurActiviteDto) {
		SecteurActivite secteurActiviteRequest = modelMapper.map(secteurActiviteDto, SecteurActivite.class);

		SecteurActivite secteurActivite = secteurActiviteService.updateSecteurActivite( secteurActiviteRequest);

		// entity to DTO
		SecteurActiviteDto secteurActiviteResponse = modelMapper.map(secteurActivite, SecteurActiviteDto.class);

		return ResponseEntity.ok().body(secteurActiviteResponse);
	}

	
}
