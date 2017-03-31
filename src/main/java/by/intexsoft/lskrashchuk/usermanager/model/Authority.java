package by.intexsoft.lskrashchuk.usermanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * Description database table "authority"
 */
@Entity
@Table
public class Authority extends AbstractPersistable<Integer> implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	/**
     * Authority name
     */
    @Column(unique = true, nullable = false)
    public String name;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return name;
    }
}
