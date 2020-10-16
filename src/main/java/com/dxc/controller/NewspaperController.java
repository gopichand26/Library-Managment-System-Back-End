package com.dxc.controller;

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

import com.dxc.model.Newspaper;
import com.dxc.repository.NewspaperRepository;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class NewspaperController {
	
	@Autowired
	  NewspaperRepository newspaperRepository;
	
	@GetMapping("/newspapers")
	public List<Newspaper> findAll() {
		return  newspaperRepository.findAll();
	}
	 @GetMapping("/newspapers/{name}")
	  public ResponseEntity<Newspaper> getNewspaperByName(@PathVariable("name") String name) {
	    Optional<Newspaper> newspaperData = newspaperRepository.findByName(name);

	    if (newspaperData.isPresent()) {
	      return new ResponseEntity<>(newspaperData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@PostMapping("/newspapers")
	public  Newspaper addNewspaper(@RequestBody Newspaper newspaper) {
		return newspaperRepository.save(newspaper);
	}
	 
	 @PutMapping("/newspapers/{name}")
	  public ResponseEntity<Newspaper> updateNewspaper(@PathVariable("name") String name, @RequestBody Newspaper newspaper) {
	    Optional<Newspaper> newspaperData = newspaperRepository.findByName(name);

	    if (newspaperData.isPresent()) {
	      Newspaper _newspaper = newspaperData.get();
	      _newspaper.setFloorno(newspaper.getFloorno());
	      _newspaper.setShelfno(newspaper.getShelfno());
	      return new ResponseEntity<>(newspaperRepository.save(_newspaper), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	 @GetMapping("/newspapers/name")
	  public ResponseEntity<List<Newspaper>> findByName() {
	    try {
	      List<Newspaper> newspapers = newspaperRepository.findByName(true);

	      if (newspapers.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(newspapers, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @GetMapping("/newspapers/date")
	  public ResponseEntity<List<Newspaper>> findByDate() {
	    try {
	      List<Newspaper> newspapers = newspaperRepository.findByDate(true);

	      if (newspapers.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(newspapers, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


}
