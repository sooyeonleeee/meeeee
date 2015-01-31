package jdbc.service;

import java.util.List;
import java.util.Map;

import jdbc.entity.Department;

public interface IService {
	
	public Integer getDeptCntService();
	public Map<String, Object> getDeptByIdNoMappingService(int departmentId);
	public Integer getDeptCntByLocationIdService(int locationId);
	public List<Map<String, Object>> getDeptByLocationIdService(int locationId);
	public Department getDeptByIdService(int departmentId);
	public List<Department> getAllDeptService();
	public List<Department> getDeptByManagerIdService(int managerId);
	public Department getDeptByIdWithEmpService(int departmentId);
	public int insertDeptService(Department dept);
	public int updateDeptService(Department dept);
	public int deleteDeptService(int departmentId);
}
