package com.dxc.controller;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.dxc.repository.NewspaperRepository;
import com.dxc.service.NewspaperService;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class NewspaperController {


         @Autowired
		 private NewspaperService newspaperService;
         
         @Autowired NewspaperRepository newspaperRepository;
     	
     	
    	 @GetMapping("/newspapers")
    	 public List<Newspaper> findAll() {
    		return  newspaperRepository.findAll();
        	}
    	
    	 
    	 @PostMapping("/newspapers")
    	 public  Newspaper addNewspaper(@RequestBody Newspaper newspaper) {
    		return newspaperRepository.save(newspaper);
    	 }
    	 
    	 @GetMapping("/newspapers/{id}")
    	  public ResponseEntity<Newspaper> getNewspaperById(@PathVariable("id") int id) {
    	    Optional<Newspaper> newspaperData = newspaperRepository.findById(id);

    	    if (newspaperData.isPresent()) {
    	      return new ResponseEntity<>(newspaperData.get(), HttpStatus.OK);
    	    } else {
    	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	    }
    	  }
    	 
    	 @PutMapping("/newspapers/{id}")
    	  public ResponseEntity<Newspaper> updateNewspaper(@PathVariable("id") int id, @RequestBody Newspaper newspaper) {
    	    Optional<Newspaper> newspaperData = newspaperRepository.findById(id);

    	    if (newspaperData.isPresent()) {
    	      Newspaper _newspaper = newspaperData.get();
    	      _newspaper.setId(newspaper.getId());
    	      _newspaper.setFloorno(newspaper.getFloorno());
    	      _newspaper.setShelfno(newspaper.getShelfno());
    	      _newspaper.setName(newspaper.getName());
    	      _newspaper.setDate(newspaper.getDate());
    	      return new ResponseEntity<>(newspaperRepository.save(_newspaper), HttpStatus.OK);
    	    } else {
    	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	    }
    	  }
    	 
    		 @GetMapping("/newspapers/id")
    		  public ResponseEntity<List<Newspaper>> findById() {
    		    try {
    		      List<Newspaper> newspapers = newspaperRepository.findById(true);

    		      if (newspapers.isEmpty()) {
    		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		      }
    		      return new ResponseEntity<>(newspapers, HttpStatus.OK);
    		    } catch (Exception e) {
    		      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    		    }
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
//     	@CrossOrigin
//     	@GetMapping("/newspapers/{date}")
//     	public List<Newspaper> getNewspaperByDate(@PathVariable String date) {
//     		
//     		List<Newspaper> newspaper = (List<Newspaper>) newspaperService.findByDate(date);
//     		
//     		if (newspaper == null) {
//     			throw new RuntimeException("Newspaper not found - " + date);
//     		}
//     		
//     		return newspaper;
//     	}
     	
     	@GetMapping("/newspapers/{name}/{date}")
     	public Newspaper getNewspaper(@PathVariable String name, @PathVariable String date) {
     		
     		
     		Newspaper newspaper = newspaperService.findById(name, date);
     		
     		if (newspaper == null) {
     			throw new RuntimeException("Newspaper not found - " + name);
     		}
     		return newspaper ;
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


