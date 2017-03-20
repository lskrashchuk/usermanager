package by.intexsoft.lskrashchuk.usermanager.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import by.intexsoft.lskrashchuk.usermanager.model.User;
import by.intexsoft.lskrashchuk.usermanager.service.UserService;

/**
 * Basic controller class
 *
 */
@RestController
public class BasicController
{
	@Autowired
	private UserService userService;

	private static Logger LOGGER = LoggerFactory.getLogger(BasicController.class);

	/**
	 * Home page mapping method
	 * 
	 * @return hello string
	 */
	@RequestMapping("/")
	public String helloWorld()
	{
		LOGGER.info("Home page browsing starts");
		return "Hello, World! Welcome to User Manager!";
	}

	/**
	 * Users page mapping method
	 * 
	 * @return all users list
	 */
	@RequestMapping("/users")
	public List<User> getAllUsers()
	{
		LOGGER.info("Users page browsing starts");
//		return userService.findAll().stream().map(User::toString).collect(Collectors.joining("<br>"));
		return userService.findAll();
	}
}
