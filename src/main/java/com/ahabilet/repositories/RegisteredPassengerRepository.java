package com.ahabilet.repositories;

import com.ahabilet.models.RegisteredPassenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisteredPassengerRepository extends JpaRepository<RegisteredPassenger, Long> {
    List<RegisteredPassenger> findAllById(Long registeredPassengerId);
    // List<RegisteredPassenger> findAllByUserId(Long userId);
}
