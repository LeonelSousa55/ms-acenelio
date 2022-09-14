package br.com.leonel.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leonel.hroauth.entities.User;
import br.com.leonel.hroauth.feignclients.UserFeignClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();
        if (user == null){
            log.error("Email not found: {}", email);
            throw new IllegalArgumentException("Email not found");
        }

        log.info("Email found: {}", email);
        return user;
    }
}
