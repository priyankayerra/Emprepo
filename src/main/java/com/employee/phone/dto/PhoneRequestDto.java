package com.employee.phone.dto;

import com.employee.phone.model.Employee;
import lombok.Data;

@Data
public class PhoneRequestDto {


    private String type;

    private Long areaCode;

    private Long phoneNumber;


}
