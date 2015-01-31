package jdbc.entity;

import java.util.ArrayList;

public class Department {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	private ArrayList<Employee> employees;
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public Department() {}

	public Department(int departmentId, String departmentName, int managerId, int locationId) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Department [departmentId=").append(departmentId).append(", ");
		if (departmentName != null)
			builder.append("departmentName=").append(departmentName).append(", ");
		builder.append("managerId=").append(managerId).append(", locationId=").append(locationId).append("]");
		return builder.toString()+this.getEmployees();
	}	
	
	
}
