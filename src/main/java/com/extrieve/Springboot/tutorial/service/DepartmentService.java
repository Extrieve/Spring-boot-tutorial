package com.extrieve.Springboot.tutorial.service;

import com.extrieve.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long id);

    public void deleteDepartmentbyId(Long id);

    public Department updateDepartment(Long id, Department department);
}
