package com.extrieve.Springboot.tutorial.service;

import com.extrieve.Springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
