package com.revature.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.ecommerce.exception.ResourceNotFoundException;
import com.revature.ecommerce.model.Console;
import com.revature.ecommerce.repository.ConsoleRepository;


@RequestMapping("/g-corp/console")
@CrossOrigin(origins ="*")
@RestController
public class ConsoleController {
	 
	ConsoleRepository cr;

	
	@Autowired
	public ConsoleController(ConsoleRepository cr) {
		super();
		this.cr = cr;
	}

	@PostMapping("/new")
	public Console addNewConsole(@RequestBody Console newConsole) {	
		return  cr.save(newConsole);
	}
	

	@PostMapping("/allnew")
	public List<Console> addManyNewConsoles(@RequestBody List<Console> newConsoles) {	
		return  cr.saveAll(newConsoles);
	}
	

	@RequestMapping("/{title}")
	public ResponseEntity<Console> getIndividualConsole(@PathVariable("title") String consoleTitle) throws ResourceNotFoundException{ 
		consoleTitle=String.join(" ",consoleTitle.split("_"));
		Console console = cr.findByptitleContainingIgnoreCase(consoleTitle).orElseThrow(() -> new ResourceNotFoundException("No Console by that Title Found"));
		return ResponseEntity.ok().body(console);
	}
	
	@GetMapping("/page_{num}")
	public ResponseEntity<Page<Console>> getAllConsolesInPages(@PathVariable(value = "num") Integer num){
		Pageable nextPageWithTenElements; 
		nextPageWithTenElements = PageRequest.of(num-1, 10, Sort.by("title"));
		
		return ResponseEntity.ok(cr.findAll(nextPageWithTenElements));
	}
	
	@GetMapping("/all-consoles")
	public ResponseEntity<List<Console>> getAllConsoles(){
		return ResponseEntity.ok(cr.findAll());
	}
}