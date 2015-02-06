package sooyeon.mvc.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sooyeon.mvc.dao.DepartmentDao;
import sooyeon.mvc.entity.Department;
import sooyeon.mvc.exception.ServiceFailException;

@Service
@Transactional(rollbackFor=sooyeon.mvc.exception.ServiceFailException.class)
//arithmeticException은 rollback 대상이 아님
//runtimeException은 무조건 rollback 됨
public class DepartmentService implements IService {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DepartmentService.class);
	}
	
	@Autowired
	DepartmentDao dao;
	
	@Override
	public Integer getDeptCntService() {
		int result = dao.getDepartmentCount();
		return result;
	}
	
	public Map<String, Object> getDeptByIdNoMappingService(int departmentId) {
		Map<String, Object> result = dao.getDepartmentByIdNoMapping(departmentId);
		return result;
	}

	@Override
	public Integer getDeptCntByLocationIdService(int locationId) {
		int result = dao.getDepartmentCountByLocationId(locationId);
		return result;
	}

	@Override
	public List<Map<String, Object>> getDeptByLocationIdService(int locationId) {
		List<Map<String, Object>> result = dao.getDepartmentsByLocationId(locationId);
		return result;
	}

	@Override
	public Department getDeptByIdService(int departmentId) {
		// TODO Auto-generated method stub
		Department department = dao.getDepartmentById(departmentId);
		return department;
	}

	@Override
	public List<Department> getAllDeptService() {
		List<Department> result = dao.getAllDepartments();
		return result;
	}

	@Override
	public List<Department> getDeptByManagerIdService(int managerId) {
		List<Department> result = dao.getDepartmentsByManagerId(managerId);
		return result;
	}

	@Override
	public Department getDeptByIdWithEmpService(int departmentId) {
		Department result = dao.getDepartmentByIdWithEmployees(departmentId);
		return result;	
	}

	@Override
	public int insertDeptService(Department dept) {
		// TODO Auto-generated method stub
		int result = dao.insertDepartment(dept);
		return result;
	}

	@Override
	public int updateDeptService(Department dept) throws ServiceFailException {
		// TODO Auto-generated method stub
		int result = dao.updateDepartment(dept);
		return result;
	}

	@Override
	public int deleteDeptService(int departmentId) {
		// TODO Auto-generated method stub
		int result = dao.deleteDepartment(departmentId);
		return result;
	}

}
