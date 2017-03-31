package by.intexsoft.lskrashchuk.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import by.intexsoft.lskrashchuk.usermanager.model.User;

/**
 * User repository interface
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>
{
    @Query("select u from User u where u.email = :username")
	User findByUsername(String username);
}
