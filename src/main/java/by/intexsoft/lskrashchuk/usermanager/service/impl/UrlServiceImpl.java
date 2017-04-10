package by.intexsoft.lskrashchuk.usermanager.service.impl;

import by.intexsoft.lskrashchuk.usermanager.model.Url;
import by.intexsoft.lskrashchuk.usermanager.repository.UrlRepository;
import by.intexsoft.lskrashchuk.usermanager.service.TagService;
import by.intexsoft.lskrashchuk.usermanager.service.UrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class UrlServiceImpl implements UrlService {
	private static Logger LOGGER = LoggerFactory.getLogger(UrlServiceImpl.class);
	
	@Inject
	private UrlRepository urlRepository;

	@Inject
	private TagService tagService;

	@Override
	public Url getUrl(Integer id) {
		return urlRepository.findOne(id);

	}

	@Override
	public void saveOrUpdate(Url url) {
		if (url.getId() == null) {
			url.setCreated(new Date());
			urlRepository.save(url);
			LOGGER.info("Url inserted: {}", url.getUrlCode());
		} else {
			urlRepository.save(url);
			LOGGER.info("Url updated: {}", url.getUrlCode());
		}
	}

	@Override
	public void delete(Url url) {
		urlRepository.delete(url.getId());
		LOGGER.info("Url deleted: {}", url.getUrlCode());
	}

	@Override
	public Url find(String urlCode) {
		return urlRepository.findByUrlCode(urlCode);
	}

	@Override
	public List<Url> getAll() {
		return urlRepository.findAll();
	}

	@Override
	public String redirect(Url url) {
		if (url.getClicks()==null) {
			url.setClicks(0);
		}
		url.setClicks(url.getClicks()+1);
		saveOrUpdate(url);
		return url.getFullUrl();
	}

	@Override
	public void checkIfClicksCountChangedBeforeUpdate(Url url) {
		if (url.getId() != null) {
			url.setClicks(find(url.getUrlCode()).getClicks());
		}
		saveOrUpdate(url);
	}

}
