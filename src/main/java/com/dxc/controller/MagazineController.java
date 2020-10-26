package com.dxc.controller;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.model.Magazine;
import com.dxc.repository.MagazineRepository;
import com.dxc.service.MagazineService;

@RestController 
@RequestMapping("/api")

public class MagazineController {


         @Autowired
		 private MagazineService magazineService;
		
         
         @GetMapping(value = "/magazines")
     	 public List<Magazine> findAll() {
     		return magazineService.findAll();
     	 }
     	@CrossOrigin
     	@GetMapping("/magazine/{name}")
     	public Optional<Magazine> getMagazineByName(@PathVariable String name) {
     		
     		Optional<Magazine> magazine =  magazineService.findByName(name);
     		
     		if (magazine == null) {
     			throw new RuntimeException("Magazine not found - " + name);
     		}
     		
     		return magazine;
     	}
     	@CrossOrigin
     	@GetMapping("/magazines/{date}")
     	public List<Magazine> getMagazineByDate(@PathVariable String datee) {
     		LocalDate date=LocalDate.parse(datee);
     		List<Magazine> magazine = (List<Magazine>) magazineService.findByDate(date);
     		
     		if (magazine == null) {
     			throw new RuntimeException("Magazine not found - " + date);
     		}
     		
     		return magazine;
     	}
     	
     	@GetMapping("/magazines/{name}/{date}")
     	public Magazine getMagazine(@PathVariable String name, @PathVariable String date) {
     		LocalDate dat=LocalDate.parse(date);
     		Magazine magazine = magazineService.findById(name, dat);
     		
     		if (magazine == null) {
     			throw new RuntimeException("Magazine not found - " + name);
     		}
     		return magazine ;
     	}
     	@CrossOrigin
     	@PostMapping("/magazine")
     	public  Magazine addMagazine(@RequestBody Magazine magazine) {
     		
     				
     		magazineService.save(magazine);
     		return magazine;
     	}
     	@CrossOrigin
     	@PutMapping("/magazine")
     	public Magazine updateMagazine(@RequestBody Magazine magazine) {
     		
     		magazineService.Update(magazine);
     		
     		return magazine;
     	}
     	
     	 @GetMapping("/magazines/one/{magname}/{magdate}")
    	 public List<Magazine> getMagList(@PathVariable("magname") String magname,@PathVariable("magdate") String magdate ) {
    		
    		 return magazineService.getMagsL(magname,magdate);
    	 }
    	 
    	 @GetMapping("/magazines/all/{magname}")
    	 public List<Magazine> getMagAll(@PathVariable("magname") String magname ) {
    		 return magazineService.getMagAll(magname);
    	 }
		    
	}


