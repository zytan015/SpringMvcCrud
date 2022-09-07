package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dxc.dao.EmployeeDao;
import com.dxc.model.Employee;

@Component
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao employeeDao;
	
	//add employee
	public void addEmp(Employee emp) {
		employeeDao.addEmployee(emp);
	}
	
	//get all emp
	public List<Employee> getAllEmp(){
		return employeeDao.getAllEmp();
	}
	
	//get emp by id
	public Employee getById(String id) {
		return employeeDao.getEmpById(id);
	}
	
	//update emp
	public void updateEmp(Employee emp) {
		employeeDao.updateEmp(emp);
	}
	
	//delete emp
	public void deleteEmp(String id) {
		employeeDao.deleteEmp(id);
	}
}
