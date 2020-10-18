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

import com.dxc.model.Magazine;
import com.dxc.repository.MagazineRepository;

@RestController @CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api")
public class MagazineController {
	
	@Autowired
	  MagazineRepository magazineRepository;
	
	@GetMapping("/magazines")
	public List<Magazine> findAll() {
		return  magazineRepository.findAll();
	}
	 @GetMapping("/magazines/{name}")
	  public ResponseEntity<Magazine> getMagazineByName(@PathVariable("name") String name) {
	    Optional<Magazine> magazineData = magazineRepository.findByName(name);

	    if (magazineData.isPresent()) {
	      return new ResponseEntity<>(magazineData.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	@PostMapping("/magazines")
	public  Magazine addMagazine(@RequestBody Magazine magazine) {
		return magazineRepository.save(magazine);
	}
	 
	 @PutMapping("/magazines/{name}")
	  public ResponseEntity<Magazine> updateMagazine(@PathVariable("name") String name, @RequestBody Magazine magazine) {
	    Optional<Magazine> magazineData = magazineRepository.findByName(name);

	    if (magazineData.isPresent()) {
	      Magazine _magazine = magazineData.get();
	      _magazine.setFloorno(magazine.getFloorno());
	      _magazine.setShelfno(magazine.getShelfno());
	      _magazine.setName(magazine.getName());
	      _magazine.setDate(magazine.getDate());
	      return new ResponseEntity<>(magazineRepository.save(_magazine), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

	 @GetMapping("/magazines/name")
	  public ResponseEntity<List<Magazine>> findByName() {
	    try {
	      List<Magazine> magazines = magazineRepository.findByName(true);

	      if (magazines.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(magazines, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	 
	 @GetMapping("/magazines/date")
	  public ResponseEntity<List<Magazine>> findByDate() {
	    try {
	      List<Magazine> magazines = magazineRepository.findByDate(true);

	      if (magazines.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<>(magazines, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }


}
