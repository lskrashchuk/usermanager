package by.intexsoft.lskrashchuk.usermanager.service.impl;

import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import by.intexsoft.lskrashchuk.usermanager.model.User;
import by.intexsoft.lskrashchuk.usermanager.repository.UserRepository;

public class UserServiceImplTest
{
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setup()
	{
		this.userServiceImpl = new UserServiceImpl();
	}
	
	@Test
	public void testNotNull() 
	{
		assertNotNull(userServiceImpl);
	}
	
	@Test
	public void testFindAllForNullResultList()
	{
		UserRepository userRepository = mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		when(userRepository.findAll()).thenReturn(null);
		List<User> result = userServiceImpl.findAll();
		assertEquals(null, result);

	}

	@Test
	public void testFindAllForOneUserInResultList()
	{
		UserRepository userRepository = mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		
		User user = new User();
		user.name = "Anna";

		when(userRepository.findAll()).thenReturn(singletonList(user));
		List<User> result = userServiceImpl.findAll();
		assertEquals(1, result.size());
		assertEquals("Anna", result.get(0).name);
		verify(userRepository).findAll();
	}
	
	@Test
	public void testFindAll_RepositoryTrowException()
	{
		this.userServiceImpl = new UserServiceImpl();
		UserRepository userRepository = mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		doThrow(new RuntimeException()).when(userRepository).findAll();
		List<User> result = userServiceImpl.findAll();
		assertEquals(null, result);
	}

}
