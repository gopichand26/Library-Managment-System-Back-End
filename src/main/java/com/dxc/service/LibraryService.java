package com.dxc.service;

import java.util.List;
import java.util.Optional;

import com.dxc.model.Library;

public interface LibraryService {

	public List<Library> findAll();

	public void save(Library theLib);
	public Library Update(Library theLib);

	public Optional<Library> findByFloor_no(int floor_no);

	

	public void deleteById(int floor_no);

	
}