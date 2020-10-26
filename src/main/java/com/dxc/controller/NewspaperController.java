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
import com.dxc.model.Newspaper;
import com.dxc.service.NewspaperService;

@RestController 
@RequestMapping("/api")

public class NewspaperController {


         @Autowired
		 private NewspaperService newspaperService;
		
         
         @GetMapping(value = "/newspapers")
     	 public List<Newspaper> findAll() {
     		return newspaperService.findAll();
     	 }
     	@CrossOrigin
     	@GetMapping("/newspaper/{name}")
     	public Optional<Newspaper> getNewspaperByName(@PathVariable String name) {
     		
     		Optional<Newspaper> newspaper =  newspaperService.findByName(name);
     		
     		if (newspaper == null) {
     			throw new RuntimeException("Newspaper not found - " + name);
     		}
     		
     		return newspaper;
     	}
     	@CrossOrigin
     	@GetMapping("/newspapers/{date}")
     	public List<Newspaper> getNewspaperByDate(@PathVariable String date) {
     		
     		List<Newspaper> newspaper = (List<Newspaper>) newspaperService.findByDate(date);
     		
     		if (newspaper == null) {
     			throw new RuntimeException("Newspaper not found - " + date);
     		}
     		
     		return newspaper;
     	}
     	
     	@GetMapping("/newspapers/{name}/{date}")
     	public Newspaper getNewspaper(@PathVariable String name, @PathVariable String date) {
     		
     		
     		Newspaper newspaper = newspaperService.findById(name, date);
     		
     		if (newspaper == null) {
     			throw new RuntimeException("Newspaper not found - " + name);
     		}
     		return newspaper ;
     	}
     	@CrossOrigin
     	@PostMapping("/newspaper")
     	public  Newspaper addNewspaper(@RequestBody Newspaper newspaper) {
     		
     				
     		newspaperService.save(newspaper);
     		return newspaper;
     	}
     	@CrossOrigin
     	@PutMapping("/newspaper")
     	public Newspaper updateNewspaper(@RequestBody Newspaper newspaper) {
     		
     		newspaperService.Update(newspaper);
     		
     		return newspaper;
     	}
     	
     	 @GetMapping("/newspapers/one/{newsname}/{newsdate}")
    	 public List<Newspaper> getNewsList(@PathVariable("newsname") String newsname,@PathVariable("newsdate") String newsdate ) {
    		
    		 return newspaperService.getNewsL(newsname,newsdate);
    	 }
    	 
    	 @GetMapping("/newspapers/all/{newsname}")
    	 public List<Newspaper> getNewsAll(@PathVariable("newsname") String newsname ) {
    		 return newspaperService.getNewsAll(newsname);
    	 }
		    
	}


