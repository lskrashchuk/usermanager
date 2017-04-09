package by.intexsoft.lskrashchuk.usermanager.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Url entity class
 */
@Entity
public class Url extends AbstractPersistable<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column (name = "full_url")
	private String fullUrl;
	
	@Column (name = "url_code")
	private String urlCode;
	
	@Column
	private Date created;

	@Column
	private String description;
	
	@Column
	private Integer clicks;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_profile_id")
	private User userProfile;
	
	@JoinTable(name = "url_2_tag", joinColumns = {@JoinColumn(name = "url_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
	@ManyToMany(targetEntity = Tag.class, fetch = FetchType.EAGER)
	private List<Tag> tags;

	public String getFullUrl() {
		return fullUrl;
	}

	public void setFullUrl(String fullUrl) {
		this.fullUrl = fullUrl;
	}

	public String getUrlCode() {
		return urlCode;
	}

	public void setUrlCode(String urlCode) {
		this.urlCode = urlCode;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public User getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(User userProfile) {
		this.userProfile = userProfile;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
