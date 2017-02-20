package by.intexsoft.lskrashchuk.usermanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User entity class
 * 
 *
 */
@Entity
@Table(name = "users")
public class User extends AbstractPersistable<Integer>
{
	private static final long serialVersionUID = 1L;

	/**
	 * User name property
	 */
	@Column(name = "name")
	public String name;

	/**
	 * @return Returns a string representation of the object User.
	 */
	public String toString()
	{
		return "User: " + name;
	}

}
