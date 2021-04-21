package com.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.dto.Employee;

@Repository
public interface SystemRepository extends JpaRepository<Employee, Integer> {

}