package com.dxc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.model.Magazine;

public interface MagazineRepository extends JpaRepository<Magazine, String> {
	List<Magazine> findByName(boolean name);
	Optional<Magazine> findByName(String name);
	List<Magazine> findByDate(boolean date);

}
