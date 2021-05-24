package com.shop.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shop.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{


}
