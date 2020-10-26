package com.dxc.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dxc.model.Newspaper;

public interface NewspaperService {
	
  
	public void save(Newspaper newspaper);
	
	public Newspaper Update(Newspaper newspaper);

	public Optional<Newspaper> findByName(String name);
	
	public List<Newspaper> findByDate(String date) ;

	public List<Newspaper> findAll();
	
	public Newspaper findById(String name, String date) ;

	public List<Newspaper> getNewsL(String newsname, String newsdate);

	public List<Newspaper> getNewsAll(String newsname);
		
	
}
