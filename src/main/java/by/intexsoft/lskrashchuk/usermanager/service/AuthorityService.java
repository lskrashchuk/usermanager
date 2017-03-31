package by.intexsoft.lskrashchuk.usermanager.service;

import by.intexsoft.lskrashchuk.usermanager.model.Authority;

import java.util.List;

public interface AuthorityService {

    Authority find(Integer id);

    List<Authority> findByName(String name);

    List<Authority> findAll();
}
