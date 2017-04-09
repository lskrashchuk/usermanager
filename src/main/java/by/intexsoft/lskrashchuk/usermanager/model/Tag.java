package by.intexsoft.lskrashchuk.usermanager.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;

/**
 * Tag entity class
 */
@Entity
public class Tag extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column
	private String name;
	
	@JoinTable(name = "url_2_tag", joinColumns = {@JoinColumn(name = "tag_id")}, inverseJoinColumns = {@JoinColumn(name = "url_id")})
	@ManyToMany(targetEntity = Url.class, fetch = FetchType.EAGER)
	private List<Url> urls;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Url> getUrls() {
		return urls;
	}

	public void setUrls(List<Url> urls) {
		this.urls = urls;
	}
}
