package com.ebitware.prueba.vo;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRquestVO implements Serializable{

	private static final long serialVersionUID = -7736956653552556962L;
	
	private Long userId;
	@NotEmpty(message = "Can't be empty")
	private String name;
	@NotEmpty(message = "Can't be empty")
	private String lastName;
	@NotNull(message = "Can't be empty")
	private Long age;
	private Boolean status;
}
