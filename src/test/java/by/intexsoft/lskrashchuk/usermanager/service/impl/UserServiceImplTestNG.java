package by.intexsoft.lskrashchuk.usermanager.service.impl;

import static java.util.Collections.singletonList;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.intexsoft.lskrashchuk.usermanager.model.User;
import by.intexsoft.lskrashchuk.usermanager.repository.UserRepository;

public class UserServiceImplTestNG
{
	private UserServiceImpl userServiceImpl;
	
	@DataProvider
	public Object[][] userNames() {
		return new Object[][] 
		{
			{null, null},
			{"Anna", "Anna"}
		};
	}
	
	@Test(dataProvider = "userNames")
	public void testFindAll(String name, String expected)
	{
		this.userServiceImpl = new UserServiceImpl();
		UserRepository userRepository = mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		
		User user = new User();
		user.name = name;
		
		when(userRepository.findAll()).thenReturn(singletonList(user));
		List<User> result = userServiceImpl.findAll();
		assertEquals(result.get(0).name, expected);
	}
	
	@Test
	public void testFindAll_RepositoryTrowException()
	{
		this.userServiceImpl = new UserServiceImpl();
		UserRepository userRepository = mock(UserRepository.class);
		userServiceImpl.setUserRepository(userRepository);
		doThrow(new RuntimeException()).when(userRepository).findAll();
		List<User> result = userServiceImpl.findAll();
		assertEquals(result, null);
	}
}
