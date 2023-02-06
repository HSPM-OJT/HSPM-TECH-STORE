package com.hspm.ojt.resource;



import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.User;
import com.hspm.ojt.payload.JwtLoginSuccessResponse;
import com.hspm.ojt.payload.LoginRequest;

import com.hspm.ojt.security.JwtTokenProvider;
import com.hspm.ojt.service.MapValidationErrorService;
import com.hspm.ojt.service.UserService;
import com.hspm.ojt.validation.UserValidator;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
private static final String TOKEN_PREFIX = "Bearer ";
	
	private final UserService userService;
	private final MapValidationErrorService mapErrorService;
	private final UserValidator userValidator;
	private final JwtTokenProvider tokenProvider;
	private final AuthenticationManager authenticationManager;

	public UserController(UserService userService, MapValidationErrorService mapErrorService, UserValidator userValidator, JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		super();
		this.userService = userService;
		this.mapErrorService = mapErrorService;
		this.userValidator = userValidator;
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<User> userOptional = userService.findById(id);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with id="+id+" is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> findByUsername(@PathVariable String email){
		Optional<User> userOptional = userService.findByEmail(email);
		
		if(userOptional.isEmpty())
			return new ResponseEntity<String>("User with username="+email+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOptional.get(),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest,BindingResult result){
		
		ResponseEntity<?> errorResponse = mapErrorService.validate(result);
		
		if(errorResponse != null)
			return errorResponse;
		
		Authentication authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
				);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = TOKEN_PREFIX+tokenProvider.generateToken(authentication);
		
		return ResponseEntity.ok(new JwtLoginSuccessResponse(true,jwt));
		
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createUser(@Valid @RequestBody User user,BindingResult result){
		userValidator.validate(user, result);
		
		ResponseEntity<?> errorResponse = mapErrorService.validate(result);
		
		if(errorResponse != null)
			return errorResponse;
		
		User createdUser = userService.createUser(user);
		
		return new ResponseEntity<User>(createdUser,HttpStatus.CREATED);
		
	}
	@PostMapping("/update")
	public ResponseEntity<?> updateUser(@Valid @RequestBody User user,BindingResult result){
		userValidator.validate(user, result);
		
		ResponseEntity<?> errorResponse = mapErrorService.validate(result);
		
		if(errorResponse != null)
			return errorResponse;
		
		User updatedUser = userService.saveOrUpdateUser(user);
		
		return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
	}
	@GetMapping("/all")
	public ResponseEntity<?> findAllUser(){
		List<User> userList = userService.findAll();
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	@DeleteMapping("/email/{email}")
	public ResponseEntity<String> flashDelete(@PathVariable String email){
		userService.flashDelete(email);
		return new ResponseEntity<String>(email,HttpStatus.OK);
	}


}
