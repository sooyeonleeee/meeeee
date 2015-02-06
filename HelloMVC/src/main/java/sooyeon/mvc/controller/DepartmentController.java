package sooyeon.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import sooyeon.mvc.entity.Department;
import sooyeon.mvc.service.DepartmentService;

@Controller
public class DepartmentController {
	
	@Autowired
	DepartmentService service;
	
	@RequestMapping(value="/dept/list", method=RequestMethod.GET)
	public String getAllDeptList(Model model) {
		List<Department> depts = service.getAllDeptService();
		model.addAttribute("depts", depts);
		return "dept/list";
	}
	
	@RequestMapping(value="/dept", method=RequestMethod.GET, params={"departmentId"})
	public String getDepartmentDetail(@RequestParam int departmentId, Model model) {
		Department dept = service.getDeptByIdService(departmentId);
		model.addAttribute("dept", dept);
		return "dept/detail";
	}
}
