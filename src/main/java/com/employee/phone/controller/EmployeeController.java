package com.employee.phone.controller;

import com.employee.phone.dto.EmployeeRequestDto;
import com.employee.phone.dto.EmployeeResponseDto;
import com.employee.phone.dto.PhoneRequestDto;
import com.employee.phone.dto.PhoneResponseDto;
import com.employee.phone.model.Employee;
import com.employee.phone.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/create")
    public EmployeeResponseDto add(@RequestBody EmployeeRequestDto employeeRequestDto) {
        return employeeService.create(employeeRequestDto);
    }
    


}


