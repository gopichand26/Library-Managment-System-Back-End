package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.dxc.model.Register;
import com.dxc.repository.RegisterRepository;

@Service
public  class RegisterServiceImp implements RegisterService{
	
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
	
	public void edit(int id,Register registerdet) {
		 
		Register register = registerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("visitor not found for this id :: " + id));
		register.setOuttime(registerdet.getOuttime());
		
		final Register updatedRegister = registerRepository.save(register);
	}
	
	public Register getvisitor( int id)
	{
		return registerRepository.findById(id).orElse(new Register());
	}
	

}