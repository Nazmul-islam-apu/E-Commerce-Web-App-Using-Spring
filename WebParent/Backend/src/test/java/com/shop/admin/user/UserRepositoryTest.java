package com.shop.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shop.common.entity.Role;
import com.shop.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class,1);
		User userNameNI = new User("apunazmul6@gmail.com","nazmul123","Md Nazmul","Islam");
		userNameNI.addRole(roleAdmin);
		User savedUser = repo.save(userNameNI);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWithTwoRoles() {
		User userNameNAS = new User("samiashipu1414@gmail.com","nafisa123","Nafisa Anjum","Samia");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		userNameNAS.addRole(roleEditor);
		userNameNAS.addRole(roleAssistant);
		User savedUser = repo.save(userNameNAS);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> allUsers = repo.findAll();
		allUsers.forEach(user-> System.out.println(user));
	}

}
