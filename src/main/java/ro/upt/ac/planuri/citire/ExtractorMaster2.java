package ro.upt.ac.planuri.citire;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
//import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExtractorMaster2 
{
//	@SuppressWarnings({ "resource", "incomplete-switch" })
	public static void main(String[] args) 
	{
		System.out.println("Starting...");
		int i=0, j=0;
		try
		{
//			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC AES masterat.xlsx ");
			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC GD masterat.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC ISA masterat.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC SIAPS masterat.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC SIIS masterat.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025 AC SICS masterat.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025_AC_PI_Info_TI.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025_AC_PI_Master_CI.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025_AC_PI_Master_IT.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025_AC_PI_Master_ML.xlsx ");
//			FileInputStream file = new FileInputStream("./data/master/2023-2025_AC_PI_Master_SE.xlsx ");	
			
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);

//			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
			
//			Iterator<Row> rowIterator = sheet.iterator();
			
			Connection connection = DatabaseConnection.getConnection(); // Obținem conexiunea la DB
            String insertSQL = "INSERT INTO plan_invatamant_master (an_calendaristic, ciclu, cod_domeniu_fundamental, cod_ramura_de_stiinta, codul_programului_de_studii, domeniu_de_licenta, domeniu_fundamental, facultate, ramura_de_stiinta, universitate, cod_domeniu_studii_master, domeniu_studii_master, durata_studiilor, format_invatamant, program_master) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Query-ul pentru inserare
            PreparedStatement statement = connection.prepareStatement(insertSQL);
			
			int n = sheet.getLastRowNum();
			
			int c=0, r=0, index=0;
            
			Map<Integer, Integer> rAdjustments=Map.of(
					51, 64,
					93, 112,
				    141, 150,
				    179, 215,
				    226, 235,
				    246, n-1
					);
            
			for(c=1;c<14;c+=12)
			for(r=22;r<n;r++)
			{		
		        if (rAdjustments.containsKey(r)) 
		            r = rAdjustments.get(r);
				
				Row row=sheet.getRow(r);
				
				if(row==null)
					continue;
				
				Cell cell=row.getCell(c);
				
				if(cell==null)
					continue;
				
				String value=getValue(workbook,cell);
				value=value.replaceAll("\n", " ");
				
				if(value.isEmpty() || value.equals("0"))
					continue;
				
				System.out.println(value);

//				if (cell.getCellType() == CellType.FORMULA)
//				{
//					for (int k=3; k<12; k++)
//					{
//						Cell cell1=row.getCell(c+k);
//						if(cell1==null)
//							continue;
//				
//						String value1=getValue(workbook,cell1);
//						if(value1.isEmpty() || value1.equals("0"))
//							continue;
//						
//						System.out.println(value1);
//					}
//					System.out.println("\n");
//				}
				
				System.out.println("\n");     
				}

		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println("Stopping... "+i+" "+j);
	}
	
	@SuppressWarnings("incomplete-switch")
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
