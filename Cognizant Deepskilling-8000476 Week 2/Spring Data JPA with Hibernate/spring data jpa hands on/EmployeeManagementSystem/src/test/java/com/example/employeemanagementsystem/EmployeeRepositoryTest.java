package com.example.employeemanagementsystem;

import com.example.employeemanagementsystem.entity.Department;
import com.example.employeemanagementsystem.entity.Employee;
import com.example.employeemanagementsystem.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void shouldFindEmployeesByNameContaining() {
        Department department = new Department();
        department.setName("Engineering");

        Employee employee = new Employee();
        employee.setName("Alice");
        employee.setEmail("alice@example.com");
        employee.setDepartment(department);

        employeeRepository.save(employee);

        assertFalse(employeeRepository.findByNameContaining("Ali").isEmpty());
        assertEquals(1, employeeRepository.findByEmail("alice@example.com").size());
    }
}
