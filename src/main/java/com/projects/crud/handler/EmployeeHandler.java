package com.projects.crud.handler;


import com.projects.crud.service.EmployeeServiceImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class EmployeeHandler {

    private final EmployeeServiceImpl employeeService;

    public EmployeeHandler(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Mono<ServerResponse> getEmployeeById(ServerRequest request) {

        Optional<String> idParam = request.queryParam("id");
        if (idParam.isEmpty()) {
            return ServerResponse.badRequest().bodyValue("Missing 'id' query parameter");
        }
        int employeeId;
        try {
            employeeId = Integer.parseInt(idParam.get());
        } catch (NumberFormatException e) {
            return ServerResponse.badRequest().bodyValue("Invalid 'id': must be an integer");
        }

        return employeeService.getEmployeeById(employeeId)
                .flatMap(employee -> ServerResponse.ok().bodyValue(employee))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}


