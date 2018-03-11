package com.wordpress.carledwinj.productapimongodb.restcontroller;

import java.util.List;

import org.assertj.core.util.Arrays;
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
	
	@PostMapping("/new")
	public String create(@RequestBody Customer customer){
		customerDao.create(customer);
		return "success";
	}
	
	@PostMapping("/new-all")
	public String create(@RequestBody Customer[] customers){
		customerDao.createAll(customers);
		return "success";
	}
	
	@PutMapping("update")
	public String update(@RequestBody Customer customer){
		customerDao.update(customer);
		return "success";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") String id){
		customerDao.delete(id);
		return "success";
	}
	
	@GetMapping("/{id}")
	public Customer find(@PathVariable("id") String id){
		return	customerDao.findById(id);
	}
	
	@GetMapping("/requests")
	public String requests(){
		StringBuilder text = new StringBuilder();
		text.append("\n" + 
				"POST http://localhost:8080/customer/new\n" + 
				"HEADERS: Content : application/json\n" + 
				"BODY - raw\n" + 
				"	{\n" + 
				"		\"name\" : \"Maria\",\n" + 
				"		\"age\" : 18,\n" + 
				"		\"sex\" : \"Feminino\",\n" + 
				"		\"address\" : { 	\n" + 
				"          				\"street\": \"Praça\",\n" + 
				"					  	\"city\" : \"Alvorada\",\n" + 
				"	        	      	\"state\" : \"Pará\",\n" + 
				"					  	\"country\" : \"Brasil\",\n" + 
				"          				\"number\" : 6656 \n" + 
				"	 			  	}\n" + 
				"	}\n" + 
				"\n" + 
				"\n" + 
				"GET http://localhost:8080/customer/5aa5b0ef82a4126a759c48fc\n" + 
				"\n" + 
				"Result:\n" + 
				"{\"id\":\"5aa5b0ef82a4126a759c48fc\",\"name\":\"Maria\",\"age\":18,\"sex\":\"Feminino\",\"address\":{\"id\":null,\"street\":\"Praça\",\"city\":\"Alvorada\",\"state\":\"Pará\",\"country\":\"Brasil\",\"number\":6656}}\n" + 
				"\n" + 
				"POST http://localhost:8080/customer/new-all\n" + 
				"HEADERS: Content : application/json\n" + 
				"BODY - raw  \n" + 
				"[	\n" + 
				"	{\n" + 
				"		\"name\" : \"Carl Edwin \",\n" + 
				"		\"age\" : 35,\n" + 
				"		\"sex\" : \"Masculino\",\n" + 
				"		\"address\" : { 	\n" + 
				"						\"street\" : \"Rua do Gilo\",\n" + 
				"					  	\"city\" : \"Guanabara\",\n" + 
				"	        	      	\"state\" : \"São Paulo\",\n" + 
				"					  	\"country\" : \"Brasil\",\n" + 
				"	 			  		\"number\" : 2243 \n" + 
				"	 			  	}\n" + 
				"	},\n" + 
				"\n" + 
				"	{\n" + 
				"		\"name\" : \"Ana Clara\",\n" + 
				"		\"age\" : 25,\n" + 
				"		\"sex\" : \"Feminino\",\n" + 
				"		\"address\" : { 	\n" + 
				"						\"street\" : \"Alameda Alvorada\",\n" + 
				"					  	\"city\" : \"Santana Santos\",\n" + 
				"	        	      	\"state\" : \"Rio Grande do Sul\",\n" + 
				"					  	\"country\" : \"Brasil\",\n" + 
				"	 			  		\"number\" : 13 \n" + 
				"	 			  	}\n" + 
				"	} 			  \n" + 
				"]\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"GET http://localhost:8080/customer/all\n" + 
				"\n" + 
				"Result: \n" + 
				"[{\"id\":\"5aa5aa9f82a41267bfb08e03\",\"name\":\"Carl Edwin \",\"age\":35,\"sex\":\"Masculino\",\"address\":{\"id\":null,\"street\":\"Rua do Gilo\",\"city\":\"Guanabara\",\"state\":\"São Paulo\",\"country\":\"Brasil\",\"number\":2243}},{\"id\":\"5aa5aaa082a41267bfb08e04\",\"name\":\"Ana Clara\",\"age\":25,\"sex\":\"Feminino\",\"address\":{\"id\":null,\"street\":\"Alameda Alvorada\",\"city\":\"Santana Santos\",\"state\":\"Rio Grande do Sul\",\"country\":\"Brasil\",\"number\":13}}]\n" + 
				"\n" + 
				"\n" + 
				"GET http://localhost:8080/customer/all\n" + 
				"\n" + 
				"Result:\n" + 
				"[{\"id\":\"5aa5aa9f82a41267bfb08e03\",\"name\":\"Carl Edwin Antonio\",\"age\":35,\"sex\":\"Masculino\",\"address\":{\"id\":null,\"street\":\"Rua do Gilo\",\"city\":\"Guanabara\",\"state\":\"São Paulo\",\"country\":\"Brasil\",\"number\":78}},{\"id\":\"5aa5aaa082a41267bfb08e04\",\"name\":\"Ana Clara\",\"age\":25,\"sex\":\"Feminino\",\"address\":{\"id\":null,\"street\":\"Alameda Alvorada\",\"city\":\"Santana Santos\",\"state\":\"Rio Grande do Sul\",\"country\":\"Brasil\",\"number\":13}}]\n" + 
				"\n" + 
				"\n" + 
				"DELETE http://localhost:8080/customer/delete/5aa5aa9f82a41267bfb08e03\n" + 
				"\n" + 
				"GET http://localhost:8080/customer/all\n" + 
				"\n" + 
				"Result:\n" + 
				"[{\"id\":\"5aa5aaa082a41267bfb08e04\",\"name\":\"Ana Clara\",\"age\":25,\"sex\":\"Feminino\",\"address\":{\"id\":null,\"street\":\"Alameda Alvorada\",\"city\":\"Santana Santos\",\"state\":\"Rio Grande do Sul\",\"country\":\"Brasil\",\"number\":13}}]\n" + 
				"\n" + 
				"[	\n" + 
				"	{\n" + 
				"		\"name\" : \"Carl Edwin \",\n" + 
				"		\"age\" : 35,\n" + 
				"		\"sex\" : \"Masculino\",\n" + 
				"		\"address\" : { 	\n" + 
				"						\"street\" : \"Rua do Gilo\",\n" + 
				"					  	\"city\" : \"Guanabara\",\n" + 
				"	        	      	\"state\" : \"São Paulo\",\n" + 
				"					  	\"country\" : \"Brasil\",\n" + 
				"	 			  		\"number\" : 2243 \n" + 
				"	 			  	}\n" + 
				"	},\n" + 
				"\n" + 
				"	{\n" + 
				"		\"name\" : \"Ana Clara\",\n" + 
				"		\"age\" : 25,\n" + 
				"		\"sex\" : \"Feminino\",\n" + 
				"		\"address\" : { 	\n" + 
				"						\"street\" : \"Alameda Alvorada\",\n" + 
				"					  	\"city\" : \"Santana Santos\",\n" + 
				"	        	      	\"state\" : \"Rio Grande do Sul\",\n" + 
				"					  	\"country\" : \"Brasil\",\n" + 
				"	 			  		\"number\" : 13 \n" + 
				"	 			  	}\n" + 
				"	} 			  \n" + 
				"]\n" + 
				"\n" + 
				"");
		return text.toString();
	}
}
