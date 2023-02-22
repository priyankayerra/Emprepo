package com.employee.phone.repository;


import com.employee.phone.model.Employee;
import com.employee.phone.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {

    List<Phone> findByEmployee(Employee employee);

}
