package com.example.demo;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/testeureka")
public class EurekaController {
	
	private final TestEurekaRepository testRepo;
	
	@Autowired
	public EurekaController(TestEurekaRepository testRepo) {
		super();
		this.testRepo = testRepo;
	}

	
	@GetMapping()
	public ResponseEntity<Object> fetchCandidates() {
		
		TestModel testModel = new TestModel();
		
		Integer newId = generateRandomInt();
		testModel.setId(newId);
		testModel.setName("Successful");
		
		testRepo.save(testModel);
		
		List<TestModel> num = testRepo.findAll();
		return new ResponseEntity<Object>(
				num, HttpStatus.OK);
	}
	
	public static Integer generateRandomInt() {
		final Random random = new Random();
		return random.nextInt(100000);
	}
	
}
