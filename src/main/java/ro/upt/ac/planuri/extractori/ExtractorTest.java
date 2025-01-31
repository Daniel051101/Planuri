package ro.upt.ac.planuri.extractori;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.upt.ac.planuri.disciplina.DisciplinaMaster;
import ro.upt.ac.planuri.disciplina.DisciplinaMasterRepository;
import ro.upt.ac.planuri.plan.PlanInvatamantMaster;
import ro.upt.ac.planuri.plan.PlanInvatamantMasterRepository;

@Component
public class ExtractorTest extends Extractor
{
	


	public void extract(
			)
	{
        List<String> paths = Arrays.asList(
                "./data/licenta/2023-2026_AC_PI_Info_InfoID.xlsx",
                "./data/licenta/2023-2026_AC_PI_Info_InfoZi.xlsx",
                "./data/licenta/2023-2027 AC AIA licenta (anul 1).xlsx ",
                "./data/licenta/2023-2027_AC_PI_C-EN.xlsx",
                "./data/licenta/2023-2027_AC_PI_C-RO.xlsx ",
                "./data/licenta/2023-2027_AC_PI_TI.xlsx " 
        );
        
        extract(paths);
	}
	
	public void extract(String filePath) 
	{
		try (FileInputStream file = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(file))
		{
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFSheet sheet = workbook.getSheetAt(0);
			
			int n = sheet.getLastRowNum();
			int c=0, r=0;			
			
//			for (r=0; r<n; r++)
//			{
//				Row row=sheet.getRow(r);
//				
//				if(row==null)
//					continue;
//				
//				for (c=0; c<50; c++)
//				{
//					Cell cell=row.getCell(c);
//					
//					if(cell==null)
//						continue;
//					
//					String value=getValue(workbook,cell);
//					value=value.replaceAll("\n", " ");
//					
//					if(value.isEmpty() || value.equals("0"))
//						continue;
//					
//					System.out.println(value);
//				}
//			}
			
		    Row row = sheet.getRow(34);
		    Cell cell = row.getCell(9);
		    
		    System.out.println("Valoarea găsită: " +getValue(workbook, cell));

			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}