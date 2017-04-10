package by.intexsoft.lskrashchuk.usermanager.service;

import by.intexsoft.lskrashchuk.usermanager.model.Tag;

import java.util.List;


public interface TagService {

	void delete(Tag tag);

	void insert(Tag tag);

    Tag find(String name);
    
    List<Tag> getAll();

}
