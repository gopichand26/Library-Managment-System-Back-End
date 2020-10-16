package com.dxc.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Newspaper;

public interface NewspaperRepository extends JpaRepository<Newspaper, String> {
	List<Newspaper> findByName(boolean name);
	Optional<Newspaper> findByName(String name);
	List<Newspaper> findByDate(boolean date);
	

}
