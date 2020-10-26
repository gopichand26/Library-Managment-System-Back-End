package com.dxc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Library;
import com.dxc.service.LibraryService;

@RestController
@RequestMapping("/api")
public class LibraryController  {
	@Autowired
	private LibraryService libraryService;
	
	
	@GetMapping(value = "/library", produces = "application/json")
	public List<Library> findAll() {
		return libraryService.findAll();
	}
	@CrossOrigin
	@GetMapping("/library/{floor_no}")
	public Optional<Library> getBooksByFloor_no(@PathVariable int floor_no) {
		
		Optional<Library> theLib =  libraryService.findByFloor_no(floor_no);
		
		if (theLib == null) {
			throw new RuntimeException("Floor not found - " + floor_no);
		}
		
		return theLib;
	}

	@CrossOrigin
	@PostMapping("/library")
	public  Library addLibrary(@RequestBody Library theLib) {
		
				
		libraryService.save(theLib);
		return theLib;
	}
	@CrossOrigin
	@PutMapping("/library")
	public Library updateLibrary(@RequestBody Library theLib) {
		
		libraryService.Update(theLib);
		
		return theLib;
	}
	
	@CrossOrigin
	@DeleteMapping("/library/{floor_no}")
	public String deleteLibrary(@PathVariable int floor_no) {
		
		Optional<Library> theLib = libraryService.findByFloor_no(floor_no);
		
		// throw exception if null
		
		if (theLib == null) {
			throw new RuntimeException("Floor id not found - " +floor_no);
		}
		
		libraryService.deleteById(floor_no);
		
		return "Deleted Floor - " + floor_no;
	}
	
}