package com.securitydb.bootstrap;

import com.securitydb.entity.User;
import com.securitydb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class DataGenerator implements CommandLineRunner {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DataGenerator(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        this.userRepository.deleteAll();

        User user = new User("ruslan", passwordEncoder.encode("ruslan"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin123"), "ADMIN", "ACCESS_TEST1, ACCESS_TEST2");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "ACCESS_TEST1");

        this.userRepository.save(user);
        this.userRepository.save(admin);
        this.userRepository.save(manager);

    }
}
