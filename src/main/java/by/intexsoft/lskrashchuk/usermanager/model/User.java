package by.intexsoft.lskrashchuk.usermanager.model;

import java.util.List;

import javax.persistence.*;

import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 * User entity class
 * 
 *
 */
@Entity
@Table(name = "user_profile")
public class User extends AbstractPersistable<Integer>
{
	private static final long serialVersionUID = 1L;

	/**
	 * User name property
	 */
	@Column(name = "first_name")
	public String name;

	@Column(name = "is_active")
	public Boolean isActive;

	/**
	 * User email
	 */
	@Column(name = "email", nullable = false)
	public String username;

	/**
	 * User password
	 */
	@Column(nullable = false)
	public String password;

	@ManyToMany(targetEntity = Authority.class, fetch = FetchType.EAGER)
	@JoinTable(name = "user_profile_2_authority", joinColumns = {
			@JoinColumn(name = "user_profile_id") }, inverseJoinColumns = { @JoinColumn(name = "authority_id") })
	public List<Authority> authorities;

	/**
	 * @return Returns a string representation of the object User.
	 */
	public String toString()
	{
		return "User: " + name + " " + (isActive ? "active" : "inactive");
	}

}
