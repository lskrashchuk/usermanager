package by.intexsoft.lskrashchuk.usermanager.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.intexsoft.lskrashchuk.usermanager.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class UserProfileServiceTest {

	@Inject
	private UserService userService;
	@Test
	public void test() {

		Assert.assertNotNull(userService);

	}

	@Test
	public void testFind()
	{
		User user = userService.findByUsername("lskrashchuk@gmail.com");
		assertEquals("Larisa", user.name);
		assertEquals(DigestUtils.md5Hex("111"), user.password);
		assertEquals(new Integer(6), user.getId());
		
//		assertNull(user);
	}

	@Test
	public void testFindAll()
	{
		List<User> userList = userService.findAll();
//		assertEquals("Larisa", user.name);
		assertEquals(7,userList.size());
	}

}
