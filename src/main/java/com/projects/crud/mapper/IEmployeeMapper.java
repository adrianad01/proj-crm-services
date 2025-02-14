package com.projects.crud.mapper;

import com.projects.crud.domain.dto.EmployeeDTO;
import com.projects.crud.domain.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IEmployeeMapper {

    @Mapping(source = "idEmpleado", target = "idEmployee")
    @Mapping(source = "nombreEmpleado", target = "name")
    @Mapping(source = "apellidoPaterno", target = "firstLastName")
    @Mapping(source = "apellidoMaterno", target = "secondLastName")
    EmployeeDTO toEmployeeDTO(Employee employee);
}
