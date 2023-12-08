import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static String[][] getExcelData() throws IOException {
		
		String fileLocation ="./test-data/Book1.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet=wbook.getSheetAt(0);
		int LastRowNum=sheet.getLastRowNum();
		int LastCellNum=sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[LastRowNum][LastCellNum];
	
		for (int i = 1; i <=LastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <LastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft= new DataFormatter();
				String value=dft.formatCellValue(cell);
				//String value = cell.getStringCellValue();
				data[i-1][j]=value;
			} 
		}
		wbook.close();
		return data;
	}

}
