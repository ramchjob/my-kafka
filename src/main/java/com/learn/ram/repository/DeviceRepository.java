package com.learn.ram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.ram.entity.Device;

@Repository
public interface DeviceRepository extends JpaRepository<Device, Integer>{

}
