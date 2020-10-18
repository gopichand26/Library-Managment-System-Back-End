package com.dxc.service;

import java.util.List;

import com.dxc.model.Register;

public interface RegisterService {
	public Register add(Register register);
	public List<Register> showall();
	public List<Register> findByName(String name);
	public void edit(int id,String outtime);

}