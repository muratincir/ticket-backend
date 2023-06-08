package com.ahabilet.repositories;

import com.ahabilet.models.Passsenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passsenger, Long> {
}
