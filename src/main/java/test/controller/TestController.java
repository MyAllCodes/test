package test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import test.beans.Product;
import test.daos.RedisDAO;

@RestController
public class TestController {
	
	@Autowired
	RedisDAO redisDAO;
	
	@PostMapping("/save")
	public Product test(@RequestBody Product product) {
		return redisDAO.save(product);
	}
	
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return redisDAO.findAll();
	}
	
	@GetMapping("/getById/{id}")
	@Cacheable(key="#id", value="Object",unless = "#result.price > 1000")
	public Object getById(@PathVariable("id") String id) {
	    return redisDAO.findProductById(Integer.parseInt(id));
	}

	@GetMapping("/deleteById/{id}")
	@CacheEvict(key="#id", value="Object")
	public String deleteById(@PathVariable("id") String id) {
		return redisDAO.deleteProduct(Integer.parseInt(id));
	}

}
