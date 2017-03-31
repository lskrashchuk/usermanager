package by.intexsoft.lskrashchuk.usermanager.security.service;

import by.intexsoft.lskrashchuk.usermanager.model.User;

/**
 * Service for generating token
 */
public interface TokenService {

    /**
     * Generate token
     * @return generated token
     */
    String generate(User user, String password);
}
