package by.intexsoft.lskrashchuk.usermanager.service.impl;

import by.intexsoft.lskrashchuk.usermanager.model.Authority;
import by.intexsoft.lskrashchuk.usermanager.repository.AuthorityRepository;
import by.intexsoft.lskrashchuk.usermanager.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorityServiceImpl implements AuthorityService {

    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityServiceImpl(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public Authority find(Integer id) {
        return authorityRepository.findOne(id);
    }

    @Override
    public List<Authority> findByName(String name) {
        return authorityRepository.findByName(name);
    }

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }
}
