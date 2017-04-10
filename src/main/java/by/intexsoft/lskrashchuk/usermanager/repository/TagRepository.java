package by.intexsoft.lskrashchuk.usermanager.repository;

import by.intexsoft.lskrashchuk.usermanager.model.Tag;
import by.intexsoft.lskrashchuk.usermanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Tag repository interface
 *
 */

public interface TagRepository extends JpaRepository<Tag, Integer>
{
    @Query("select t from Tag t where t.name = :name")
	Tag findByName(@Param("name") String name);
}
