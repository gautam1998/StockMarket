package com.sm1.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sm1.login.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
	
	void deleteByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);
}
