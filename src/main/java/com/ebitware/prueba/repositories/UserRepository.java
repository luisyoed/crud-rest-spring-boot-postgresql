package com.ebitware.prueba.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebitware.prueba.entities.UsersEntity;

@Service
public interface UserRepository extends JpaRepository<UsersEntity, Long> {
	
	@Modifying
	@Transactional
    @Query(value = "UPDATE users SET status = :status WHERE user_id = :id", nativeQuery = true)
    void updateUserStatus(@Param("id") Long id, @Param("status") Boolean status);
	
	

}
