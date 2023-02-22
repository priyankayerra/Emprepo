package com.employee.phone.repository;


import com.employee.phone.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Page<Employee> findAll(Pageable pageable);


    //Page<Employee> findAllByNameContains(String search, Pageable pageable);

}
