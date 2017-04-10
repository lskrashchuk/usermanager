package by.intexsoft.lskrashchuk.usermanager.repository;

import by.intexsoft.lskrashchuk.usermanager.model.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Url repository interface
 *
 */

public interface UrlRepository extends JpaRepository<Url, Integer>
{
    @Query("select u from Url u where u.urlCode = :urlCode")
    Url findByUrlCode(@Param("urlCode") String urlCode);
}
