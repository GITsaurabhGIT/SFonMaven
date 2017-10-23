package TestScenario;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WrittingValuesInExcel {
	

	
	public void writeDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname,String value)
	{
	    try
	    {
	        FileInputStream input=new FileInputStream(filepath);
	        Workbook wb=new HSSFWorkbook(input);
	        Sheet sh=wb.getSheet(Sheetname);
	        Row row=sh.getRow(rowcount);
	        FileOutputStream webdata=new FileOutputStream(filepath);
	        row.createCell(columncount).setCellValue(value);
	        wb.write(webdata);
	    }
	    catch(Exception e)
	    {

	    }
	}
	
}
