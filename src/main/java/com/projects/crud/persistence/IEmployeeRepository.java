package com.projects.crud.persistence;

import com.projects.crud.domain.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.concurrent.CompletableFuture;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    CompletableFuture<Employee> findFirstByIdEmpleado(int idEmpleado);
}
