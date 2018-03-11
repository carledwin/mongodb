package com.wordpress.carledwinj.productapimongodb.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wordpress.carledwinj.productapimongodb.dao.CustomerDAO;
import com.wordpress.carledwinj.productapimongodb.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	private CustomerDAO customerDao;
	
	@GetMapping("/all")
	public List<Customer> all(){
		return customerDao.findAll();
	}
	
	@PostMapping
	public String create(@RequestBody Customer customer){
		customerDao.create(customer);
		return "success";
	}
	
	@PutMapping
	public String update(@RequestBody Customer customer){
		customerDao.update(customer);
		return "success";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") String id){
		customerDao.delete(id);
		return "success";
	}
}
