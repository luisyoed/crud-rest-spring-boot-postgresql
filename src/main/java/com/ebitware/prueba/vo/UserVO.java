package com.ebitware.prueba.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVO {
    private Long userId;
    private String name;
    private String lastName;
    private Long age;
    private Boolean status;
}