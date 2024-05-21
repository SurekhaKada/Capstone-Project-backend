package com.example.invoice;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ch.qos.logback.classic.Logger;
import jakarta.validation.Valid;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
    private UserService userService;

    private static final Logger logger = (Logger) LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public Users createUser(@RequestBody Users user) {
        logger.info("Received request to create user: {}", user);
        return userService.createUser(user);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        logger.info("Received request to get all users");
        return userService.getAllUsers();
        
    }
    
    @GetMapping("/user")
    public ResponseEntity<Integer> getUser(@Valid @RequestParam String userName, @RequestParam String password) {
        logger.info("getUser: userName=" + userName + ", password=" + password);
        return userService.getUser(userName, password);
        
    }
    
    @GetMapping("/exists/{userName}")
    public int isUsernameExists(@PathVariable String userName) {
        return userService.isUsernameExists(userName);
    }


    

    }
    

   