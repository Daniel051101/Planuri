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
			 
			 ExtractorLicenta el = new ExtractorLicenta();
			 ExtractorLicentaCalcEn elce = new ExtractorLicentaCalcEn();
			 			 
			 switch (getValue(workbook,cell))
			 {
			 case "AUTOMATICĂ ȘI INFORMATICĂ APLICATĂ":
				 return el;
			 case "CALCULATOARE (în limba engleză)":
				 return elce;
			 case "CALCULATOARE":
				 return el;
			 case "TEHNOLOGIA INFORMAȚIEI":
				 return el;
			 default:
				 break; 
			 }
			 
			 row = sheet.getRow(34);
			 cell = row.getCell(9);
			 
			 ExtractorLicentaInfoID elii = new ExtractorLicentaInfoID();
			 ExtractorLicentaInfoZi eliz = new ExtractorLicentaInfoZi();
			 ExtractorMaster em = new ExtractorMaster();
			 
			 switch (getValue(workbook,cell))
			 {
			 case "Invatamant la distanta":
				 return elii;
			 case "IF - Invatamant cu frecventa":
				 return eliz;
			 case "2 ani / 120 credite":
				 return em;
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
