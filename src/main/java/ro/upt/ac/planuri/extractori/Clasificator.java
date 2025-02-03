package ro.upt.ac.planuri.extractori;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

@Component
public class Clasificator
{
    private final Map<String, Extractor> extractors = new HashMap<>();

    public Clasificator(ExtractorLicenta extractorLicenta, ExtractorLicentaCalcEn extractorLicentaCalcEn, ExtractorLicentaInfoID extractorLicentaInfoID, ExtractorLicentaInfoZi extractorLicentaInfoZi, ExtractorMaster extractorMaster) 
    {
        extractors.put("AUTOMATICĂ ȘI INFORMATICĂ APLICATĂ", extractorLicenta);
        extractors.put("CALCULATOARE (în limba engleză)", extractorLicentaCalcEn);
        extractors.put("CALCULATOARE", extractorLicenta);
        extractors.put("TEHNOLOGIA INFORMAȚIEI", extractorLicenta);
        extractors.put("Invatamant la distanta", extractorLicentaInfoID);
        extractors.put("IF - Invatamant cu frecventa", extractorLicentaInfoZi);
        extractors.put("2 ani / 120 credite", extractorMaster);
    }
	
	public Extractor clasifica(String path)
	{
		
		System.out.println(path);
		
		try (FileInputStream file = new FileInputStream(path);
	             XSSFWorkbook workbook = new XSSFWorkbook(file))
		{
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);
            Sheet sheet = workbook.getSheetAt(0);
			
            Row row = sheet.getRow(24);
            Cell cell = row.getCell(9);
            String planName = cell.getStringCellValue();

            Extractor extractor = extractors.get(planName);
            
            if (extractor != null) 
            {
            	extractor.extract(path);
            }

            row = sheet.getRow(34);
            cell = row.getCell(9);
            planName = cell.getStringCellValue();
            extractor = extractors.get(planName);

            if (extractor != null) 
            {
            	extractor.extract(path);
            } 
            else 
            {
                System.out.println("Extractor necunoscut pentru fișierul: " + path);
            }
            
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
}
