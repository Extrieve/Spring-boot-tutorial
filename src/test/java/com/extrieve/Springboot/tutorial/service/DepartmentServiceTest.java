package com.extrieve.Springboot.tutorial.service;

import com.extrieve.Springboot.tutorial.entity.Department;
import com.extrieve.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("CE")
                .departmentAddress("CE-123")
                .departmentCode("123 Main St.")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("CE"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Test fetchDepartmentByName() with valid name")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() {
        String departmentName = "CE";
        Department foundDepartment = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, foundDepartment.getDepartmentName());
    }
}