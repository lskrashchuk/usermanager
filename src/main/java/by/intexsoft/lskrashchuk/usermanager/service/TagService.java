package by.intexsoft.lskrashchuk.usermanager.service;

import by.intexsoft.lskrashchuk.usermanager.model.Tag;

import java.util.List;


public interface TagService {

	void delete(Tag tag);

	void insert(Tag tag);

    Tag find(String name);
    
    Tag getWithUrls(Tag tag);
    
    List<Tag> getAll();

}
