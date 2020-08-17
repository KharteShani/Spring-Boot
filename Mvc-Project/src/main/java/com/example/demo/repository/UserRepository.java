package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {

//	List<User> findByFname(String fname);
//	List<User> findByIdGreaterThan(int id);
//	
//	@Query("from User where fname=?1 and lname=?2 order by fname")
//	List<User> findByFnameSorted(String fname,String lname);
//	@Query("from User where lname=?1 order by lname ")
//	List<User> findByLnameSorted(String lname);


}
