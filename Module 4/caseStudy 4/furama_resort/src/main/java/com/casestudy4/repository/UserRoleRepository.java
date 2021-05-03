package com.casestudy4.repository;

import com.casestudy4.entity.User;
import com.casestudy4.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByUser(User user);
}