package com.shop.admin.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.common.entity.User;
import com.shop.common.entity.Role;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	@Autowired
	private RoleRepository roleRepo;
	
	public List<User> listAll(){
		return (List<User>) repo.findAll();
	}
	
	public List<Role> listRoles(){
		return (List<Role>) roleRepo.findAll();
	}

}
