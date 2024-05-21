package com.example.invoice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



public class UserTest {
    @Test
    public void testIdGetterSetter() {
        
        int id = 7;
        Users user = new Users();

        user.setUserId(id);
        int retrievedId = user.getUserId();

       
        assertEquals(id, retrievedId);
    }
    @Test
    public void testUsernameGetterSetter() {
        
        String username = "testUser";
        Users user = new Users();
        user.setUserName(username);
        String retrievedUsername = user.getUserName();
        assertEquals(username, retrievedUsername);
    }

    
}

