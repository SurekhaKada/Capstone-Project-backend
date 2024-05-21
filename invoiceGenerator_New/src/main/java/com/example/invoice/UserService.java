package com.example.invoice;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;



import ch.qos.logback.classic.Logger;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserService.class);

    public Users createUser(Users user) {
        user.setSignInDate(LocalDate.now());
        logger.info("Creating user: {}", user);
        return userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        logger.info("Fetching all users");
        return userRepository.findAll();
    }
    public int isUsernameExists(String userName) {
      
        Users existingUser = userRepository.findByUserName(userName);
//        return existingUser != null;
        if (existingUser!=null) {
            return existingUser.getUserId();
        } else {
            // Password does not match
            return 401; // Unauthorized
        }
      
    }


    
    
    public ResponseEntity<Integer> getUser(String username, String password) {
        Users user = userRepository.findByUserName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return ResponseEntity.ok(user.getUserId());
            } else {
                // Password does not match
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(401); // Unauthorized
            }
        } else {
            // User not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(404); // Not Found
        }
    }

    
//    public int getUser(String userName, String password) {
//        Users user = userRepository.findByUserName(userName);
//        if (user != null) {
//            if (user.getPassword().equals(password)) {
//                return user.getUserId();
//            } else {
//                // Password does not match
//                return (Integer) null; // Unauthorized
//            }
//        } else {
//            // User not found
//            return 404; // Not Found
//        }
//    }

    
  
  
}

   
