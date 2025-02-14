package com.projects.crud.service;

import com.projects.crud.domain.dto.EmployeeDTO;
import com.projects.crud.mapper.IEmployeeMapper;
import com.projects.crud.persistence.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService{
    private final IEmployeeRepository employeeRepository;
    private final IEmployeeMapper employeeMapper;

    @Override
    public Mono<EmployeeDTO> getEmployeeById(int id) {
        return Mono.fromFuture(() -> employeeRepository.findFirstByIdEmpleado(id))
                .map(employeeMapper::toEmployeeDTO)
                .switchIfEmpty(Mono.error(new Throwable("Employee not found")));
    }

    
}
