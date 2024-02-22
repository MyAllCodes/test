package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import test.entity.Students;
import test.services.TestService;

@RestController
public class TestController {
	
@Autowired
TestService testService;

@GetMapping("/getAll")
public List<Students> testData() {
	return testService.findAll();
}

@GetMapping("/save")
public Students save() {
	return testService.save(new Students(123L,"Gaurav","Yadav","gauravyadavyadav3590@gmail.com","123"));
}
@GetMapping("/admin/api")
public String adminAPI() {
	return "admin";
}
@GetMapping("/user/api")
public String userAPI() {
	return "user";
}

}
