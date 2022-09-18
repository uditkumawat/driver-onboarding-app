package com.uditkumawat.craftproject.repository;

import com.uditkumawat.craftproject.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Driver findByEmail(String email);
}
