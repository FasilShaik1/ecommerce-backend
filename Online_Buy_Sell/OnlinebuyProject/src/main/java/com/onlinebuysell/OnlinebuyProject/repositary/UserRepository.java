package com.onlinebuysell.OnlinebuyProject.repositary;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinebuysell.OnlinebuyProject.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

	 @Query("SELECT u.contactnumber FROM User u WHERE u.contactid = :contactid")
	

	List<BigInteger> findContactNumberByContactId(Long contactid);

	}
	

