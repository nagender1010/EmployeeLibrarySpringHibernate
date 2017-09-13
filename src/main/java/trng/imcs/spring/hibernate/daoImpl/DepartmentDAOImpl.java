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

import trng.imcs.spring.hibernate.dao.DepartmentDAO;
import trng.imcs.spring.hibernate.model.Department;
import trng.imcs.spring.hibernate.model.Employee;

@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
	final static Logger logger = Logger.getLogger(EmployeeDAOImpl.class);

	@Autowired
	SessionFactory sf;

	@Override
	public Department getDepartment(int deptId) {
		Department dept = null;
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			dept = (Department) session.get(Department.class, deptId);
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
		return dept;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> deptList = null;
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Department.class);
			deptList = criteria.list();
			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
			logger.error("failed to execute addStudent method", ex);
		} finally {
			if (session != null)
				session.close();
		}
		return deptList;
	}

}
