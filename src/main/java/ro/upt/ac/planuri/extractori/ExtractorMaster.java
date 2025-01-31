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
public class ExtractorMaster extends Extractor
{
    @Autowired
    PlanInvatamantMasterRepository planInvatamantMasterRepository;
    
    @Autowired
    DisciplinaMasterRepository disciplinaMasterRepository;

	public void extract()
	{
        List<String> paths = Arrays.asList(
            "./data/master/2023-2025 AC AES masterat.xlsx ",
            "./data/master/2023-2025 AC GD masterat.xlsx ",
            "./data/master/2023-2025 AC ISA masterat.xlsx ",
            "./data/master/2023-2025 AC SIAPS masterat.xlsx ",
            "./data/master/2023-2025 AC SIIS masterat.xlsx ",
            "./data/master/2023-2025 AC SISC masterat.xlsx ",
            "./data/master/2023-2025_AC_PI_Info_TI.xlsx ",
            "./data/master/2023-2025_AC_PI_Master_CI.xlsx ",
            "./data/master/2023-2025_AC_PI_Master_IT.xlsx ",
            "./data/master/2023-2025_AC_PI_Master_ML.xlsx ",
            "./data/master/2023-2025_AC_PI_Master_SE.xlsx "
        );
        extract(paths);
	}
	
	public void extract(String filePath) 
	{
		try (FileInputStream file = new FileInputStream(filePath);
	             XSSFWorkbook workbook = new XSSFWorkbook(file))
		{
			IOUtils.setByteArrayMaxOverride(Integer.MAX_VALUE);
			XSSFSheet sheet = workbook.getSheetAt(1);
			
			int n = sheet.getLastRowNum();
			int c=0, r=0, index=0, semesterNumber = 0;
			String semesterNumberStr, durataStr;
			
			PlanInvatamantMaster pim = new PlanInvatamantMaster();
			ArrayList<String> values = new ArrayList<>();
			
			//uni, facultate, coduri
			for(c=0; c<10; c++)
			{
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
					
					String value=getValue(workbook,cell);
					value=value.replaceAll("\n", " ");
					
					if(value.isEmpty() || value.equals("0"))
						continue;
					
					if (value.matches("(?i)\\d+\\s+ani"))
					{
						durataStr = value.replaceAll("(?i)\\s+ani", "");
						values.add(durataStr);	
						continue;
					}
					else
					{
						values.add(value);
						//System.out.println(value);
					}
				}
			}
            index=0;
            
            pim.setUniversitate(values.get(index++));
            pim.setFacultate(index < values.size() ? values.get(index++) : null); 
            pim.setCodDomeniuFundamental(index < values.size() ? Integer.parseInt(values.get(index++)) : 0); 
            pim.setCodRamuraDeStiinta(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pim.setCodDomeniuStudiiMaster(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pim.setCiclu(index < values.size() ? values.get(index++) : null);
            pim.setCodulProgramuluiDeStudii(index < values.size() ? values.get(index++) : null);
            pim.setAnCalendaristic(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pim.setDomeniuDeLicenta(index < values.size() ? values.get(index++) : null);
            pim.setProgramMaster(index < values.size() ? values.get(index++) : null);
            pim.setFormatInvatamant(index < values.size() ? values.get(index++) : null);
            pim.setDurataStudiilor(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
            pim.setDomeniuFundamental(index < values.size() ? values.get(index++) : null);
            pim.setRamuraDeStiinta(index < values.size() ? values.get(index++) : null);
            pim.setDomeniuStudiiMaster(index < values.size() ? values.get(index++) : null);
			
            //System.out.println("Datele planului introduse în baza de date!");
            values.clear();
            
			Map<Integer, Integer> rAdjustments=Map.of(
					52, 63,
					94, 111,
				    141, 149,
				    180, 214,
				    226, 234,
				    246, n-1
					);
            
			for(c=1;c<14;c+=12)
			{
				for(r=21;r<n;r++)
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
					    semesterNumberStr = value.replaceAll("(?i)SEMESTRUL\\s+", "");
					    semesterNumber = Integer.parseInt(semesterNumberStr);
					    continue;
					    //System.out.println("Detected semester: " + semesterNumber);
					}
					else
					{
						values.add(value);
						//System.out.println(value);
					}
	
					if (cell.getCellType() == CellType.FORMULA  || value.equals("Valoare indisponibilă"))
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
					
					DisciplinaMaster dm = new DisciplinaMaster();
					try 
					{
						if (values.size() >= 11)
						{
				            index=0;
								
							dm.setNume(values.get(index++));
							dm.setCod(index < values.size() ? values.get(index++) : null);
							dm.setNumarCrediteTransferabile(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setFormaEvaluare(index < values.size() ? values.get(index++) : null);
							dm.setNumarOreCurs(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setNumarOreSeminar(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setNumarOreLaborator(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setNumarOreProiect(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setVolumOreNecesareActivitatilorPartialAsistate(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setCategorieFormativaMaster(index < values.size() ? values.get(index++) : null);
							dm.setVolumOreNecesaraPregatiriIndividuale(index < values.size() ? Integer.parseInt(values.get(index++)) : 0);
							dm.setSemestru(semesterNumber);							
							pim.getListaDisciplinaMaster().add(dm);
					        //System.out.println(values.size() + "   Datele disciplinei introduse în baza de date ! \n");
							values.clear();
							
							disciplinaMasterRepository.save(dm);
						}
					}
					catch (NumberFormatException e)
					{
						System.out.println("Invalid format: "+dm.toString());
					}
				}
			}
			planInvatamantMasterRepository.save(pim);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
}
