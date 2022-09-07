package com.dxc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dxc.model.Employee;

@Component
public class EmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//add employee
	@Transactional
	public void addEmployee(Employee emp) {
		hibernateTemplate.save(emp);
	}
	
	//get all employee
	public List<Employee> getAllEmp(){
		return hibernateTemplate.loadAll(Employee.class);
	}
	
	//get employee by id
	public Employee getEmpById(String id) {
		return hibernateTemplate.get(Employee.class, id);
	}
	
	//update employee 
	@Transactional
	public void updateEmp(Employee emp) {
		hibernateTemplate.update(emp);
	}
	
	//delete employee
	@Transactional
	public void deleteEmp(String id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
	}
	
}
