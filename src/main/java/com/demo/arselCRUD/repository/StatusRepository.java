package com.demo.arselCRUD.repository;

import com.demo.arselCRUD.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
