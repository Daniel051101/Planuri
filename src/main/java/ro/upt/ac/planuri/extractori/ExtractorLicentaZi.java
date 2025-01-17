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

// https://howtodoinjava.com/java/library/readingwriting-excel-files-in-java-poi-tutorial/

public class ExtractorLicentaZi
{	
//	@SuppressWarnings({ "resource", "incomplete-switch" })
	public static void main(String[] args) 
	{
		System.out.println("Starting...");
		int i=0, j=0;
		try
		{
			
			FileInputStream file = new FileInputStream("./data/licenta/2023-2026_AC_PI_Info_InfoZi.xlsx ");

			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);

//			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
			
//			Iterator<Row> rowIterator = sheet.iterator();
			
			int n = sheet.getLastRowNum();
			
			Connection connection = DatabaseConnection.getConnection(); // Obținem conexiunea la DB
            String insertSQL = "INSERT INTO plan_invatamant_licenta (an_calendaristic, ciclu, cod_domeniu_fundamental, cod_ramura_de_stiinta, codul_programului_de_studii, domeniu_de_licenta, domeniu_fundamental, facultate, ramura_de_stiinta, universitate, cod_domeniu_de_licenta, cod_studii, program_de_studii_licenta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Query-ul pentru inserare
            PreparedStatement statement = connection.prepareStatement(insertSQL);
			
			int c=0, r=0, index=0;
//			String currentSemester = "";
			
			ArrayList<String> values = new ArrayList<>();
			
			//uni, facultate, coduri
			for(c=0; c<10; c++)
				for (r=0; r<13; r++)
				{
					Row row=sheet.getRow(r);
					
					if(row==null)
						continue;
					
					Cell cell=row.getCell(c);
					
					if(cell==null)
						continue;
					
					if ((c==0 && (r>4 && r<9)) || (r==10 && (c>=0 && c<7)))
						continue;
					
					String value=getValue(workbook,cell);
					value=value.replaceAll("\n", " ");
					
					if(value.isEmpty() || value.equals("0"))
						continue;
					
					values.add(value);
					
					//System.out.println(value);
				}
						
			while (index < values.size()) {
                // Setăm valorile pentru fiecare coloană
                statement.setString(10, values.get(index++)); 
                statement.setString(8, index < values.size() ? values.get(index++) : null); 
                statement.setString(3, index < values.size() ? values.get(index++) : null); 
                statement.setString(4, index < values.size() ? values.get(index++) : null);
                statement.setString(11, index < values.size() ? values.get(index++) : null); 
                statement.setString(12, index < values.size() ? values.get(index++) : null); 
                statement.setString(2, index < values.size() ? values.get(index++) : null); 
                statement.setString(5, index < values.size() ? values.get(index++) : null); 
                statement.setString(1, index < values.size() ? values.get(index++) : null); 
                statement.setString(7, index < values.size() ? values.get(index++) : null); 
                statement.setString(9, index < values.size() ? values.get(index++) : null); 
                statement.setString(6, index < values.size() ? values.get(index++) : null); 
                statement.setString(13, index < values.size() ? values.get(index++) : null); 
			}
            // Executăm interogarea
            statement.executeUpdate();
			
            System.out.println("Date introduse în baza de date!");
            values.clear();
                
			Map<Integer, Integer> rAdjustments=Map.of(
					51, 70,
					103, 141,
				    177, 200,
				    239, 262,
				    301, 324,
				    336, 347,
				    359, n - 1
					);
					
			Connection connection1 = DatabaseConnection.getConnection(); // Obținem conexiunea la DB
            String insertSQL1 = "INSERT INTO disciplina_zi (cod_disciplina, forma_evaluare, numar_credite_transferabile, nume_disciplina, volum_ore_necesara_pregatiri_individuale, volum_ore_necesare_activitatilor_partial_asistate, categorie_formativa_licenta, numar_ore_curs, numar_ore_laborator, numar_ore_proiect, numar_ore_seminar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Query-ul pentru inserare
            PreparedStatement statement1 = connection1.prepareStatement(insertSQL1);
			
			for(c=1;c<38;c+=12)
			for(r=18;r<n;r++)
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
				
//				if(value.matches("(?i)SEMESTRUL\\s+\\d+"))
//				{
//					currentSemester = value;
//					System.out.println("Detected semester: " + currentSemester);					
//					continue;
//				}
//				else
//				{
//					System.out.println(value);
//					values.add(value);
//				}
				
				System.out.println(value);
				values.add(value);

				if (cell.getCellType() == CellType.FORMULA)
				{
					for (int k=3; k<12; k++)
					{
						Cell cell1=row.getCell(c+k);
						if(cell1==null)
							continue;
				
						String value1=getValue(workbook,cell1);
//						if(value1.isEmpty() || value1.equals("0"))
//							continue;
						
						values.add(value1);

						System.out.println(value1);
					}
					System.out.println("\n");
				}
				
				if (values.size() > 10)
				{
					index=0;
					while (index < values.size()) {
		                // Setăm valorile pentru fiecare coloană
						
		                statement1.setString(4, values.get(index++)); 
		                statement1.setString(1, index < values.size() ? values.get(index++) : null);
		                statement1.setString(3, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(2, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(8, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(11, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(9, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(10, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(6, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(7, index < values.size() ? values.get(index++) : null); 
		                statement1.setString(5, index < values.size() ? values.get(index++) : null);  

					}
		            // Executăm interogarea
		            statement1.executeUpdate();
					
		            System.out.println(values.size() + " Date introduse în baza de date disciplina! \n");
				
				}
			if (values.size()>=11)
					values.clear();
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
