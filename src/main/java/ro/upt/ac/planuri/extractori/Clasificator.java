package ro.upt.ac.planuri.extractori;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

public class Clasificator extends Extractor
{
    //@SuppressWarnings({ "resource", "incomplete-switch" })
	public Extractor clasifica(String path)
	{
		try (FileInputStream file = new FileInputStream(path);
	             XSSFWorkbook workbook = new XSSFWorkbook(file))
		{
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			 Row row = sheet.getRow(24);
			 Cell cell = row.getCell(9);
			 			 
			 switch (getValue(workbook,cell))
			 {
			 case "AUTOMATICĂ ȘI INFORMATICĂ APLICATĂ":
				 return null;
			 case "CALCULATOARE (în limba engleză)":
				 return null;
			 case "CALCULATOARE":
				 return null;
			 case "TEHNOLOGIA INFORMAȚIEI":
				 return null;
			 default:
				 break; 
			 }
			 
			 row = sheet.getRow(34);
			 cell = row.getCell(9);
			 
			 switch (getValue(workbook,cell))
			 {
			 case "Invatamant la distanta":
				 return null;
			 case "IF - Invatamant cu frecventa":
				 return null;
			 case "2 ani / 120 credite":
				 return null;
			 default:
				 break; 
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
