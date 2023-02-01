package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;


import com.hspm.ojt.domain.User;

public interface UserService {
	User saveOrUpdateUser(User user);
	List<User> findAll();
	Optional<User> findById(Long id);
	Optional<User> findByEmail(String email);
	User createUser(User user);
	void flashDelete(Long id);
}
