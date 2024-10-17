package com.example.demo.repository;

import com.example.demo.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for interacting with the Device entity in the database.
 */
@Repository
public interface DeviceRepository extends JpaRepository<Device, Long> {
    // No additional methods needed, JpaRepository provides all necessary CRUD operations
}
