package sooyeon.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import sooyeon.mvc.entity.Department;
import sooyeon.mvc.exception.ServiceFailException;
import sooyeon.mvc.service.DepartmentService;

@Controller
@SessionAttributes("editDept")
public class DepartmentEditController {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(DepartmentEditController.class);
	}

	@Autowired
	private DepartmentService deptService;
	
	@RequestMapping(value="/dept/edit", method=RequestMethod.GET) 
	public String redirToEntryForm(@RequestParam int departmentId, Model model) {
		Department dept = deptService.getDeptByIdService(departmentId);
		model.addAttribute("editDept", dept);
		return "dept/enter";
	}
	
	@RequestMapping(value="/dept/enter", method=RequestMethod.POST)
	public String verify(@ModelAttribute("editDept") Department dept) {
		return "redirect:/dept/review";
	}
	
	@RequestMapping(value="/dept/review", method=RequestMethod.GET)
	public String showReview() {
		return "dept/review";
	}
	
	@RequestMapping(value="/dept/review", params="_event_confirmed", method=RequestMethod.POST)
	public String update(@ModelAttribute("editDept") Department dept) {
		try {
			deptService.updateDeptService(dept);
		} catch (ServiceFailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "redirect:/dept/edited";
	}
	
	@RequestMapping(value="/dept/review", params="_event_reverse", method=RequestMethod.POST)
	public String reinput(@ModelAttribute("editDept") Department dept) {
		return "dept/enter";
	}
	
	@RequestMapping(value="/dept/edited", method=RequestMethod.GET)
	public String showEdited(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "dept/edited";
	}
	
/*	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		logger.error("DepartmentEditController");
		return "error";
	}
	
	@ExceptionHandler
	public String exceptionParameter(RuntimeException e) {
		logger.error("DepartmentEditController", e);
		return "error";
	}
	
	@ExceptionHandler({IOException.class, SQLException.class})
	public String multiExceptionHandling() {
		return "error";
	}
	*/
	
}
