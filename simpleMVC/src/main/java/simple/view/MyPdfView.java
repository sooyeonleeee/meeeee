package simple.view;

import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class MyPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String userAgent = request.getHeader("User-Agent");
		String fileName = "test.pdf";

		if (userAgent.indexOf("MSIE") > -1) {
			fileName = URLEncoder.encode(fileName, "utf-8");
		} else {
			fileName = new String(fileName.getBytes("utf-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary");

		Table table = new Table(2, model.size() + 1);
		Iterator<String> keys = model.keySet().iterator();

		while (keys.hasNext()) {
			String key = keys.next();
			addCell(table, key, model);
		}

		document.add(table);
	}

	private void addCell(Table table, String key, Map<String, Object> model) {
		Cell keyCell = new Cell(key);
		table.addCell(keyCell);
		Cell valueCell = new Cell(model.get(key).toString());
		table.addCell(valueCell);
	}
}