package com.extrieve.Springboot.tutorial.controller;

import com.extrieve.Springboot.tutorial.entity.Department;
import com.extrieve.Springboot.tutorial.error.DepartmentNotFoundException;
import com.extrieve.Springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Saving department: {}", department);
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Fetching department list");
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        LOGGER.info("Fetching department by id: {}", id);
        return departmentService.fetchDepartmentById(id);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {
        LOGGER.info("Fetching department by name: {}", name);
        return departmentService.fetchDepartmentByName(name);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentbyId(@PathVariable("id") Long id) {
        LOGGER.info("Deleting department by id: {}", id);
        departmentService.deleteDepartmentbyId(id);
        return "Deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,@RequestBody Department department) {
        LOGGER.info("Updating department by id: {}", id);
        return departmentService.updateDepartment(id ,department);
    }

}
