package com.projects.crud.configuration;

import com.projects.crud.handler.EmployeeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static com.projects.crud.domain.constant.UriConstant.EMPLOYEES_URI;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
@Tag(name = "Employee API", description = "Endpoints for managing employees")
public class EmployeeRouter {

    @Bean(name = "employeeRouterBean")
    @RouterOperations({
            @RouterOperation(
                    path = EMPLOYEES_URI,
                    beanClass = EmployeeHandler.class,
                    beanMethod = "getEmployeeById",
                    operation = @Operation(
                            summary = "Get an Employee by ID",
                            description = "Retrieves an employee using the provided ID as a query parameter.",
                            parameters = {
                                    @Parameter(
                                            name = "id",
                                            in = ParameterIn.QUERY,
                                            description = "The ID of the employee",
                                            required = true,
                                            example = "123"
                                    )
                            }
                    )
            )
    })

    public RouterFunction<ServerResponse> employeeRouter(EmployeeHandler employeeHandler) {
        return RouterFunctions.route(GET(EMPLOYEES_URI), employeeHandler::getEmployeeById);
    }
}

