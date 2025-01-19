package ro.upt.ac.planuri.extractori;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
//import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.nio.file.Path;


// merge la toate cele 12 mastere

@Component
public class ExtractorMaster 
{
	
    private static final Logger log = LoggerFactory.getLogger(ExtractorMaster.class);
    
    public void processAllFiles(String directoryPath) {
        try {
            Path path = Paths.get(directoryPath).toAbsolutePath();
            log.info("Accessing directory: {}", path);

            File directory = path.toFile();
            if (!directory.exists() || !directory.isDirectory()) {
                throw new FileNotFoundException("Directory not found or inaccessible: " + path);
            }

            List<Path> excelFiles = Files.list(path)
                                         .filter(Files::isRegularFile)
                                         .filter(file -> file.toString().endsWith(".xlsx"))
                                         .collect(Collectors.toList());

            log.info("Found {} Excel files in directory: {}", excelFiles.size(), path);

            for (Path filePath : excelFiles) {
                log.info("Processing file: {}", filePath.getFileName());
                extractData(filePath.toString());
            }

            log.info("Finished processing all files.");
        } catch (Exception e) {
            log.error("Error while processing files", e);
        }
    }

//	@SuppressWarnings({ "resource", "incomplete-switch" })
	public void extractData(String filePath) 
	{
        log.info("Starting extraction...", filePath);
		try (FileInputStream file = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(file))
		{	
			
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook1 = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook1.getSheetAt(1);

//			XSSFFormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator(); 
			
//			Iterator<Row> rowIterator = sheet.iterator();
			
			Connection connection = DatabaseConnection.getConnection(); // Obținem conexiunea la DB
            String insertSQL = "INSERT INTO plan_invatamant_master (an_calendaristic, ciclu, cod_domeniu_fundamental, cod_ramura_de_stiinta, codul_programului_de_studii, domeniu_de_licenta, domeniu_fundamental, facultate, ramura_de_stiinta, universitate, cod_domeniu_studii_master, domeniu_studii_master, durata_studiilor, format_invatamant, program_master) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Query-ul pentru inserare
            PreparedStatement statement = connection.prepareStatement(insertSQL);
			
			int n = sheet.getLastRowNum();
			
			int c=0, r=0, index=0;
			
			ArrayList<String> values = new ArrayList<>();
			
			//uni, facultate, coduri
			for(c=0; c<10; c++)
				for (r=0; r<18; r++)
				{
					Row row=sheet.getRow(r);
					
					if(row==null)
						continue;
					
					Cell cell=row.getCell(c);
					
					if(cell==null)
						continue;
					
					if ((c==0 && (r>=5 && r<14)) || (r==15 && (c>=0 && c<7)) )
						continue;
					
					String value=getValue(workbook1,cell);
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
                statement.setString(2, index < values.size() ? values.get(index++) : null); 
                statement.setString(5, index < values.size() ? values.get(index++) : null); 
                statement.setString(1, index < values.size() ? values.get(index++) : null); 
                statement.setString(6, index < values.size() ? values.get(index++) : null); 
                statement.setString(15, index < values.size() ? values.get(index++) : null);
                statement.setString(14, index < values.size() ? values.get(index++) : null);
                statement.setString(13, index < values.size() ? values.get(index++) : null); 
                statement.setString(7, index < values.size() ? values.get(index++) : null); 
                statement.setString(9, index < values.size() ? values.get(index++) : null); 
                statement.setString(12, index < values.size() ? values.get(index++) : null); 

			}
            // Executăm interogarea
            statement.executeUpdate();
			
            System.out.println("Date introduse în baza de date!");
            values.clear();
            
			Map<Integer, Integer> rAdjustments=Map.of(
					52, 64,
					94, 112,
				    141, 150,
				    179, 215,
				    226, 235,
				    246, n-1
					);
			
			Connection connection1 = DatabaseConnection.getConnection(); // Obținem conexiunea la DB
            String insertSQL1 = "INSERT INTO disciplina_master (cod, forma_evaluare, numar_credite_transferabile, nume, volum_ore_necesara_pregatiri_individuale, volum_ore_necesare_activitatilor_partial_asistate, categorie_formativa_master, numar_ore_curs, numar_ore_laborator, numar_ore_proiect, numar_ore_seminar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // Query-ul pentru inserare
            PreparedStatement statement1 = connection1.prepareStatement(insertSQL1);
            
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
				
				String value=getValue(workbook1,cell);
				value=value.replaceAll("\n", " ");
				
				if(value.isEmpty() || value.equals("0"))
					continue;
				
				System.out.println(value);
				values.add(value);

				if (cell.getCellType() == CellType.FORMULA)
				{
					for (int k=3; k<12; k++)
					{
						Cell cell1=row.getCell(c+k);
						if(cell1==null)
							continue;
				
						String value1=getValue(workbook1,cell1);
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
		                statement1.setInt(3, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setString(2, index < values.size() ? values.get(index++) : null); 
		                statement1.setInt(8, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setInt(11, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setInt(9, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setInt(10, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setInt(6, index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
		                statement1.setString(7, index < values.size() ? values.get(index++) : null); 
		                statement1.setInt(5, index < values.size() ? Integer.parseInt(values.get(index++)) : 0);    

					}
		            // Executăm interogarea
		            statement1.executeUpdate();
					
		            System.out.println(values.size() + "   Date introduse în baza de date disciplina! \n");
		                
//					values.clear();
				}
				
				if (values.size()>=11)
					values.clear();

			}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
        log.info("Extraction complete.");
	}
	
	@SuppressWarnings("incomplete-switch")
	public static String getValue(XSSFWorkbook workbook,Cell cell)
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
