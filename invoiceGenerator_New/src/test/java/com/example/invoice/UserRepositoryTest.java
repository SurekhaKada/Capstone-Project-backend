package com.example.invoice;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
    
        Users user = new Users();
        user.setUserName("testcase3");
        user.setPassword("pwd");
        user.setEmail("s1@example.com");
        Users savedUser = userRepository.save(user);

     
        assertNotNull(savedUser.getUserId());
        assertEquals("testcase3", savedUser.getUserName());
        assertNotEquals("j@example", savedUser.getEmail());
    }

    @Test
    public void testFindByid() {
        
        Users user = new Users();
        user.setUserName("backend1");
        user.setPassword("tstpwd");
        user.setEmail("ske@example.com");
        Users savedUser = userRepository.save(user);

        Optional<Users> optionalUser = userRepository.findById((long) savedUser.getUserId());
         assertTrue(optionalUser.isPresent());
        Users foundUser = optionalUser.get();
        assertEquals(savedUser.getUserId(), foundUser.getUserId());
        assertEquals("backend1", foundUser.getUserName());
        assertNotEquals("sk@example.com", foundUser.getEmail());
    }
    
    @Test
    public void findNonExistentUserByIdTest() {
        // Find a user with a non-existent ID
        Optional<Users> foundUser = userRepository.findById(-1L);
        
        assertFalse(foundUser.isPresent());
    }
    @Test
    public void saveNullUser() {
        try {
            userRepository.save(null);
        } catch (Exception e) {
            // Expected Exception occurred, test passed
            return;
        }
        fail("Expected IllegalArgumentException was not thrown");
    }

}
