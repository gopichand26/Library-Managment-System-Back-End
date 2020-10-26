package com.dxc.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Library;
import com.dxc.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	
	
	@Autowired
	private LibraryRepository libraryRepository;
	@Override
	@Transactional
	public List<Library> findAll() {
		return libraryRepository.findAll();
	}

	@Override
	public void save(Library theLib) {
		libraryRepository.save(theLib);

	}

	@Override
	public Library Update(Library theLib) {
		Optional<Library> res = libraryRepository.findByFloor_no(theLib.getFloor_no());
		if(res.isPresent()) {
			libraryRepository.save(theLib);
		}
		return theLib;
	}
	

	@Override
	public Optional<Library> findByFloor_no(int floor_no) {
		Optional<Library> theLib = libraryRepository.findByFloor_no(floor_no);
		
		return theLib;
	
	}

	@Override
	public void deleteById(int floor_no) {
		
		libraryRepository.deleteById(floor_no);
	}

	

}