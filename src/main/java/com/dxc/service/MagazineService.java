package com.dxc.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dxc.model.Magazine;

public interface MagazineService {
	
  
	public void save(Magazine magazine);
	
	public Magazine Update(Magazine magazine);

	public Optional<Magazine> findByName(String name);
	
	public List<Magazine> findByDate(LocalDate date) ;

	public List<Magazine> findAll();
	
	public Magazine findById(String name, LocalDate date) ;

	public List<Magazine> getMagsL(String magname, String magdate);

	public List<Magazine> getMagAll(String magname);
		
	
}
