package jdbc.dao;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import jdbc.entity.Department;

public interface DepartmentDao {
	Integer getDepartmentCount();
	Map<String, Object> getDepartmentByIdNoMapping(int departmentId);
	Department getDepartmentById(int departmentId);
	Integer getDepartmentCountByLocationId(int locationId) ;
	
	List<Map<String, Object>> getDepartmentsByLocationId(int locationId);
	List<Department> getAllDepartments();
	List<Department> getDepartmentsByManagerId(int managerId);
	void saveDepartments(OutputStream out);
	Department getDepartmentByIdWithEmployees(int departmentId);
	
	int insertDepartment(Department dept);
	int updateDepartment(Department dept);
	int deleteDepartment(int departmentId);
}
