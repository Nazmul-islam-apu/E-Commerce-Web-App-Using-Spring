package com.shop.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length=128,nullable=false,unique = true)
	private String email;
	@Column(length=64,nullable=false,unique=true)
	private String password;
	@Column(name="first_name",length=45,nullable=false)
	private String firstName;
	@Column(name="last_name",length=45,nullable=false)
	private String lastName;
	
	private String photos;
	private Boolean enabled;
	

}
