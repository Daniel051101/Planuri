package ro.upt.ac.planuri.extractori;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ro.upt.ac.planuri.disciplina.DisciplinaId;
import ro.upt.ac.planuri.disciplina.DisciplinaIdRepository;
import ro.upt.ac.planuri.plan.PlanInvatamantLicenta;
import ro.upt.ac.planuri.plan.PlanInvatamantLicentaRepository;

@Component
public class ExtractorLicentaInfoID
{	
	@Autowired
    PlanInvatamantLicentaRepository planInvatamantLicentaRepository;

    @Autowired
    DisciplinaIdRepository disciplinaIdRepository;
    
//	@SuppressWarnings({ "resource", "incomplete-switch" })
	public void extracDataLicentaInfoID() 
	{
		//System.out.println("Starting...");
		try
		{
			FileInputStream file = new FileInputStream("./data/licenta/2023-2026_AC_PI_Info_InfoID.xlsx ");

			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);

			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(1);
			
			int n = sheet.getLastRowNum();
			int c=0, r=0, index, semesterNumber = 0, semesterMax=0;
			String semesterNumberStr;
		
			PlanInvatamantLicenta pil = new PlanInvatamantLicenta();
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
			
			index=0;
			
            pil.setUniversitate(values.get(index++));
            pil.setFacultate(index < values.size() ? values.get(index++) : null); 
            pil.setCodDomeniuFundamental(index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
            pil.setCodRamuraDeStiinta(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCodDomeniuDeLicenta(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCodStudii(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setCiclu(index < values.size() ? values.get(index++) : null);
            pil.setCodulProgramuluiDeStudii(index < values.size() ? values.get(index++) : null);
            pil.setAnCalendaristic(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pil.setDomeniuFundamental(index < values.size() ? values.get(index++) : null);
            pil.setRamuraDeStiinta(index < values.size() ? values.get(index++) : null);
            pil.setDomeniuDeLicenta(index < values.size() ? values.get(index++) : null);
            pil.setProgramDeStudiiLicenta(index < values.size() ? values.get(index++) : null);
			
            //System.out.println("Date introduse în baza de date!");
            
            values.clear();
                
			Map<Integer, Integer> rAdjustments=Map.of(
					51, 69,
					103, 140,
				    177, 199,
				    239, 261,
				    301, 323,
				    336, 346,
				    359, n - 1
					);
			
			for(c=1;c<38;c+=12)
			for(r=17;r<n;r++)
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
				
				if(value.matches("(?i)SEMESTRUL\\s+\\d+"))
				{
				    // Extragem doar numărul sub formă de String
				    semesterNumberStr = value.replaceAll("(?i)SEMESTRUL\\s+", "");
				    
				    // Convertim șirul în int
				    semesterNumber = Integer.parseInt(semesterNumberStr);
				    
				    if (semesterNumber > semesterMax)
				    	semesterMax = semesterNumber;
				    
				    //System.out.println("Detected semester: " + semesterNumber);
				    continue;
				}
				else
				{
					values.add(value);
					//System.out.println(value);
				}

				if (cell.getCellType() == CellType.FORMULA)
				{
					for (int k=3; k<12; k++)
					{
						Cell cell1=row.getCell(c+k);
						if(cell1==null)
							continue;
				
						String value1=getValue(workbook,cell1);
						
						values.add(value1);

						//System.out.println(value1);
					}
				}
				
				try {
					if (values.size() >= 11)
					{
			            index=0;
						DisciplinaId di = new DisciplinaId();
							
						di.setNume(values.get(index++));
						di.setCod(index < values.size() ? values.get(index++) : null);
						di.setNumarCrediteTransferabile(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setFormaEvaluare(index < values.size() ? values.get(index++) : null);
						di.setNumarOreActivitatiAutoinstruire(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setNumarOreActivitatiTutorat(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setNumarTemeDeControl(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setNumarActivitatiAplicativeAsistate(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setVolumOreNecesareActivitatilorPartialAsistate(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setCategorieFormativaLicenta(index < values.size() ? values.get(index++) : null);
						di.setVolumOreNecesaraPregatiriIndividuale(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
						di.setSemestru(semesterNumber);
							
						disciplinaIdRepository.save(di);
						pil.getListaDisciplinaId().add(di);
											
				        //System.out.println(values.size() + "   Datele disciplinei introduse în baza de date ! \n");

						values.clear();
					}
					
				}catch (NumberFormatException e)
				{
					System.out.println("Invalid format ");

				}
				
			}
			pil.setDurataStudiiLicenta(semesterMax/2);
			
			planInvatamantLicentaRepository.save(pil);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//System.out.println("Stopping... ");
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
