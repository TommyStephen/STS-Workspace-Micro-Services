package study.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import study.model.Employee;

@RestController
public class EmployeeController {

	@GetMapping("/employee")
	public Employee exposeEmployee() {

		Employee emp = new Employee();
		emp.setName("Hari Kumar");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(30000);

		return emp;
	}
}
