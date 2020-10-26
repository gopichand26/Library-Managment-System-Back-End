package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Register;
import com.dxc.service.RegisterService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping("register")
	public Register add(@RequestBody Register register) {
		return registerService.add(register);
	}
	
	@GetMapping("register")
	public List<Register> showall(){
		return  (List<Register>) registerService.showall();
	}
	
	@GetMapping("register/{name}")
	public List<Register> findone(@PathVariable String name) {
		return registerService.findByName(name);
	}
	@PutMapping("register/{id}")
	public void edit(@PathVariable int id,@RequestBody Register registerdet) {
		 
		registerService.edit(id, registerdet);
	}
	
	@GetMapping("register/getvisitor/{id}")
	public Register getvisitor(@PathVariable("id") int id)
	{
		return registerService.getvisitor(id);
	}

}