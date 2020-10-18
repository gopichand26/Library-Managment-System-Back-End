package com.dxc.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dxc.model.Register;
import com.dxc.repository.RegisterRepository;

@Service
public class RegisterServiceImp implements RegisterService{
	
	@Autowired
	RegisterRepository registerRepository;
	
	public Register add(Register register) {
		return registerRepository.save(register);
	}
	
	public List<Register> showall(){
		return  (List<Register>) registerRepository.findAll();
	}
	
	public List<Register> findByName(String name) {
		return registerRepository.findByName(name);
	}
	
	public String edit(int id,String outtime) {
		LocalTime time = LocalTime.parse(outtime);
		 registerRepository.update(id, time);
		 return "out time saved successfully";
	}

}