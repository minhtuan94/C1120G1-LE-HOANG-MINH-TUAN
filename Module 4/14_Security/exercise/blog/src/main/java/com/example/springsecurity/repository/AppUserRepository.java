package com.example.springsecurity.repository;

import com.example.springsecurity.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Integer> {
    AppUser findByUserName(String userName);
}
