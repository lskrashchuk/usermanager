package by.intexsoft.lskrashchuk.usermanager.service;

import java.util.List;

import by.intexsoft.lskrashchuk.usermanager.model.User;

/**
 * User service interface
 *
 */
public interface UserService
{
    /**
     * Find all {@link User}s 
     * @return list of {@link User} 
     */
	List<User> findAll();
	
    /**
     * Save {@link User} entity
     */
    User save(User user);
    
    /**
     * Delete {@link User} by identifier
     * @param id
     */
    void delete(Integer id);

	User findByUsername(String username);

	User find(Integer id);

	Object update(User user);

	Object create(User user);
	
}
