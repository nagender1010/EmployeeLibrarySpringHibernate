package trng.imcs.spring.hibernate.dao;

import java.util.List;

import trng.imcs.spring.hibernate.model.Department;


public interface DepartmentDAO {

	public Department getDepartment(int empId);

	public List<Department> getAllDepartments();

}
