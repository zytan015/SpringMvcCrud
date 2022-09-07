package com.dxc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dxc.model.Employee;
import com.dxc.service.EmployeeService;

@Controller
@RequestMapping
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//load add employee form
	@GetMapping("addEmployee")
	public String addEmp() {
		
		return "AddEmployee";
	}
	
	//save employee form
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp) {
		employeeService.addEmp(emp);
		return "redirect:/employeeReport";
	}
	
	//load employee data
	@GetMapping("employeeReport")
	public String loadEmployee(Model m) {
		m.addAttribute("employee", employeeService.getAllEmp());
		m.addAttribute("title", "Employee Report");
		
		return "EmployeeReport";
	}
	
	//load edit form
	@GetMapping("/editEmployee/{id}")
	public String loadEditForm(@PathVariable(value="id") String id, Model m) {
		Employee emp = employeeService.getById(id);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");
		
		return "EditEmployee";
	}
	
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp) {
		employeeService.updateEmp(emp);
		
		return "redirect:/employeeReport";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable String id) {
		employeeService.deleteEmp(id);
		
		return "redirect:/employeeReport";
	}
}
