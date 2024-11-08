package ro.upt.ac.planuri.citire;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// https://howtodoinjava.com/java/library/readingwriting-excel-files-in-java-poi-tutorial/

public class Extractor 
{	
	@SuppressWarnings({ "resource", "incomplete-switch" })
	public static void main(String[] args) 
	{
		System.out.println("Starting...");
		int i=0,j=0;
		try
		{
			FileInputStream file = new FileInputStream("./data/licenta/2023-2026_AC_PI_Info_InfoID.xlsx ");
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);

			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
			
			Iterator<Row> rowIterator = sheet.iterator();
			i=0;
			while (rowIterator.hasNext()) 
			{
				i++;
				
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				j=0;
				while (cellIterator.hasNext()) 
				{
					j++;
					Cell cell = cellIterator.next();
					
					if(i>=19 && (j==2 || j==14 || j==26 || j==38))
					{					
						switch (cell.getCellType()) 
						{
							case NUMERIC:
								System.out.print(cell.getNumericCellValue() + " ");
								break;
							case STRING:
								System.out.print(cell.getStringCellValue() + " ");
								break;
							case FORMULA:
								try 
								{
									switch (evaluator.evaluateFormulaCell(cell))
									{
								        case BOOLEAN:
								            System.out.print(cell.getBooleanCellValue()+" ");
								            break;
								        case NUMERIC:
								            System.out.print(cell.getNumericCellValue()+" ");
								            break;
								        case STRING:
								            System.out.print(cell.getStringCellValue()+" ");
								            break;
									}
								}
								catch(Exception e)
								{
								}
								break;
							default:
								System.out.print("-");
						}
					}
				}
				System.out.println("");
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		System.out.println("Stopping... "+i+" "+j);
	}
	

}
