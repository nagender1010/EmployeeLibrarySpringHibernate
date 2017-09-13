package trng.imcs.spring.hibernate.daoImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import trng.imcs.spring.hibernate.dao.EmployeeDAO;
import trng.imcs.spring.hibernate.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	final static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Autowired
	SessionFactory sf;

	public int addEmployee(Employee e) {
		int id = 0;
		logger.debug("Executing StudentDao::addStudent API" + e.getId());
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			id = (Integer) session.save(e);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
		logger.debug("Completed executing StudentDao::addStudent API");
		return id;

	}

	public void updateEmployee(Employee e) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(e);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteEmployee(int empId) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Employee emp = (Employee) session.load(Employee.class, empId);
			session.delete(emp);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}

	}

	public Employee getEmployee(int empId) {
		Employee emp = null;
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			emp = (Employee) session.get(Employee.class, empId);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
		return emp;

	}

	public List<Employee> getAllEmployeesByDeptId(int deptId) {
		List<Employee> empList = null;
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Employee.class);
			criteria.add(Restrictions.eq("deptId", deptId));
			empList = criteria.list();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
		return empList;
	}

}
