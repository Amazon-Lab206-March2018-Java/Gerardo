package com.gerardo.loginandreg.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.gerardo.loginandreg.models.User;

public interface UserRepository extends CrudRepository <User, Long>{
	List<User> findAll ();
	User findByEmail (String email);

	@Modifying
	@Transactional
	@Query ("update User u set u.lastSignIn = ?1 WHERE u.id = ?2")
	void setLastSignIn (Date date, Long id);
	
}
