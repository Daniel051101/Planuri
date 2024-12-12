package ro.upt.ac.planuri.citire;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractorMaster 
{
	@SuppressWarnings({ "resource", "incomplete-switch" })
	public static void main(String[] args) 
	{
		System.out.println("Starting...");
		int i=0, j=0;
		try
		{
			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC AES masterat.xlsx ");
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);

			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
			
			Iterator<Row> rowIterator = sheet.iterator();
			
			int n = sheet.getLastRowNum();
			
			int c=0, r=0;
			
			//uni, facultate, coduri
			for(c=0; c<10; c++)
				for (r=0; r<20; r++)
				{
					Row row=sheet.getRow(r);
					
					if(row==null)
					{
						continue;
					}
					
					Cell cell=row.getCell(c);
					if(cell==null)
					{
						continue;
					}
					
					if (c==0 && (r>=5 && r<14))
					{
						continue;
					}
					
					if (r==15 && (c>=0 && c<7))
					{
						continue;
					}
					
					String value=getValue(workbook,cell);
					value=value.replaceAll("\n", " ");
					if(value.isEmpty() || value.equals("0"))
					{
						continue;
					}
					
					//System.out.print(r+" ");
					System.out.println(value);
				}
			
			Map<Integer, Integer> rAdjustments=Map.of(
					52, 63,
					94, 111,
				    142, 149,
				    180, 214,
				    227, 234,
				    247, n-1
					);
			
			for(c=1;c<14;c+=12)
			for(r=21;r<n;r++)
			{		
		        if (rAdjustments.containsKey(r)) {
		            r = rAdjustments.get(r);
		        }
				
				Row row=sheet.getRow(r);
				
				if(row==null)
				{
					continue;
				}
				
				Cell cell=row.getCell(c);
				if(cell==null)
				{
					continue;
				}
				
				String value=getValue(workbook,cell);
				value=value.replaceAll("\n", " ");
				if(value.isEmpty() || value.equals("0"))
				{
					continue;
				}
				
				//System.out.print(r+" ");
				System.out.println(value);

				if (cell.getCellType() == CellType.FORMULA)
				{
					for (int k=1; k<12; k++)
					{
						Cell cell1=row.getCell(c+k);
						if(cell1==null)
						{
							continue;
						}
				
						String value1=getValue(workbook,cell1);
						if(value1.isEmpty() || value1.equals("0"))
						{
							continue;
						}
						
						System.out.println(value1);
					}
					System.out.println("\n");
				}
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Stopping... "+i+" "+j);
	}
	
	public static String getValue(XSSFWorkbook workbook,Cell cell)
	{
		XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
		
		switch (cell.getCellType()) 
		{
			case NUMERIC:
				return (int)cell.getNumericCellValue() + " ";
			case STRING:
				return cell.getStringCellValue() + " ";
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
		
		return "";
	}
	
}
