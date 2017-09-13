package trng.imcs.spring.hibernate;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import trng.imcs.spring.hibernate.dao.DepartmentDAO;
import trng.imcs.spring.hibernate.dao.EmployeeDAO;
import trng.imcs.spring.hibernate.daoImpl.DepartmentDAOImpl;
import trng.imcs.spring.hibernate.daoImpl.EmployeeDAOImpl;
import trng.imcs.spring.hibernate.model.Employee;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext("trng.imcs");
//		EmployeeDAO dao = context.getBean(EmployeeDAOImpl.class);
		DepartmentDAO dao = context.getBean(DepartmentDAOImpl.class);
		java.util.Date d = new java.util.Date(); 
		Date sqlDate = new Date(d.getTime());
		Employee employee = new Employee(1, "updating", "cc", "123", 25, sqlDate,
				 sqlDate, 1, 1234, 1);
		//dao.updateEmployee(employee);
		System.out.println(dao.getDepartment(1));

	}
}
