package simple.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamTest {
	
	@RequestMapping("/onlyUrl")
	public String onlyUrl(Model model) {
		model.addAttribute("message", "urlOnly");
		return "showMessage";
	}
	
	@RequestMapping(value="/onlyPost", method=RequestMethod.POST)
	public String onlyPost(Model model) {
		model.addAttribute("message", "onlyPost");
		return "showMessage";
	}
	
	@RequestMapping(value="/needParam", params={"name", "age"})
	public String needParam(Model model) {
		model.addAttribute("message", "needParam");
		return "showMessage";
	}
	
	@RequestMapping(value="/checkValue", params={"name=andy", "age"})
	public String checkValue(Model model) {
		model.addAttribute("message", "param=andy일때");
		return "showMessage";
	}
	
	@RequestMapping("/args")
	public String argTest(Model model, HttpServletRequest req, HttpSession session) {
		//session.setAttribute("name", req.getParameter("name"));
		session.setAttribute("name", req.getAuthType());
		model.addAttribute("message", req.getServletPath());
		return "showMessage";
	}
}
