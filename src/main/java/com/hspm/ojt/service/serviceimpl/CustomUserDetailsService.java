package com.hspm.ojt.service.serviceimpl;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hspm.ojt.Exception.EmailNotFoundException;
import com.hspm.ojt.domain.User;
import com.hspm.ojt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws EmailNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findByEmail(email);
		if(userOpt.isEmpty())
			throw new EmailNotFoundException("username with name="+email+"is not found");
		return (UserDetails) userOpt.get();
	}
	
	public User loadUserById(Long id) {
		Optional<User> userOptional = userRepository.getUserById(id);
		
		if(userOptional.isEmpty())
			throw new UsernameNotFoundException("User with id="+id+" is not found");
		
		return userOptional.get();
		
	}

}
