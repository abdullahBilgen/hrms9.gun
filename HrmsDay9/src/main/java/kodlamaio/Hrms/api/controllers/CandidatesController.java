package kodlamaio.Hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.Hrms.business.abstracts.CandidateService;
import kodlamaio.Hrms.core.utilities.results.DataResult;
import kodlamaio.Hrms.core.utilities.results.Result;
import kodlamaio.Hrms.entities.concretes.Candidate;


@RestController
@RequestMapping("/api/candidates") 
public class CandidatesController {
	
	private CandidateService candidateService;
	
    @Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Candidate candidate) {
		return this.candidateService.add(candidate);
	}
	
	@GetMapping("/orderbschoolsgraduation")
	public DataResult<List<Candidate>> findByCandidateIdOrderBySchoolsGraduationDate(@RequestParam int candidateId){
		return this.candidateService.findByCandidateIdOrderBySchoolsGraduationDate(candidateId);
	}
	
	@GetMapping("/orderbyjobexperiences")
	public DataResult<List<Candidate>> findByCandidateIdOrderByJobExperiencesEndDate(@RequestParam int candidateId){
		return this.candidateService.findByCandidateIdOrderByJobExperiencesEndDate(candidateId);
	}
}
