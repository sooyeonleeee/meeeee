package simple.view;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class MyExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HSSFSheet sheet = workbook.createSheet();
		HSSFRow row = null;
		Iterator<String> iterator = model.keySet().iterator();
		for(int i=0; iterator.hasNext(); i++) {
			String key = iterator.next();
			row = sheet.createRow(i);
			setRow(key, model.get(key), row);
		}
	}
	private void setRow(String key, Object value, HSSFRow row) {
		short index=0;
		HSSFCell keyCell = row.createCell(0);
		keyCell.setCellValue(key);
		HSSFCell valueCell = row.createCell(1);
		valueCell.setCellValue(value.toString());
	}
}
