package by.intexsoft.lskrashchuk.usermanager.service;

import java.util.List;

import by.intexsoft.lskrashchuk.usermanager.model.User;

/**
 * User service interface
 *
 */
public interface UserService
{
	List<User> findAll();
}
