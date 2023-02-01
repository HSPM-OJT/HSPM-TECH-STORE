package com.hspm.ojt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hspm.ojt.domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
  Optional<User> findByEmail(String email);

  Optional<User> getUserById(Long id);
  
}
