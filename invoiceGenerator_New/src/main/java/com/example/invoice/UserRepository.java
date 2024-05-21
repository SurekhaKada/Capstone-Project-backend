package com.example.invoice;





import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

	Users findByUserName(String userName);
	
	
	
}
