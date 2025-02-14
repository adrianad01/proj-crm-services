package com.projects.crud.service;

import com.projects.crud.domain.dto.EmployeeDTO;
import reactor.core.publisher.Mono;

public interface IEmployeeService {

    Mono<EmployeeDTO> getEmployeeById(int id);
}
