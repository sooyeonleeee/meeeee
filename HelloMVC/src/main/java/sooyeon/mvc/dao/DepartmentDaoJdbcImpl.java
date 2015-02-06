package sooyeon.mvc.dao;

import java.io.OutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import sooyeon.mvc.entity.Department;
import sooyeon.mvc.entity.Employee;
import sooyeon.mvc.exception.ServiceFailException;

@Repository
public class DepartmentDaoJdbcImpl implements DepartmentDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate npjdbcTemplate;
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DepartmentDaoJdbcImpl.class);
	}
	
	@Override
	public Integer getDepartmentCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from departments";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class);
		logger.trace("getDepartmentCount result: "+result);
		return result;
	}

	@Override
	public Map<String, Object> getDepartmentByIdNoMapping(int departmentId) {
		// TODO Auto-generated method stub
		String sql = "select * from departments where department_id=?";
		Map<String, Object> result = jdbcTemplate.queryForMap(sql, departmentId);
		logger.trace("getDepartmentByIdNoMapping result: "+result);
		return result;
	}

	@Override
	public Department getDepartmentById(int departmentId) {
		// TODO Auto-generated method stub
		String sql = "select * from departments where department_id=?";
		Department result = jdbcTemplate.queryForObject(sql, new DepartmentRowMapper(), departmentId);
		return result;
	}
	
	class DepartmentRowMapper implements RowMapper<Department> {

		@Override
		public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			Department dept = new Department();
			dept.setDepartmentId(rs.getInt("department_id"));
			dept.setDepartmentName(rs.getString("department_name"));
			dept.setManagerId(rs.getInt("manager_id"));
			dept.setLocationId(rs.getInt("location_id"));
			return dept;
		}
	}

	@Override
	public Integer getDepartmentCountByLocationId(int locationId) {
		// TODO Auto-generated method stub
		String sql = "select count(*) from departments where location_id=?";
		Integer result = jdbcTemplate.queryForObject(sql, Integer.class, locationId);
		logger.trace("getDepartmentCountByLocationId result: "+result);
		return result;
	}

	@Override
	public List<Map<String, Object>> getDepartmentsByLocationId(int locationId) {
		// TODO Auto-generated method stub
		String sql = "select * from departments where location_id=?";
		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, locationId);
		logger.warn(sql+" : "+result);
		return result;
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		/*String sql = "select * from departments";
		List<Department> result = jdbcTemplate.query(sql, new DepartmentRowMapper());*/
		//nvl함수 내에서 값이 null일 때 0으로 표시해줌
		String sql = "select department_id, department_name, nvl(manager_id, 0) as manager_id,"+ "nvl(location_id, 0) as location_id from departments";
		List<Department> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Department>(Department.class));
		return result;
	}

	@Override
	public List<Department> getDepartmentsByManagerId(int managerId) {
		String sql = "select * from departments where manager_id=?";
		List<Department> result = jdbcTemplate.query(sql, new DepartmentRowMapper(), managerId);
		return result;
	}

	@Override
	public void saveDepartments(OutputStream out) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department getDepartmentByIdWithEmployees(int departmentId) {
		String sql = "select * from departments join employees using(department_id)"+
						"where department_id=?";
		Department dept = jdbcTemplate.query(sql, new ResultSetExtractor<Department>() {

			@Override
			public Department extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				Department dept = null;
				DepartmentRowMapper mapper = new DepartmentRowMapper();
				if (rs.next()) {
					dept = mapper.mapRow(rs, 1); //department mapping
					// employees의 목록은 mapper에 없음
					ArrayList<Employee> list = new ArrayList<Employee>();
					do {
						Employee emp = new Employee();
						emp.setFirstName(rs.getString("first_name"));
						emp.setLastName(rs.getString("last_name"));
						emp.setEmployeeId(rs.getInt("employee_id"));
						emp.setCommissionPct(rs.getDouble("commission_pct"));
						emp.setManagerId(rs.getInt("employee_id"));
						emp.setDepartmentId(rs.getInt("department_id"));
						list.add(emp);
					} while (rs.next()); // 다음 employee 정보 조회를 위해서
					dept.setEmployees(list);
				}
				return dept;
			}
			
		}, departmentId);
		//logger.trace("조회 결과 : "+dept.getEmployees());
		//위의 logger로 dept에 소속된 employees를 출력하는 대신 
		//department toString()에 추가해줌.
		return dept;
	}

	@Override
	public int insertDepartment(Department dept) {
		int result = 0;
/*		String sql = "insert into departments values(?,?,?,?)";
		result = jdbcTemplate.update(sql, dept.getDepartmentId(), dept.getDepartmentName(),
				dept.getManagerId(), dept.getLocationId());*/
		String sql = "insert into departments values(:ID, :NAME, :MID, :LOC)";
		MapSqlParameterSource mapSource = new MapSqlParameterSource();
		mapSource.addValue("ID", dept.getDepartmentId())
		.addValue("NAME", dept.getDepartmentName())
		.addValue("MID", dept.getManagerId())
		.addValue("LOC", dept.getLocationId());
		result = npjdbcTemplate.update(sql, mapSource);
		
		return result;
	}

	
	@Override
	public int updateDepartment(Department dept) throws ServiceFailException {
		int result = 0;
		/*String sql = "update departments set department_name=?, manager_id=?, location_id=?"+
					" where department_id=?";
		result = jdbcTemplate.update(sql, dept.getDepartmentName(), dept.getManagerId(),
				dept.getLocationId(), dept.getDepartmentId());*/
		String sql = "update departments set department_name=:departmentName,"
				+ "manager_id=:managerId, location_id=:locationId where department_id=:departmentId";
		BeanPropertySqlParameterSource beanProps = new BeanPropertySqlParameterSource(dept);
		result = npjdbcTemplate.update(sql, beanProps);
		// 언제나 발생시키는 exception
		/*if(true) {
			throw new ServiceFailException("무조건 실패해라");
		}*/
		return result;
	}

	@Override
	public int deleteDepartment(int departmentId) {
		int result = 0;
		String sql = "delete from departments where department_id=?";
		result = jdbcTemplate.update(sql, departmentId);
		return result;
	}

}
