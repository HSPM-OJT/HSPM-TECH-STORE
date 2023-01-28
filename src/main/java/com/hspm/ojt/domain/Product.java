package com.hspm.ojt.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Product code is required")
	@Size(min = 4,max = 8 ,message = "Product Code must be 4 to 8")
	@Column(updatable = false, unique = true)
	private String productCode;

	@NotBlank(message = "Product Name is required")
	private String productName;

	@NotNull(message = "Price is required")
	private Double price;
	
	private Integer quantity = 1;

	@NotBlank(message = "Product Description is required")
	private String description;

	private LocalDate createAt;
	private LocalDate updateAt;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expireDate;
	private String status = "active";
	
	@NotBlank(message = "Image field is required")
	private String image;

	@PrePersist
	void onCreate() {
		this.createAt = LocalDate.now();
	}
	
	void onUpdate() {
		this.updateAt = LocalDate.now();
	}
	
	
	

}
