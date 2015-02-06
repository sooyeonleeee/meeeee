package simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import simple.service.DeptService;

@Controller
public class HelloController {
	
	@Autowired
	DeptService service;
	
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hellowMVC(Model model) {
		model.addAttribute("message", "hello MVC "+service.serviceMessage());
		return "showMessage";
	}
}
