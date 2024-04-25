package com.ebitware.prueba.vo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRquestVO {
	@NotNull(message = "Can't be empty")
	private Long userId;
	@NotEmpty(message = "Can't be empty")
	private String name;
	@NotEmpty(message = "Can't be empty")
	private String lastName;
	@NotNull(message = "Can't be empty")
	private Long age;
	@NotNull(message = "Can't be empty")
	private Boolean status;
}
