package com.mastermoin.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mastermoin.demo.model.User;

public interface UserRepository extends JpaRepository <User,  Integer>{

}
