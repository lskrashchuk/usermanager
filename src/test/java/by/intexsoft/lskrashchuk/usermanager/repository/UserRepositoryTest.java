package by.intexsoft.lskrashchuk.usermanager.repository;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import by.intexsoft.lskrashchuk.usermanager.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class UserRepositoryTest
{
	@Autowired
	private UserRepository userRepository;

	@Test
	public void test()
	{
		assertNotNull(userRepository);
	}

	@Test
	public void testFindAll()
	{
		List<User> result = userRepository.findAll();
		assertEquals(4, result.size());
	}

	@Test
	public void testCount()
	{
		long result = userRepository.count();
		assertEquals(4, result);
	}
	
	@Test
	public void testFindOne()
	{
		User user = userRepository.findOne(1);
		assertEquals("Tatiana", user.name);
	}

}
