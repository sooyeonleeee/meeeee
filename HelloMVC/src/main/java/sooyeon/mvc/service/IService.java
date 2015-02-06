package sooyeon.mvc.service;

import java.util.List;
import java.util.Map;

import sooyeon.mvc.entity.Department;
import sooyeon.mvc.exception.ServiceFailException;

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

	public int updateDeptService(Department dept) throws ServiceFailException;

	public int deleteDeptService(int departmentId);
}
