import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import service.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-beans.xml" })
public class RestUserTest {
	
	 @Autowired
	 private UserDaoService userService;
	 
	 @Autowired
	 private RoleDaoService roleService;
	 
	 private User createUser(){
		 User newUser = new User();
		 newUser.setId(0L);
		 newUser.setLogin("log6");
		 newUser.setPassword("666");
		 newUser.setFirstName("fname6");
		 newUser.setLastName("lname6");
		 newUser.setEmail("log6@mail.ru");
		 newUser.setRole(roleService.findByName("Admin"));	 
		 
		 return newUser;
	 }
	 
	@Test
	public void testFindUser() {
		User user = userService.findByLogin("log1");
		Assert.assertNotNull(user);
		Assert.assertTrue(user.getLogin().equals("log1"));
	}
	
	@Test
	public void testFindAllUser() {
		List<User> userAll = new ArrayList<User>();
		userAll = userService.findAll();
		Assert.assertNotNull(userAll);
	}
	
	@Test
	public void testCreateUser() {
		User userNew = createUser();
		userService.create(userNew);
		User user = userService.findByLogin("log6");
		Assert.assertNotNull(user);
		userService.remove(user);
	}
	
	@Test
	public void testDeleteAllUser() {
		User userNew = createUser();
		userService.create(userNew);
		User user = userService.findByLogin("log6");
		Assert.assertNotNull(user);
		
		userService.remove(user);
		User userRemove = userService.findByLogin("log6");
		Assert.assertNull(userRemove);
	}
	
	@Test
	public void testUpdateAllUser() {
		User userNew = createUser();
		userService.create(userNew);
		User user = userService.findByLogin("log6");
		Assert.assertNotNull(user);

		user.setLogin("log7");
		user.setPassword("777");
		user.setFirstName("fname7");
		user.setLastName("lname7");
		user.setEmail("log7@mail.ru");
		user.setRole(roleService.findByName("User"));
		
		userService.update(user);
		
		Assert.assertNull(userService.findByLogin("log6"));
		Assert.assertNotNull(userService.findByLogin("log7"));
		
		userService.remove(user);
		Assert.assertNull(userService.findByLogin("log7"));
	}
}
