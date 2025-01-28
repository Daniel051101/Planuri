package ro.upt.ac.planuri.extractori;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

abstract public class Extractor 
{
	public abstract void extract();
	public abstract void extract(String path);
	
	public void extract(List<String> paths)
	{
        paths.forEach(filePath -> 
        {
            extract(filePath);
        });		
	}
	
	@SuppressWarnings("incomplete-switch")
	public String getValue(XSSFWorkbook workbook,Cell cell)
	{
		XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
		
		switch (cell.getCellType()) 
		{
			case NUMERIC:
				return (int)cell.getNumericCellValue() + "";
			case STRING:
				return cell.getStringCellValue() + "";
			case FORMULA:
				try 
				{
					switch (evaluator.evaluateFormulaCell(cell))
					{
			        	case BOOLEAN:
				       		return ""+cell.getBooleanCellValue();
				       	case NUMERIC:
				       		return ""+(int)cell.getNumericCellValue();
				       	case STRING:
			        		return cell.getStringCellValue();
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			break;
		}		
		return "0";
	}	
}
