package com.bluesoft.barkod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bluesoft.barkod.model.CalculateDataRequest;
import com.bluesoft.barkod.model.CommonActionRequest;
import com.bluesoft.barkod.model.CommonDataRequest;
import com.bluesoft.barkod.model.MobilActionRequest;
import com.bluesoft.barkod.model.SanalBarkodResponse;
import com.bluesoft.barkod.service.AkisService;
import com.bluesoft.barkod.service.CommonDataService;
import com.bluesoft.barkod.service.ProjectService;

@CrossOrigin
@RestController
@RequestMapping("/api/v3")
public class RestAPIController {

	@Autowired
	ProjectService projectService;

	@Autowired
	CommonDataService commonDataService;

	@Autowired
	AkisService akisService;

	@GetMapping("/{depoId}/projects")
	public ResponseEntity<?> getProject(@PathVariable Long depoId) {
		return ResponseEntity.ok(projectService.getProjectList(depoId));
	}
	
	
	@GetMapping("/{projeId}/devre")
	public ResponseEntity<?> getProjectDevre(@PathVariable int projeId) {
		return ResponseEntity.ok(projectService.getProjectDevreList(projeId));
	}
	

	@PostMapping("/{depoId}/common-data")
	public ResponseEntity<?> getCommonData(@PathVariable Long depoId, @RequestBody CommonDataRequest project) {
		return ResponseEntity.ok(commonDataService.getCommonDataList(depoId, project.getProjectId(),project.getProjectDevreId()));
	}

	@PostMapping("/toUserIslemAction")
	public ResponseEntity<?> toUserIslemAction(@RequestBody MobilActionRequest request) {
		return ResponseEntity.ok(commonDataService.userActions(request));
	}

	@PostMapping("/commonAction")
	public ResponseEntity<?> getCommonAction(@RequestBody CommonActionRequest request) {
		return ResponseEntity.ok(commonDataService.getTransactionList(request));
	}

	@GetMapping("/getAllHavuz")
	public ResponseEntity<?> getAllHavuz() {
		return ResponseEntity.ok(akisService.getAkisHavuzList());
	}
	
	@GetMapping("/getDistinctAllHavuz")
	public ResponseEntity<?> getAllHavuzList() {
		return ResponseEntity.ok(commonDataService.getHavuzList());
	}
	
	@PostMapping("/{depoId}/calculate")
	public ResponseEntity<?> calculate(@PathVariable Long depoId, @RequestBody CalculateDataRequest project) {
		return ResponseEntity.ok(commonDataService.calculateData(depoId, project.getProjectId(),project.getProjectDevreId(),project.getPriorty()));
	}
	
	@GetMapping("/detay/{sanalBarkodNo}/sanalbarkod")
	public ResponseEntity<?> getSanalBarkodDetay(@PathVariable Long sanalBarkodNo) {
		return ResponseEntity.ok(commonDataService.getSanalBarkodDetay(sanalBarkodNo));
	}
	
	@PostMapping("/{depoId}/calculateGraph")
	public ResponseEntity<?> calculateGraph(@PathVariable Long depoId, @RequestBody CalculateDataRequest project) {
		return ResponseEntity.ok(commonDataService.getGrafikData(depoId, project.getProjectId(),project.getProjectDevreId()));
	}

	
}
