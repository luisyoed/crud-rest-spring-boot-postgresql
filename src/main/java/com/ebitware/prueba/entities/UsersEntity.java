package com.ebitware.prueba.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UsersEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long  userId;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "age")
    private Long age;
    
    @Column(name = "status")
    private Boolean status;
    
    
}
