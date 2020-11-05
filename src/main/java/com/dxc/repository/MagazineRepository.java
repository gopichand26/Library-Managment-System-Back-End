package com.dxc.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxc.model.Magazine;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, String> {
	

		@Query(value = "SELECT * FROM magazine WHERE name = :name", nativeQuery = true)
	    Optional<Magazine> findByName(@Param("name") String name );
	 
	    @Query(value = "SELECT * FROM magazine WHERE date = :date AND name = :name", nativeQuery = true)
	    Magazine findById(@Param("name") String name, @Param("date") LocalDate date);
	 
	    @Query(value = "SELECT * FROM magazine WHERE date = :date", nativeQuery = true)
	    List<Magazine> findByDate(@Param("date") LocalDate date );
	    
	    
	    @Query(value = "SELECT * FROM magazine WHERE name = :magname AND date = :magdate", nativeQuery = true)
		List<Magazine> getMagsL(@Param("magname") String magname,@Param("magdate") LocalDate mdate);
		
		@Query(value = "SELECT * FROM magazine WHERE name = :magname", nativeQuery = true)
		List<Magazine> getMagAll(@Param("magname") String magname);
		
		Optional<Magazine> findById(int id);
		List<Magazine> findById(boolean id);
	 

}

