package com.examples.boot.security.repo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.examples.boot.security.model.UserAccount;

public interface UserRepository extends MongoRepository<UserAccount, Long> { //JpaRepository<UserAccount, Long> {
	
	public Optional<UserAccount> findByUserName(String userName);
	
}
