package trng.imcs.spring.hibernate.dao;

import java.util.List;

import trng.imcs.spring.hibernate.model.Employee;


public interface EmployeeDAO {

	public int addEmployee(Employee e);

	public void updateEmployee(Employee e);

	public void deleteEmployee(int empId);

	public Employee getEmployee(int empId);

	public List<Employee> getAllEmployeesByDeptId(int deptId);
	
	

}
