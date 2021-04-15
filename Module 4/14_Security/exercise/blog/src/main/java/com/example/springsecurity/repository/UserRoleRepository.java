package com.example.springsecurity.repository;

import com.example.springsecurity.entity.AppUser;
import com.example.springsecurity.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,Integer> {
    List<UserRole> findByAppUser(AppUser appUser);
}
