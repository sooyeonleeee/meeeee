package sooyeon.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	private final static Logger logger;
	static {
		logger = LoggerFactory.getLogger(AjaxController.class);
	}
	
	@RequestMapping(value="/ajax", method=RequestMethod.GET) 
	public String ajaxPageCall() {
		//logger.trace("수업: ajax call");
		return "ajax";
	}
	
	@RequestMapping(value="/ajax", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	public @ResponseBody String ajaxReceive(@RequestParam String msg) {
		logger.trace("수업: "+msg);
		//System.out.println(msg);
		return "안녕 난 ajax라고 해."+msg;
	}
	
	@RequestMapping(value="/api", method=RequestMethod.GET)
	public String apiCall() {
		//logger.trace("restervice.jsp 호출......................");
		return "restService2";
	}
	
	/*@RequestMapping(value="/search", method=RequestMethod.POST, produces="text/plain;charset=utf-8") 
	public @ResponseBody String searchMovie(@RequestParam String movie) {
		logger.trace("수업: "+movie);
		return ;
	}*/
}
