package com.ebitware.prueba.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteRequestVo {
	
	@NotNull(message = "Can't be empty")
	private Long userId;
	@NotNull(message = "Can't be empty")
	private Boolean status;

}
