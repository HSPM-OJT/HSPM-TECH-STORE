package com.hspm.ojt.domain;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5766501310550483909L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email(message = "This place must be email")
	@NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "First Name is required")
	private String fname;
	
	@NotBlank(message = "Last Name is required")
	private String lname;
	
	@NotBlank(message = "PhoneNumber is required")
	private String phoneNumber;
	
	@NotBlank(message = "Password is requird")
	private String password;
	
	@Transient
	private String confirmPassword;

	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	private String status="active";
	
	private Users role = Users.CUSTOMER;
	

	
	
	@PrePersist
	void OnCreate() {
		this.createdAt = LocalDate.now();
	}
	
	@PreUpdate
	void OnUpdate() {
		this.updatedAt = LocalDate.now();
	}


	@Override
	@JsonIgnore
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@JsonIgnore
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}


	@Override
	@JsonIgnore
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public User(@Email(message = "This place must be email") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "First Name is required") String fname,
			@NotBlank(message = "Last Name is required") String lname,
			@NotBlank(message = "PhoneNumber is required") String phoneNumber,
			@NotBlank(message = "Password is requird") String password) {
		super();
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.phoneNumber = phoneNumber;
		this.password = password;
	}

	



}
