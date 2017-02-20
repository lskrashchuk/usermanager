package by.intexsoft.lskrashchuk.usermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.intexsoft.lskrashchuk.usermanager.model.User;

/**
 * User repository interface
 *
 */

public interface UserRepository extends JpaRepository<User, Integer>
{
}
