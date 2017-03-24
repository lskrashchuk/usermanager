package by.intexsoft.lskrashchuk.usermanager.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.intexsoft.lskrashchuk.usermanager.model.User;
import by.intexsoft.lskrashchuk.usermanager.repository.UserRepository;
import by.intexsoft.lskrashchuk.usermanager.service.UserService;

/**
 * User service implementation
 *
 */
@Service
public class UserServiceImpl implements UserService
{
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	public void setUserRepository(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}

	/**
	 * The method finds all users
	 * 
	 * @return all users list
	 */
	@Override
	public List<User> findAll()
	{
		LOGGER.info("Find all users method starts");
		try
		{
			List<User> result = userRepository.findAll();
			LOGGER.info("Ñompleted successfully");
			return result;
		} catch (Exception e)
		{
			LOGGER.error("Ñompleted with error");
			return null;
		}
	}

	@Override
	public User save(User user)
	{
		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id)
	{
		userRepository.delete(id);
	}

}
