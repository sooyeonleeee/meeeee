package sooyeon.mvc.controller;

import java.io.File;
import java.io.IOException;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/upload", method=RequestMethod.GET) 
	public String showUploadForm() {
		return "upload/upload";
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.POST) 
	public String uploadDone(@RequestParam("uploadFile") MultipartFile file, Model model) throws IOException {
		File newFile = new File("c:\\db\\uploaded\\"+file.getOriginalFilename());
		file.transferTo(newFile);
		model.addAttribute("file", file.getOriginalFilename());
		return "upload/done";
	}
}
