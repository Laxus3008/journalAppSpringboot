package net.myApplication.journalApp.service;

import lombok.extern.slf4j.Slf4j;
import net.myApplication.journalApp.entity.JournalEntry;
import net.myApplication.journalApp.entity.User;
import net.myApplication.journalApp.repository.JournalEntryRepository;
import net.myApplication.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Component
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

//    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public boolean saveNewUser(User user) {
        try{
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        }
        catch (Exception e) {
//            logger.info("hahhahahahha");
//            logger.error("Error occured for {} :", user.getUserName(), e);
            log.error("hahahah");
            log.info("hahahah");
            log.debug("hahahah");
            log.warn("hahahah");
            log.trace("hahahah");
            return false;
        }


    }

    public void saveAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "ADMIN"));
        userRepository.save(user);

    }

    public void saveUser(User user) {
        userRepository.save(user);

    }

    public List<User> getAll() {

        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id) {

        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {

        userRepository.deleteById(id);
    }

    public User findByUserName(String userName) {

        return userRepository.findByUserName(userName);
    }
}

// controller --> service --> repository
