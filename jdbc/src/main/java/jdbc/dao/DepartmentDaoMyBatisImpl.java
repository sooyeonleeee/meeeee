package jdbc.dao;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc.entity.Department;
import jdbc.entity.Employee;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//@Repository
public class DepartmentDaoMyBatisImpl implements DepartmentDao {

	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DepartmentDaoMyBatisImpl.class);
	}

	private final String namespace = "mybatis.mappers.deptMapper.";

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Integer getDepartmentCount() {
		String stmt = namespace + "getDepartmentCount";
		int result = sqlSession.selectOne(stmt);
		return result;
	}

	@Override
	public Map<String, Object> getDepartmentByIdNoMapping(int departmentId) {
		String stmt = namespace + "getDepartmentByIdNoMapping";
		Map<String, Object> result = sqlSession.selectOne(stmt, departmentId);
		return result;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		String stmt = namespace + "getDepartmentById";
		Department result = sqlSession.selectOne(stmt, departmentId);
		return result;
	}

	@Override
	public Integer getDepartmentCountByLocationId(int locationId) {
		String stmt = namespace+"getDepartmentCountByLocationId";
		int result = sqlSession.selectOne(stmt, locationId);
		return result;
	}

	@Override
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId) {
		String stmt = namespace + "getDepartmentsByLocationId";
		List<Map<String, Object>> result = sqlSession.selectList(stmt, locationId);
		return result;
	}

	@Override
	public List<Department> getAllDepartments() {
		String stmt = namespace+"getAllDepartments";
		List<Department> result = sqlSession.selectList(stmt);
		return result;
	}

	@Override
	public List<Department> getDepartmentsByManagerId(int managerId) {
		String stmt = namespace+"getDepartmentsByManagerId";
		List<Department> result = sqlSession.selectList(stmt, managerId);
		return result;
	}

	@Override
	public void saveDepartments(OutputStream out) {
		// TODO Auto-generated method stub

	}

	@Override
	public Department getDepartmentByIdWithEmployees(int departmentId) {
		String stmt = namespace+"getDepartmentByIdWithEmployees";
		Department result = sqlSession.selectOne(stmt, departmentId);
		String stmt2 = namespace+"getEmployeesByDeptId";
		ArrayList<Employee> emp = (ArrayList) sqlSession.selectList(stmt2, departmentId);
		result.setEmployees(emp);
		return result;
	}

	@Override
	public int insertDepartment(Department dept) {
		int result = 0;
		String stmt = namespace+"insertDepartment";
		result = sqlSession.insert(stmt, dept);
		return result;
	}

	@Override
	public int updateDepartment(Department dept) {
		// TODO Auto-generated method stub
		int result = 0;
		String stmt = namespace+"updateDepartment";
		result = sqlSession.update(stmt, dept);
		return result;
	}

	@Override
	public int deleteDepartment(int departmentId) {
		int result = 0;
		String stmt = namespace+"deleteDepartment";
		result = sqlSession.delete(stmt, departmentId);
		return result;
	}

}
