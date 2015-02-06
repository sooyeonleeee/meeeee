package simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTest {

	private void setModel(Model model) {
		model.addAttribute("name", "sooyeon");
		model.addAttribute("age", "25");
	}
	
	@RequestMapping("/show")
	public String showJspData(Model model) {
		setModel(model);
		return "show";
	}
	
	@RequestMapping("/byXml")
	public String showXmlData(Model model) {
		setModel(model);
		return "xmlView";
	}
	
	@RequestMapping("/byPdf")
	public String showPdfData(Model model) {
		setModel(model);
		return "pdfView";
	}
	
	@RequestMapping("/byExcel")
	public String showExcelData(Model model) {
		setModel(model);
		return "excelView";
	}
}
