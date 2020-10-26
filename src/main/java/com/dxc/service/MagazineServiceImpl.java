package com.dxc.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxc.model.Magazine;
import com.dxc.repository.MagazineRepository;

@Service
public class MagazineServiceImpl implements MagazineService {
    
	
	public  MagazineServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	@Transactional
	public List<Magazine> findAll() {
		return magazineRepository.findAll();	
		}

	@Override
	@Transactional
	public void save(Magazine magazine) {
		
		magazineRepository.save(magazine);
	}

	@Override
	@Transactional
	public Optional<Magazine> findByName(String name) {
		 Optional<Magazine> magazine = magazineRepository.findByName(name);
		
			return magazine;
		
	}

	@Override
	@Transactional
	public List<Magazine> findByDate(LocalDate date) {
		 List<Magazine> magazine = magazineRepository.findByDate(date);
			
			return magazine;
		}

	@Override
	public Magazine findById(String name, LocalDate date) {
		Magazine magazine = magazineRepository.findById(name, date);
		return magazine;
	}
	
	public Magazine Update(Magazine magazine) {
		Optional<Magazine> res = magazineRepository.findByName(magazine.getName());
		if(res.isPresent()) {
			magazineRepository.save(magazine);
		}
		return magazine;
	}

	@Override
	public List<Magazine> getMagsL(String magname, String magdate) {
		// TODO Auto-generated method stub
		 LocalDate mdate = LocalDate.parse(magdate);
		 
		return magazineRepository.getMagsL(magname, mdate);
	}

	@Override
	public List<Magazine> getMagAll(String magname) {
		// TODO Auto-generated method stub
		return magazineRepository.getMagAll(magname);
	}

	
	

}
