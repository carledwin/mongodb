
POST http://localhost:8080/customer/new
HEADERS: Content : application/json
BODY - raw
	{
		"name" : "Maria",
		"age" : 18,
		"sex" : "Feminino",
		"address" : { 	
          				"street": "Praça",
					  	"city" : "Alvorada",
	        	      	"state" : "Pará",
					  	"country" : "Brasil",
          				"number" : 6656 
	 			  	}
	}


GET http://localhost:8080/customer/5aa5b0ef82a4126a759c48fc

Result:
{"id":"5aa5b0ef82a4126a759c48fc","name":"Maria","age":18,"sex":"Feminino","address":{"id":null,"street":"Praça","city":"Alvorada","state":"Pará","country":"Brasil","number":6656}}

POST http://localhost:8080/customer/new-all
HEADERS: Content : application/json
BODY - raw  
[	
	{
		"name" : "Carl Edwin ",
		"age" : 35,
		"sex" : "Masculino",
		"address" : { 	
						"street" : "Rua do Gilo",
					  	"city" : "Guanabara",
	        	      	"state" : "São Paulo",
					  	"country" : "Brasil",
	 			  		"number" : 2243 
	 			  	}
	},

	{
		"name" : "Ana Clara",
		"age" : 25,
		"sex" : "Feminino",
		"address" : { 	
						"street" : "Alameda Alvorada",
					  	"city" : "Santana Santos",
	        	      	"state" : "Rio Grande do Sul",
					  	"country" : "Brasil",
	 			  		"number" : 13 
	 			  	}
	} 			  
]



GET http://localhost:8080/customer/all

Result: 
[{"id":"5aa5aa9f82a41267bfb08e03","name":"Carl Edwin ","age":35,"sex":"Masculino","address":{"id":null,"street":"Rua do Gilo","city":"Guanabara","state":"São Paulo","country":"Brasil","number":2243}},{"id":"5aa5aaa082a41267bfb08e04","name":"Ana Clara","age":25,"sex":"Feminino","address":{"id":null,"street":"Alameda Alvorada","city":"Santana Santos","state":"Rio Grande do Sul","country":"Brasil","number":13}}]


GET http://localhost:8080/customer/all

Result:
[{"id":"5aa5aa9f82a41267bfb08e03","name":"Carl Edwin Antonio","age":35,"sex":"Masculino","address":{"id":null,"street":"Rua do Gilo","city":"Guanabara","state":"São Paulo","country":"Brasil","number":78}},{"id":"5aa5aaa082a41267bfb08e04","name":"Ana Clara","age":25,"sex":"Feminino","address":{"id":null,"street":"Alameda Alvorada","city":"Santana Santos","state":"Rio Grande do Sul","country":"Brasil","number":13}}]


DELETE http://localhost:8080/customer/delete/5aa5aa9f82a41267bfb08e03

GET http://localhost:8080/customer/all

Result:
[{"id":"5aa5aaa082a41267bfb08e04","name":"Ana Clara","age":25,"sex":"Feminino","address":{"id":null,"street":"Alameda Alvorada","city":"Santana Santos","state":"Rio Grande do Sul","country":"Brasil","number":13}}]

[	
	{
		"name" : "Carl Edwin ",
		"age" : 35,
		"sex" : "Masculino",
		"address" : { 	
						"street" : "Rua do Gilo",
					  	"city" : "Guanabara",
	        	      	"state" : "São Paulo",
					  	"country" : "Brasil",
	 			  		"number" : 2243 
	 			  	}
	},

	{
		"name" : "Ana Clara",
		"age" : 25,
		"sex" : "Feminino",
		"address" : { 	
						"street" : "Alameda Alvorada",
					  	"city" : "Santana Santos",
	        	      	"state" : "Rio Grande do Sul",
					  	"country" : "Brasil",
	 			  		"number" : 13 
	 			  	}
	} 			  
]

