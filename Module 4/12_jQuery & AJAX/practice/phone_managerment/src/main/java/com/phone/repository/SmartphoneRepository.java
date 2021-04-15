package com.phone.repository;

import com.phone.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface SmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
