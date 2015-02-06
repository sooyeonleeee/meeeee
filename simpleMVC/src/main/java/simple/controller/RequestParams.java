package simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParams {
	@RequestMapping("/add")
	public String add(@RequestParam int a, @RequestParam("b") int b, Model model) {
		String key = "message";
		String message = a+"와 "+b+"의 합은 "+(a+b)+"입니다.";
		model.addAttribute(key, message);
		return "showMessage";
	}
	
	@RequestMapping("/whoareu")
	public String minus(@RequestParam(value="id", defaultValue="sooyeon", required=false) String id, Model model) {
		model.addAttribute("message", "입력한 ID: "+id);
		return "showMessage";
	}
	
	@RequestMapping("/info/{id}")
	public String showDepartmentInfo(@PathVariable("id") int departmentId, Model model) {
		model.addAttribute("message", "입력받은 "+departmentId);
		return "showMessage";
	}
}
