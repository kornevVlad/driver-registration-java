package com.example.driversregistrationjava.model.user.repository;

import com.example.driversregistrationjava.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
