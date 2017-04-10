package by.intexsoft.lskrashchuk.usermanager.controller;

import by.intexsoft.lskrashchuk.usermanager.model.User;
import by.intexsoft.lskrashchuk.usermanager.model.dto.TokenDTO;
import by.intexsoft.lskrashchuk.usermanager.security.service.TokenService;
import by.intexsoft.lskrashchuk.usermanager.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

/**
 * Handle requests for authentication operations
 * Works with {@link TokenService}
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    private final TokenService tokenService;
    private final UserService userService;

    @Autowired
    public AuthenticationController(TokenService tokenService, UserService userService) {
        this.tokenService = tokenService;
        this.userService = userService;
    }

    /**
     * Login method
     * Find {@link by.intexsoft.lskrashchuk.usermanager.model.User} in database by username
     * Generate token from {@link TokenService}
     *
     * @return {@link TokenDTO} model
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody User requestUser) {
        LOGGER.info("Start authentication");
        if (isNotEmpty(requestUser.username) && isNotEmpty(requestUser.password)) {
            User user = userService.findByUsername(requestUser.username);
            String token = tokenService.generate(user, DigestUtils.md5Hex(requestUser.password));
            if (token != null) {
                LOGGER.info("Authentication successful! Returning token");
                user.password = EMPTY;
                return new ResponseEntity<>(new TokenDTO(token, user), HttpStatus.OK);
            }
        }
        LOGGER.error("Authentication failed");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}