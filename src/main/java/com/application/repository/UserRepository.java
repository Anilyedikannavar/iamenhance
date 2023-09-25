package com.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.model.User;


public interface UserRepository extends JpaRepository<User,Long>{ 



boolean existsByEmail(String email);
}