package ro.upt.ac.planuri.extractori;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaError;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ro.upt.ac.planuri.plan.PlanInvatamant;

abstract public class Extractor 
{
	public abstract void extract();
	public abstract void extract(String path);
	public abstract void save();
	
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
		
		switch(cell.getCellType()) 
		{
	       	case NUMERIC:
	       		return ""+(int)cell.getNumericCellValue();
	       	case STRING:
	    		return cell.getStringCellValue();
	    	case BOOLEAN:
	       		return ""+cell.getBooleanCellValue();
			case FORMULA:
				try 
				{
	                CellValue cellValue = evaluator.evaluate(cell);
	                if (cellValue.getCellType() == CellType.ERROR) 
	                {
	                    FormulaError error = FormulaError.forInt(cellValue.getErrorValue());
	                    if (error == FormulaError.NA) 
	                    {
	                        return "Valoare indisponibilă";
	                    }
	                    return "FORMULA_ERROR: " + error.getString();
	                }
					switch (evaluator.evaluateFormulaCell(cell))
					{
				       	case NUMERIC:
				       		return ""+(int)cell.getNumericCellValue();
				       	case STRING:
			        		return cell.getStringCellValue();
			        	case BOOLEAN:
				       		return ""+cell.getBooleanCellValue();
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
