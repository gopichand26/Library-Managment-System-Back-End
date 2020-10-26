package com.dxc.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxc.model.Newspaper;
import com.dxc.repository.NewspaperRepository;

@Service
public class NewspaperServiceImpl implements NewspaperService {
    
	
	public  NewspaperServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private NewspaperRepository newspaperRepository;
	
	@Override
	@Transactional
	public List<Newspaper> findAll() {
		return newspaperRepository.findAll();	
		}

	@Override
	@Transactional
	public void save(Newspaper newspaper) {
		
		newspaperRepository.save(newspaper);
	}

	@Override
	@Transactional
	public Optional<Newspaper> findByName(String name) {
		 Optional<Newspaper> newspaper = newspaperRepository.findByName(name);
		
			return newspaper;
		
	}

	@Override
	@Transactional
	public List<Newspaper> findByDate(String date) {
		
		LocalDate dat = LocalDate.parse(date);
		
		 List<Newspaper> newspaper = newspaperRepository.findByDate(dat);
			
			return newspaper;
		}

	@Override
	public Newspaper findById(String name, String date) {
        LocalDate datee = LocalDate.parse(date);
		Newspaper newspaper = newspaperRepository.findById(name, datee);
		return newspaper;
	}
	
	public Newspaper Update(Newspaper newspaper) {
		Optional<Newspaper> res = newspaperRepository.findByName(newspaper.getName());
		if(res.isPresent()) {
			newspaperRepository.save(newspaper);
		}
		return newspaper;
	}

	@Override
	public List<Newspaper> getNewsL(String newsname, String newsdate) {
		LocalDate ndate = LocalDate.parse(newsdate);
		return newspaperRepository.getNewsL(newsname, ndate) ;
	}

	@Override
	public List<Newspaper> getNewsAll(String newsname) {
		// TODO Auto-generated method stub
		return newspaperRepository.getNewAll(newsname);
	}
	

}
