package simple.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.AbstractView;

public class MyXmlView extends AbstractView {

	private final Logger logger = LoggerFactory.getLogger(MyXmlView.class);

	@Override
	protected void renderMergedOutputModel(Map map, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// XML  페이지 구성
		String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n";
		StringBuffer sb = new StringBuffer();
		sb.append(xmlHeader);
		sb.append("<person>");
		sb.append("<name>"+map.get("name")+"</name>");
		sb.append("<age>"+map.get("age")+"</age>");
		sb.append("</person>");
		
		response.setContentType("application/xml");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setContentLength(sb.toString().getBytes("utf-8").length);
		response.getWriter().print(sb.toString());
	}
}