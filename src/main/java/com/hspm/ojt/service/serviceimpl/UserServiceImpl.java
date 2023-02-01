package com.hspm.ojt.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hspm.ojt.Exception.EmailAlreadyExistException;
import com.hspm.ojt.Exception.EmailNotFoundException;
import com.hspm.ojt.domain.User;
import com.hspm.ojt.repository.UserRepository;
import com.hspm.ojt.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
 
	
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.passwordEncoder = bCryptPasswordEncoder;
	}

	@Override
	public User saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
//		Optional<User> userOpt = userRepository.findById(user.getId());
//		if(userOpt.isEmpty())
//			throw new EmailNotFoundException("Email with id"+user+"is noy found");
		
		
		return userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> activeUser = (List<User>) userRepository.findAll()/*.stream().filter(u -> u.getStatus().equals("active")).toList()*/;
		return activeUser;

	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public Optional<User> findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.findByEmail(user.getEmail());
		
		if(userOpt.isPresent())
			throw new EmailAlreadyExistException("This email is already taken");
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		return saveOrUpdateUser(user);
	}

	@Override
	public void flashDelete(Long id) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = userRepository.getUserById(id);
		
		if(userOpt.isEmpty())
			throw new EmailAlreadyExistException("User with id"+id+"is not found");
		
		User user = userOpt.get();
		
		user.setStatus("deleted");
		userRepository.save(user);
		
	}
	
	

}
