package com.user.wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.wallet.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findUserByUserName(String userName);
}
