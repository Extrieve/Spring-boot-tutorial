package com.extrieve.Springboot.tutorial.controller;

import com.extrieve.Springboot.tutorial.entity.Department;
import com.extrieve.Springboot.tutorial.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        return departmentService.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id) {
        return departmentService.fetchDepartmentById(id);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentbyId(@PathVariable("id") Long id) {
        departmentService.deleteDepartmentbyId(id);
        return "Deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,@RequestBody Department department) {
        return departmentService.updateDepartment(id ,department);
    }

}
