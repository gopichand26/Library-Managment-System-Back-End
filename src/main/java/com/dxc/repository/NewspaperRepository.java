package com.dxc.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dxc.model.Newspaper;

@Repository
public interface NewspaperRepository extends JpaRepository<Newspaper, String> {
	

		@Query(value = "SELECT * FROM newspaper WHERE name = :name", nativeQuery = true)
	    Optional<Newspaper> findByName(@Param("name") String name );
	 
	    @Query(value = "SELECT * FROM newspaper WHERE date = :date AND name = :name", nativeQuery = true)
	    Newspaper findById(@Param("name") String name, @Param("date") LocalDate datee);
	 
	    @Query(value = "SELECT * FROM newspaper WHERE date = :date", nativeQuery = true)
	    List<Newspaper> findByDate(@Param("date") LocalDate date );
	    
	    @Query(value = "SELECT * FROM newspaper WHERE name = :newsname AND date = :newsdate", nativeQuery = true)
		List<Newspaper> getNewsL(@Param("newsname") String newsname,@Param("newsdate") LocalDate ndate);
		@Query(value = "SELECT * FROM newspaper WHERE name = :newsname", nativeQuery = true)
		List<Newspaper> getNewAll(@Param("newsname") String newsname);
		
		List<Newspaper> findById(boolean id);
		Optional<Newspaper> findById(int id);
	 

}

