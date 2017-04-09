package by.intexsoft.lskrashchuk.usermanager.service.impl;

import by.intexsoft.lskrashchuk.usermanager.model.Tag;
import by.intexsoft.lskrashchuk.usermanager.repository.TagRepository;
import by.intexsoft.lskrashchuk.usermanager.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
	private static Logger LOGGER = LoggerFactory.getLogger(TagServiceImpl.class);

	@Inject
	private TagRepository tagRepository;

	@Override
	public void insert(Tag tag) {
		tagRepository.save(tag);
		LOGGER.info("Tag inserted: {}", tag.getName());
	}

	@Override
	public Tag find(String name) {
		return tagRepository.findByName(name);
	}

	@Override
	public void delete(Tag tag) {
		Tag fullTag = tagRepository.getWithUrls(tag.getId());
		if (fullTag.getUrls().size() == 0) {
			tagRepository.delete(tag.getId());
			LOGGER.info("Tag deleted: {}", tag.getName());
		}
	}

	@Override
	public Tag getWithUrls(Tag tag) {
		return tagRepository.getWithUrls(tag.getId());
	}

	@Override
	public List<Tag> getAll() {
		return tagRepository.findAll();
	}

}
