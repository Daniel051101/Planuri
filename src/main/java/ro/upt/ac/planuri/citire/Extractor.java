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
		int i=0, j=0, coloana=0;
		try
		{
			FileInputStream file = new FileInputStream("./data/licenta/2023-2026_AC_PI_Info_InfoZi.xlsx ");
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
				coloana=0;
				while (cellIterator.hasNext()) 
				{
					j++;
					Cell cell = cellIterator.next();
					
					//Universitate si facultate
					if ((i==2 || i==3) && j==1)
						System.out.print(cell.getStringCellValue() + " ");
					
					//Detali plan invatamant
					if ((i>=5 && i<=8) && j==7)
						System.out.print(cell.getStringCellValue() + " ");
					
					if (i==11 && (j>=1 && j<=7))
						switch (cell.getCellType()) 
						{
							case NUMERIC:
								System.out.print((int)cell.getNumericCellValue() + " ");
								break;
							case STRING:
								System.out.print(cell.getStringCellValue() + " ");
								break;
							default:
								System.out.print("-");
						}
					
					
			
					//Nume disciplina
					if ((i>=18 && i<=43 && i%3==0) && j==coloana*12+2)
						System.out.print(cell.getStringCellValue() + " ");
						
					//Datele disciplinei
					if ((i>=18 && i<=43 && i%3==2) && (j!=coloana*12+3 && j!=coloana*12+4 && j!=coloana*12+11 && (j>=coloana*12+2 && j<=coloana*12+13)))
						switch (cell.getCellType()) 
						{
							case NUMERIC:
								System.out.print((int)cell.getNumericCellValue() + " ");
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
								       		System.out.print((int)cell.getNumericCellValue()+" ");
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
				
				if (i==45 && coloana!=3)
					{
						i=0;
						coloana++;
					}
				
				if (i==50)
						break;
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






//if(i>=19 && (j==2 || j==14 || j==26 || j==38))
//{					
//	switch (cell.getCellType()) 
//	{
//		case NUMERIC:
//			System.out.print(cell.getNumericCellValue() + " ");
//			break;
//		case STRING:
//			System.out.print(cell.getStringCellValue() + " ");
//			break;
//		case FORMULA:
//			try 
//			{
//				switch (evaluator.evaluateFormulaCell(cell))
//				{
//			        case BOOLEAN:
//			            System.out.print(cell.getBooleanCellValue()+" ");
//			            break;
//			        case NUMERIC:
//			            System.out.print(cell.getNumericCellValue()+" ");
//			            break;
//			        case STRING:
//			            System.out.print(cell.getStringCellValue()+" ");
//			            break;
//				}
//			}
//			catch(Exception e)
//			{
//			}
//			break;
//		default:
//			System.out.print("-");
//	}
//}
