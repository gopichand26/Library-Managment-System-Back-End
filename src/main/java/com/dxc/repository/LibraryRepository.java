package com.dxc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.dxc.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

	@Query(value = "SELECT * FROM library WHERE floor_no = :floor_no", nativeQuery = true)
    Optional<Library> findByFloor_no(@Param("floor_no") int floor_no );
 
 

	
}