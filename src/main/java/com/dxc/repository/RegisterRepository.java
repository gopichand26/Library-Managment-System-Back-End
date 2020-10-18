package com.dxc.repository;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Register;

public interface RegisterRepository extends JpaRepository<Register, Integer> {
	
	@Query(value = "SELECT r FROM Register r WHERE r.name  = :name")
	List<Register> findByName(String name);
	 
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	 @Modifying
	 @Query("UPDATE Register r SET r.outtime = :time WHERE r.id = :id")
	 void update(int id,LocalTime time);

}
