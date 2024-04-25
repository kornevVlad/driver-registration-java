package com.example.driversregistrationjava.model.admin.repository;

import com.example.driversregistrationjava.model.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
