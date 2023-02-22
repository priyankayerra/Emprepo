package com.employee.phone.service;

import com.employee.phone.dto.EmployeeRequestDto;
import com.employee.phone.dto.EmployeeResponseDto;
import com.employee.phone.dto.PhoneRequestDto;
import com.employee.phone.dto.PhoneResponseDto;
import com.employee.phone.model.Employee;
import com.employee.phone.model.Phone;
import com.employee.phone.repository.EmployeeRepository;
import com.employee.phone.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    public EmployeeResponseDto create(EmployeeRequestDto employeeRequestDto) {
        Employee employee = employeeRepository.save(convertEmployeeRequestDtoToEmployee(employeeRequestDto));
        if(null!=employeeRequestDto.getPhone() && employeeRequestDto.getPhone().size()>0){
            for (PhoneRequestDto p : employeeRequestDto.getPhone()) {
//                Phone pr = new Phone();
//                pr.setType(p.getType());
//                pr.setPhoneNumber(p.getPhoneNumber());
//                pr.setAreaCode(p.getAreaCode());
//                pr.setEmployee(employeeResponse);
                phoneRepository.save(convertRequestToPhones(p,employee));
            }
        }
        return convertEmployeeToEmployeeResponse(employee);

    }

    private Employee convertEmployeeRequestDtoToEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequestDto.getFirstName());
        employee.setLastName(employeeRequestDto.getLastName());
        employee.setSalary(employeeRequestDto.getSalary());
        return employee;
    }


    private EmployeeResponseDto convertEmployeeToEmployeeResponse(Employee employee) {
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        employeeResponseDto.setId(employee.getId());
        employeeResponseDto.setFirstName(employee.getFirstName());
        employeeResponseDto.setSalary(employee.getSalary());
        List<Phone> phoneList = phoneRepository.findByEmployee(employee);
        employeeResponseDto.setPhone(this.convertPhoneToPhoneResponse(phoneList));
        employeeResponseDto.setLastName(employee.getLastName());
        return employeeResponseDto;
    }


    private Phone convertRequestToPhones(PhoneRequestDto phoneRequestDto,Employee employee) {
        Phone phone = new Phone();
        phone.setType(phoneRequestDto.getType());
        phone.setAreaCode(phoneRequestDto.getAreaCode());
        phone.setPhoneNumber(phoneRequestDto.getPhoneNumber());
        phone.setEmployee(employee);
        return phone;
    }

    private List<PhoneResponseDto> convertPhoneToPhoneResponse(List<Phone> phone) {
        List<PhoneResponseDto> allPhone = new ArrayList<>();
        if (phone.size() > 0) {
            for (Phone s : phone) {
                PhoneResponseDto pd = new PhoneResponseDto();
                pd.setId(s.getId());
                pd.setType(s.getType());
                pd.setPhoneNumber(s.getPhoneNumber());
                pd.setAreaCode(s.getAreaCode());
                allPhone.add(pd);
            }

        }
        return allPhone;
    }

    }






