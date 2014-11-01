import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import service.RoleDaoService;
import service.UserDaoService;

//import dao.Role;
//import dao.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/test-beans.xml" })
public class RestRoleTest {
	
	 @Autowired
	 private RoleDaoService roleService;

	@Test
	public void testFindRole() {
		Assert.assertNull(roleService.findByName("Guest"));
		Assert.assertNotNull(roleService.findByName("Admin"));
	}
}
